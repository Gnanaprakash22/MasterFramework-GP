package com.tmb.pages.web.electra.loginpage;

import com.tmb.pages.web.electra.dashboard.DashboardPage;
import com.tmb.utils.WaitUtils;
import org.openqa.selenium.By;

import static com.tmb.utils.PageActionsHelper.waitAndClick;
import static com.tmb.utils.PageActionsHelper.waitAndSendKeys;

public class LoginPage {

  private static final By EMAIL_TEXTBOX = By.cssSelector("input[id='user-password-sign-in-with-password_email']");
  private static final By PASSWORD_TEXTBOX = By.cssSelector("input[id='user-password-sign-in-with-password_password']");
  private static final By SIGN_IN_BUTTON = By.cssSelector("button[type='submit']");

  private LoginPage enterUserNameTextBox(String userName) {
    waitAndSendKeys(EMAIL_TEXTBOX, userName);
    return this;
  }

  private LoginPage enterPasswordTextBox(String password) {
    WaitUtils.waitFor(1, "Waiting");
    waitAndSendKeys(PASSWORD_TEXTBOX, password);
    return this;
  }

  private DashboardPage clickOnSignIn() {
    waitAndClick(SIGN_IN_BUTTON);
    return new DashboardPage();
  }

  public DashboardPage login(String email, String password) {
    return enterUserNameTextBox(email)
      .enterPasswordTextBox(password)
      .clickOnSignIn();
  }

}
