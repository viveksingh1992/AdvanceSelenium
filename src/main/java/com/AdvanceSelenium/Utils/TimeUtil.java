package com.AdvanceSelenium.Utils;

public class TimeUtil {

	public static Long getImplicitWait() {
		return Long.parseLong(PropertyReader.getInstance().getProperty(PropKey.IMPLICIT_WAIT.getPropVal()));
	}

	public static Long getExplicitWait() {
		return Long.parseLong(PropertyReader.getInstance().getProperty(PropKey.EXPLICIT_WAIT.getPropVal()));
	}
}
