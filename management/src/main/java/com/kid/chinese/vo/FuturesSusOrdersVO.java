package com.kid.chinese.vo;

import java.util.List;

import com.kid.chinese.model.FuturesClose;
import com.kid.chinese.model.FuturesOrders;
import com.kid.chinese.model.FuturesSusOrders;

public class FuturesSusOrdersVO{
	private List<FuturesSusOrders> susOrdersList;

	public List<FuturesSusOrders> getSusOrdersList() {
		return susOrdersList;
	}

	public void setSusOrdersList(List<FuturesSusOrders> susOrdersList) {
		this.susOrdersList = susOrdersList;
	}

}
