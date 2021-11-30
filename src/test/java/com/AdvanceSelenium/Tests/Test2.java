package com.AdvanceSelenium.Tests;

import org.junit.jupiter.api.Test;

import com.AdvanceSelenium.Driver.DriverManager;
import com.AdvanceSelenium.Utils.PropKey;

//@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class Test2 extends DriverManager {

	@Test
//	@DisplayName("First advance test")
	void first_advance_test() {

		driver.get(prop.getProperty(PropKey.URL.getPropVal()));

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
