package com.tmb.pages.web.electra.dashboard;

import com.tmb.pages.web.electra.validator.DashboardPageValidator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.tmb.utils.PageActionsHelper.isPresent;

public class DashboardPage {

  private static final By HOME_ICON = By.cssSelector("span.hero-home.w-4.h-4");
  private static final By SEARCH_TEXTBOX = By.xpath("//input[@placeholder='Search']");

  public boolean isHomeIconDisplayed() {
    return isPresent(HOME_ICON, WebElement::isDisplayed);
  }

  public boolean isSearchDisplayed() {
    return isPresent(SEARCH_TEXTBOX, WebElement::isDisplayed);
  }

  public DashboardPageValidator getDashboardPageValidator() {
    return DashboardPageValidator.builder()
      .searchDisplayed(isSearchDisplayed())
      .homeIconDisplayed(isHomeIconDisplayed())
      .build();
  }

}
