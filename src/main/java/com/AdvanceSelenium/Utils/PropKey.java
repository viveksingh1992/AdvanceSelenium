package com.AdvanceSelenium.Utils;

public enum PropKey {

	URL("url"), BROWSER("browser"), IMPLICIT_WAIT("implicitWait"), EXPLICIT_WAIT("explicitWait");

	private String propVal;

	PropKey(String propVal) {
		this.propVal = propVal;
	}

	public String getPropVal() {
		return propVal;
	}

}
