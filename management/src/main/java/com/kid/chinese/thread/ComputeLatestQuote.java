package com.kid.chinese.thread;

import java.util.concurrent.ConcurrentHashMap;

import com.kid.chinese.fix.FixApplication;
import com.kid.chinese.util.Variable;
import com.kid.chinese.vo.FuturesQuoteVO;

public class ComputeLatestQuote implements Runnable {

	private boolean isReady = false;
	//private FixApplication fixApplication;
	///private ConcurrentHashMap<String,FuturesQuoteVO> quoteMap;
	public boolean isReady() {
		return isReady;
	}

	public void setReady(boolean isReady) {
		this.isReady = isReady;
	}

	public ComputeLatestQuote() {
		//this.fixApplication = fixApplication;
	}
	@Override
	public void run() {
		while (true) {
			try {
				if (!Variable.getFuturesQuoteQueue().isEmpty()&&isReady) {
					//FuturesQuoteVO quote = fixApplication.getFuturesQuoteQueue().poll();
					//if(quote!=null&&!quote.getInstrumentID().equals("")){
						//quoteMap.put(quote.getInstrumentID(),quote);
					//}
				}else{
					Thread.sleep(1);
				}
			} catch (InterruptedException e) {
				System.out.println("Thread interrupted...");
			}
		}
	}
}
