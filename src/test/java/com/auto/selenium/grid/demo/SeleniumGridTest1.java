package com.auto.selenium.grid.demo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SeleniumGridTest1 {
	@Test
	public void testChrome() throws MalformedURLException, InterruptedException {
		DesiredCapabilities chromeDC = DesiredCapabilities.chrome();
		WebDriver driver = new RemoteWebDriver(new URL("http://172.17.0.1:5555/wd/hub"), chromeDC);
		driver.get("http://www.baidu.com");
		Thread.sleep(5000);
		driver.quit();
	}

	// 启动192.168.84.19:5555 node节点的firefox
	@Test
	public void testFF() throws MalformedURLException, InterruptedException {
		DesiredCapabilities firefoxDC = DesiredCapabilities.firefox();
		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.84.19:5555/wd/hub"), firefoxDC);
		driver.get("http://www.baidu.com");
		Thread.sleep(5000);
		driver.quit();
	}

	// 启动192.168.84.19:5555 node节点的IE
	@Test
	public void testIE() throws MalformedURLException, InterruptedException {
		DesiredCapabilities ieDC = DesiredCapabilities.internetExplorer();
		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.84.19:5555/wd/hub"), ieDC);
		driver.get("http://www.baidu.com");
		Thread.sleep(5000);
		driver.quit();
	}
}
