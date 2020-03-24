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
import com.kid.chinese.model.TbCourse;
import com.kid.chinese.model.TbCourseCategory;
import com.kid.chinese.model.TbTeacher;
import com.kid.chinese.service.ICourseCategoryService;
import com.kid.chinese.service.ICourseService;
import com.kid.chinese.service.ITeacherService;
import com.kid.chinese.util.CodeUtil;
import com.kid.chinese.util.Constants;
import com.kid.chinese.util.DateUtil;
import com.kid.chinese.util.MD5;
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
public class CourseController {
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/m-course.html", method = RequestMethod.GET)
	public String m_course(HttpServletRequest request, ModelMap model) {
		try {
			String name = "";
			if (null != request.getParameter("name")) {
				name = (String) request.getParameter("name");
			}
			int total = courseService.findAllTbCourseCount(name).intValue();
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
			page.setPageAction("m_course.html?name=" + name + "&");
			model.addAttribute("page", page);
			model.addAttribute("name", name);
			List dataList = courseService.findAllTbCourse(page.getStartRow(), pageSize, name);
			model.addAttribute("dataList", dataList);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "m-course";
	}

	@RequestMapping(value = "/m-course-category.html", method = RequestMethod.GET)
	public String m_course_category(HttpServletRequest request, ModelMap model) {
		try {
			String name = "";
			if (null != request.getParameter("name")) {
				name = (String) request.getParameter("name");
			}
			int total = courseCategoryService.findAllTbCourseCategoryCount(name).intValue();
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
			page.setPageAction("m-course-category.html?name=" + name + "&");
			model.addAttribute("page", page);
			model.addAttribute("name", name);
			List dataList = courseCategoryService.findAllTbCourseCategory(page.getStartRow(), pageSize, name);
			model.addAttribute("dataList", dataList);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "m-course-category";
	}

	@RequestMapping(value = "/m-course-category-e.html", method = RequestMethod.GET)
	public String m_course_category_e(HttpServletRequest request, ModelMap model) {
		try {
			Long id = Long.parseLong(request.getParameter("id"));
			TbCourseCategory tbCourseCategory = courseCategoryService.findOne(id);
			model.addAttribute("tbCourseCategory", tbCourseCategory);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "m-course-category-e";
	}
	
	@RequestMapping(value = "/m-course-category-a.html", method = RequestMethod.GET)
	public String m_course_category_a(HttpServletRequest request, ModelMap model) {
		try {
			TbCourseCategory tbCourseCategory = new TbCourseCategory();
			model.addAttribute("tbCourseCategory", tbCourseCategory);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "m-course-category-e";
	}
	
	@RequestMapping(value = "/m-course-a.html", method = RequestMethod.GET)
	public String m_course_a(HttpServletRequest request, ModelMap model) {
		try {
			TbCourse tbCourse = new TbCourse();
			model.addAttribute("tbCourse", tbCourse);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "m-course-e";
	}
	
	@RequestMapping(value = "/m_course_e.html", method = RequestMethod.GET)
	public String m_course_e(HttpServletRequest request, ModelMap model) {
		try {
			Long id = Long.parseLong(request.getParameter("id"));
			TbCourse tbCourse = courseService.findOne(id);
			model.addAttribute("tbCourse", tbCourse);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "m-course-e";
	}
	
	
	@RequestMapping(value = "/saveCourseCategory.html", method = RequestMethod.POST)
	public String saveCourseCategory(MultipartFile image, HttpServletRequest request, ModelMap model,
			TbCourseCategory tbCourseCategoryTemp) {
		try {
			String realpath = request.getServletContext().getRealPath("/file/");
			TbCourseCategory tbCourseCategory;
			if (tbCourseCategoryTemp.getId() != null && tbCourseCategoryTemp.getId().longValue() != 0L) {
				Long id = Long.parseLong(request.getParameter("id"));
				tbCourseCategory = courseCategoryService.findOne(id);
				TbCourseCategory tbCourseCategoryTemp2 = courseCategoryService.findAllTbCourseCategoryByCode(tbCourseCategoryTemp.getCoursecode());
				if (tbCourseCategoryTemp2 != null && tbCourseCategoryTemp2.getId().longValue() != id.longValue()) {
					request.setAttribute("result", "course.category.exist");
					return "result";
				}
			} else {
				tbCourseCategory = new TbCourseCategory();
				tbCourseCategory.setCreate_date(DateUtil.getLongDate(Calendar.getInstance()));
			}
			tbCourseCategory.setCoursecode(tbCourseCategoryTemp.getCoursecode());
			tbCourseCategory.setCoursename(tbCourseCategoryTemp.getCoursename());
			tbCourseCategory.setDescription(tbCourseCategoryTemp.getDescription());
			tbCourseCategory.setStatus(tbCourseCategoryTemp.getStatus());
			tbCourseCategory.setUpdate_date(DateUtil.getLongDate(Calendar.getInstance()));
			boolean result = courseCategoryService.saveTbCourseCategory(tbCourseCategory);
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
	

	@Resource(name = "teacherService")
	private ITeacherService teacherService;
	@Resource(name = "courseCategoryService")
	private ICourseCategoryService courseCategoryService;
	@Resource(name = "courseService")
	private ICourseService courseService;
}
