package com.tmb.tests.web.base.electra.dashboard;

import com.tmb.pages.web.electra.loginpage.LoginPage;
import com.tmb.pages.web.electra.validator.DashboardPageValidator;
import com.tmb.tests.web.base.WebSetup;
import org.junit.jupiter.api.Test;

class DashboardTest extends WebSetup {

  @Test
  void testDashboardPageComponents() {
    DashboardPageValidator dashboardPageValidator = new LoginPage()
      .login("james.pereira@edgehq.in", "james@edge")
      .getDashboardPageValidator();
    DashboardAssert.assertThat(dashboardPageValidator)
      .isDashboardLoaded().assertAll();
  }
}
