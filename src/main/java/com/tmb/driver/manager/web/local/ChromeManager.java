package com.tmb.driver.manager.web.local;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public final class ChromeManager {

  private ChromeManager() {
  }

  public static WebDriver getDriver() {
    return new ChromeDriver();
  }
}
