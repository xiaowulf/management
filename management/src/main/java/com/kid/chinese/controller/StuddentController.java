package com.kid.chinese.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.kid.chinese.model.RtnResultVO;
import com.kid.chinese.model.TbStudent;
import com.kid.chinese.model.TbTeacher;
import com.kid.chinese.service.ICourseCategoryService;
import com.kid.chinese.service.IStudentService;
import com.kid.chinese.service.ITeacherService;
import com.kid.chinese.util.CodeUtil;
import com.kid.chinese.util.Constants;
import com.kid.chinese.util.MD5;
import com.kid.chinese.util.MailUtil;
import com.kid.chinese.util.MathUtil;
import com.kid.chinese.util.Page;
import com.kid.chinese.util.PagerHelp;
import com.kid.chinese.util.PropertiesUtil;
import com.kid.chinese.vo.AtrVO;
import com.kid.chinese.vo.CandleVO;
import com.kid.chinese.vo.FuturesPriceVO;
import com.kid.chinese.vo.FuturesQuoteVO;
import com.kid.chinese.vo.FuturesStatistics;
import com.kid.chinese.vo.MacdVO;
import com.kid.chinese.vo.MaxMinPriceVO;

@Controller
public class StuddentController {
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/m-student.html", method = RequestMethod.GET)
	public String analyse(HttpServletRequest request, ModelMap model) {
		try {
			String name = "";
			if (null != request.getParameter("name")) {
				name = (String) request.getParameter("name");
			}
			int total = studentService.findAllTbStudentCount(name).intValue();
			Page page = null;
			int currentPage = 1;
			if (null != request.getParameter("currentPage")) {
				currentPage = Integer.parseInt(request.getParameter("currentPage"));
			}
			int pageSize = Constants.pageSize;
			page = PagerHelp.getPager(request, total, pageSize);
			if (currentPage <= 1) {
				page.setLastPage(1);
			} else {
				page.setLastPage(currentPage - 1);
			}
			if (currentPage < page.getTotalPages()) {
				page.setNextPage(currentPage + 1);
			} else {
				page.setNextPage(page.getTotalPages());
			}
			page.setPageAction("m-teacher.html?name=" + name + "&");
			model.addAttribute("page", page);
			model.addAttribute("name", name);
			List dataList = studentService.findAllTbStudent(page.getStartRow(), pageSize, name);
			model.addAttribute("dataList", dataList);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "m-student";

	}

	// 编辑老师的资料
	@RequestMapping(value = "/m-student-e.html", method = RequestMethod.GET)
	public String m_teacher_e(HttpServletRequest request, ModelMap model) {
		try {
			Long id = Long.parseLong(request.getParameter("id"));
			TbStudent tbStudent = studentService.findOne(id);
			model.addAttribute("tbStudent", tbStudent);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "m-student-e";
	}

	// 新增老师的资料
	@RequestMapping(value = "/m-student-a.html", method = RequestMethod.GET)
	public String m_student_a(HttpServletRequest request, ModelMap model) {
		try {
			TbStudent tbStudent = new TbStudent();
			model.addAttribute("tbStudent", tbStudent);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "m-student-e";
	}

	// 新增学生的资料
	@RequestMapping(value = "/saveStudent.html", method = RequestMethod.POST)
	public String saveStudent(MultipartFile image, HttpServletRequest request, ModelMap model,
			TbTeacher tbTeacherTemp) {
		try {
			String realpath = request.getServletContext().getRealPath("/file/");
			TbStudent tbStudent;
			if (tbTeacherTemp.getId() != null && tbTeacherTemp.getId().longValue() != 0L) {
				Long id = Long.parseLong(request.getParameter("id"));
				tbStudent = studentService.findOne(id);
				TbStudent tbStudentTemp2 = studentService.findAllTbStudentByUsername(tbTeacherTemp.getUsername());
				if (tbStudentTemp2 != null && tbStudentTemp2.getId().longValue() != id.longValue()) {
					request.setAttribute("result", "student.exist");
					return "result";
				}
			} else {
				tbStudent = new TbStudent();
			}
			if (image != null) {
				String fileName = image.getOriginalFilename();
				if (fileName != null && !fileName.equals("")) {
					File savedir = new File(realpath);
					if (!savedir.getParentFile().exists()) {
						savedir.getParentFile().mkdirs();
					}
					Long millSeconds = Calendar.getInstance().getTimeInMillis();
					tbStudent.setPic1("file/" + millSeconds + fileName);
					PropertiesUtil propertiesUtil = new PropertiesUtil();
					String fileupload = propertiesUtil.getfileConfigValueByKey("fileupload");
					image.transferTo(new File(fileupload + millSeconds + fileName));
				}
			}
			tbStudent.setUsername(tbTeacherTemp.getUsername());
			tbStudent.setTruename(tbTeacherTemp.getTruename());
			tbStudent.setEmail(tbTeacherTemp.getEmail());
			tbStudent.setIdcard(tbTeacherTemp.getIdcard());
			tbStudent.setEducation(tbTeacherTemp.getEducation());
			tbStudent.setMobile(tbTeacherTemp.getMobile());
			tbStudent.setPassword(MD5.getMD5Str(MD5.getRandomString(6)));
			tbStudent.setSex(tbTeacherTemp.getSex());
			tbStudent.setBirthday(tbTeacherTemp.getBirthday());
			tbStudent.setStatus(tbTeacherTemp.getStatus());
			boolean result = studentService.saveTbStudent(tbStudent);
			if (result) {
				request.setAttribute("result", "system.success");
			} else {
				request.setAttribute("result", "system.failure");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "result";
	}

	@RequestMapping(value = "/changeStudentPwd.html", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String changeStudentPwd(HttpServletRequest request, ModelMap model, TbStudent tbStudentTemp) {
		RtnResultVO rtnResultVO = new RtnResultVO();
		if(null!=tbStudentTemp&&tbStudentTemp.getId()!=null) {
			TbStudent tbStudent = studentService.findOne(tbStudentTemp.getId());
			String pwd = MailUtil.getNumber();
			tbStudent.setPassword(MD5.getMD5Str(pwd));
			MailUtil mailUtil = new MailUtil();
			mailUtil.sendEmil(tbStudent.getEmail(), "修改密码成功", pwd);
			studentService.saveTbStudent(tbStudent);
		}
		Gson gson = new Gson();
		rtnResultVO.setResultStatus("0");
		String json = gson.toJson(rtnResultVO);
		return json;
	}
	
	
	@Resource(name = "teacherService")
	private ITeacherService teacherService;
	@Resource(name = "studentService")
	private IStudentService studentService;
	@Resource(name = "courseCategoryService")
	private ICourseCategoryService courseCategoryService;

}
