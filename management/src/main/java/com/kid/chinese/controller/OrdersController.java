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
import com.kid.chinese.model.FuturesClose;
import com.kid.chinese.model.FuturesOrders;
import com.kid.chinese.model.FuturesStrategy;
import com.kid.chinese.model.FuturesSusOrders;
import com.kid.chinese.service.IFuturesCloseService;
import com.kid.chinese.service.IFuturesMessageService;
import com.kid.chinese.service.IFuturesOrdersService;
import com.kid.chinese.service.IFuturesStrategyService;
import com.kid.chinese.service.IFuturesSusOrdersService;
import com.kid.chinese.util.CodeUtil;
import com.kid.chinese.util.MathUtil;
import com.kid.chinese.vo.AtrVO;
import com.kid.chinese.vo.CandleVO;
import com.kid.chinese.vo.FuturesOrdersVO;
import com.kid.chinese.vo.FuturesPriceVO;
import com.kid.chinese.vo.FuturesQuoteVO;
import com.kid.chinese.vo.FuturesStatistics;
import com.kid.chinese.vo.FuturesStrategyVO;
import com.kid.chinese.vo.FuturesSusOrdersVO;
import com.kid.chinese.vo.MacdVO;
import com.kid.chinese.vo.MaxMinPriceVO;

@Controller
public class OrdersController {
	
	@RequestMapping(value = "/findStrategy.html", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String findStrategy(HttpServletRequest request, ModelMap model) {
		List<FuturesStrategy> strategyList = futuresStrategyService.findAll();
		FuturesStrategyVO futuresStrategyVO = new FuturesStrategyVO();
		futuresStrategyVO.setStrategyList(strategyList);
		Gson gson = new Gson();
		String json = gson.toJson(futuresStrategyVO);
		return json;
	}
	
	@RequestMapping(value = "/findPosition.html", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String findPosition(HttpServletRequest request, ModelMap model) {
		List<FuturesOrders> ordersList = futuresOrdersService.findAll();
		FuturesOrdersVO futuresOrdersVO = new FuturesOrdersVO();
		futuresOrdersVO.setOrdersList(ordersList);
		Gson gson = new Gson();
		String json = gson.toJson(futuresOrdersVO);
		return json;
	}
	@RequestMapping(value = "/findClosePosition.html", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String findClosePosition(HttpServletRequest request, ModelMap model) {
		List<FuturesClose> closeList = futuresCloseService.findAll();
		FuturesOrdersVO futuresOrdersVO = new FuturesOrdersVO();
		futuresOrdersVO.setCloseList(closeList);
		Gson gson = new Gson();
		String json = gson.toJson(futuresOrdersVO);
		return json;
	}
	@RequestMapping(value = "/findSusPosition.html", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String findSusPosition(HttpServletRequest request, ModelMap model) {
		List<FuturesSusOrders> susOrdersList = futuresSusOrdersService.findAll();
		FuturesSusOrdersVO futuresSusOrdersVO = new FuturesSusOrdersVO();
		futuresSusOrdersVO.setSusOrdersList(susOrdersList);
		Gson gson = new Gson();
		String json = gson.toJson(futuresSusOrdersVO);
		return json;
	}
	
	
	@Resource(name="futuresStrategyService")
    private IFuturesStrategyService futuresStrategyService;
	@Resource(name="futuresOrdersService")
    private IFuturesOrdersService futuresOrdersService;
	@Resource(name="futuresCloseService")
    private IFuturesCloseService futuresCloseService;
	@Resource(name="futuresSusOrdersService")
    private IFuturesSusOrdersService futuresSusOrdersService;
	
}
