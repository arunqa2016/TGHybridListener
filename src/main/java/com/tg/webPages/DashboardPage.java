package com.tg.webPages;

import com.tg.base.Base;

public class DashboardPage extends Base {
	
	public String validateDashboardPageTitle() {
		return driver.getTitle();
	}

}
