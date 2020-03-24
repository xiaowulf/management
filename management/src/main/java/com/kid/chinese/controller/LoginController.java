package com.kid.chinese.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.kid.chinese.fix.FixApplication;
import com.kid.chinese.model.TbEmployee;
import com.kid.chinese.model.ChangePwdForm;
import com.kid.chinese.model.FuturesMessage;
import com.kid.chinese.model.LoginCommand;
import com.kid.chinese.model.RtnResultVO;
import com.kid.chinese.service.IEmployeeService;
import com.kid.chinese.service.IFuturesMessageService;
import com.kid.chinese.util.CodeUtil;
import com.kid.chinese.util.FileUtil;
import com.kid.chinese.util.InitUtil;
import com.kid.chinese.util.MD5;
import com.kid.chinese.util.MathUtil;
import com.kid.chinese.vo.CandleVO;
import com.kid.chinese.vo.FuturesPriceVO;
import com.kid.chinese.vo.FuturesQuoteVO;
import com.kid.chinese.vo.SuggestVO;

@Controller
public class LoginController {
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/login.html", method = RequestMethod.GET)
	public String login(HttpServletRequest request, ModelMap model) {
		return "login";
	}

	@RequestMapping(value = "/main.html", method = RequestMethod.GET)
	public String main(HttpServletRequest request, ModelMap model) {
		return "main";
	}

	@RequestMapping(value = "/m-password.html", method = RequestMethod.GET)
	public String mpassword(FuturesMessage futuresMessage) {
		return "m-password";
	}

	@RequestMapping(value = "/changePwd.html", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String changePwd(HttpServletRequest request, ModelMap model, ChangePwdForm changePwdForm) {
		RtnResultVO rtnResultVO = new RtnResultVO();
		if (changePwdForm.getOldpassword() == null || changePwdForm.getOldpassword().equals("")) {
			rtnResultVO.setResultStatus("-1");
		} else if (changePwdForm.getNewpassword() == null || changePwdForm.getNewpassword().equals("")) {
			rtnResultVO.setResultStatus("-2");
		} else if (changePwdForm.getConfirmpassword() == null || changePwdForm.getConfirmpassword().equals("")) {
			rtnResultVO.setResultStatus("-3");
		} else if (!changePwdForm.getNewpassword().equals(changePwdForm.getConfirmpassword())) {
			rtnResultVO.setResultStatus("-4");
		} else {
			TbEmployee tbEmployee = (TbEmployee) request.getSession().getAttribute("tbEmployee");
			if (!tbEmployee.getPassword().equals(MD5.getMD5Str(changePwdForm.getOldpassword()))) {
				rtnResultVO.setResultStatus("-5");
			} else {
				rtnResultVO.setResultStatus("0");
				tbEmployee.setPassword(MD5.getMD5Str(changePwdForm.getNewpassword()));
				employeeService.saveTbEmployee(tbEmployee);
			}
		}
		Gson gson = new Gson();
		String json = gson.toJson(rtnResultVO);
		return json;
	}

	@RequestMapping(value = "/logout.html", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String logout(HttpServletRequest request, ModelMap model, ChangePwdForm changePwdForm) {
		RtnResultVO rtnResultVO = new RtnResultVO();
		try {
			request.getSession().removeAttribute("tbEmployee");
			rtnResultVO.setResultStatus("0");
		}catch(Exception e) {
			e.printStackTrace();
			rtnResultVO.setResultStatus("-1");
		}
		Gson gson = new Gson();
		String json = gson.toJson(rtnResultVO);
		return json;
	}

	@RequestMapping(value = "/loginCheck.html", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String changeFuturesJys(HttpSession session, ModelMap model, LoginCommand loginCommand) {
		String verycode = (String) session.getAttribute("verycode");
		RtnResultVO rtnResultVO = new RtnResultVO();
		if (null == verycode || null == loginCommand.getVerycode()
				|| !verycode.equals(loginCommand.getVerycode().toUpperCase())) {
			rtnResultVO.setResultStatus("-3");
			rtnResultVO.setResultMessage("verycode is error");
		} else if (null == loginCommand.getUserName() || null == loginCommand.getPassword()
				|| "".equals(loginCommand.getUserName()) || "".equals(loginCommand.getPassword())) {
			rtnResultVO.setResultStatus("-4");
			rtnResultVO.setResultMessage("用户名和密码不可以为空");
		} else {
			TbEmployee tbEmployee = employeeService.findEmployeeByNameAndPwd(loginCommand.getUserName(),
					MD5.getMD5Str(loginCommand.getPassword()));
			if (null != tbEmployee) {
				rtnResultVO.setResultStatus("1");
				rtnResultVO.setResultMessage("success");
				session.setAttribute("tbEmployee", tbEmployee);
			} else {
				rtnResultVO.setResultStatus("-1");
				rtnResultVO.setResultMessage("username or password is not correct");
			}
		}
		Gson gson = new Gson();
		String json = gson.toJson(rtnResultVO);
		return json;
	}

	@Resource(name = "employeeService")
	private IEmployeeService employeeService;

}
