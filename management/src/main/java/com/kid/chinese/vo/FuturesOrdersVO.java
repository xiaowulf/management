package com.kid.chinese.vo;

import java.util.List;

import com.kid.chinese.model.FuturesClose;
import com.kid.chinese.model.FuturesOrders;

public class FuturesOrdersVO{
	private List<FuturesOrders> ordersList;
	private List<FuturesClose> closeList;
	public List<FuturesOrders> getOrdersList() {
		return ordersList;
	}

	public void setOrdersList(List<FuturesOrders> ordersList) {
		this.ordersList = ordersList;
	}

	public List<FuturesClose> getCloseList() {
		return closeList;
	}

	public void setCloseList(List<FuturesClose> closeList) {
		this.closeList = closeList;
	}

	
}
