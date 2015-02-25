package com.qa.shopkick.utils;

public class CustomHooks extends AbstractPage{

	public static void pressBack(){
		driver.navigate().back();
	}

	public static void waitFor(int seconds){
		int millSeconds = seconds*1000;
		try {
			Thread.sleep(millSeconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
