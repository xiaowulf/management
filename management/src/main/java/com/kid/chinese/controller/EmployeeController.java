package com.kid.chinese.controller;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.util.ArrayList;
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

import com.google.gson.Gson;
import com.kid.chinese.fix.FixApplication;
import com.kid.chinese.model.TbEmployee;
import com.kid.chinese.model.TbTeacher;
import com.kid.chinese.service.IEmployeeService;
import com.kid.chinese.service.ITeacherService;
import com.kid.chinese.util.CodeUtil;
import com.kid.chinese.util.Constants;
import com.kid.chinese.util.MD5;
import com.kid.chinese.util.MathUtil;
import com.kid.chinese.util.Page;
import com.kid.chinese.util.PagerHelp;
import com.kid.chinese.vo.AtrVO;
import com.kid.chinese.vo.CandleVO;
import com.kid.chinese.vo.FuturesPriceVO;
import com.kid.chinese.vo.FuturesQuoteVO;
import com.kid.chinese.vo.FuturesStatistics;
import com.kid.chinese.vo.MacdVO;
import com.kid.chinese.vo.MaxMinPriceVO;

@Controller
public class EmployeeController {
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/m-employee.html", method = RequestMethod.GET)
	public String employee(HttpServletRequest request, ModelMap model) {
		try {
			String name = "";
			if (null != request.getParameter("name")) {
				name = (String) request.getParameter("name");
			}
			int total = employeeService.findAllTbEmployeeCount(name).intValue();
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
			page.setPageAction("m-employee.html?name=" + name + "&");
			model.addAttribute("page", page);
			model.addAttribute("name", name);
			List dataList = employeeService.findAllTbEmployee(page.getStartRow(), pageSize, name);
			model.addAttribute("dataList", dataList);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "m-employee";
	}

	// 编辑老师的资料
	@RequestMapping(value = "/m-employee-e.html", method = RequestMethod.GET)
	public String m_employee_e(HttpServletRequest request, ModelMap model) {
		try {
			Long id = Long.parseLong(request.getParameter("id"));
			TbEmployee tbEmployee = employeeService.findOne(id);
			model.addAttribute("tbEmployee", tbEmployee);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "m-employee-e";
	}

	// 新增老师的资料
	@RequestMapping(value = "/m-employee-a.html", method = RequestMethod.GET)
	public String m_employee_a(HttpServletRequest request, ModelMap model) {
		try {
			TbEmployee tbEmployee = new TbEmployee();
			model.addAttribute("tbEmployee", tbEmployee);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "m-employee-e";
	}

	@Resource(name = "employeeService")
	private IEmployeeService employeeService;

}
