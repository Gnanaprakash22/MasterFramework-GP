package com.tmb.tests.web.base.electra.dashboard;

import com.tmb.pages.web.electra.validator.DashboardPageValidator;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.SoftAssertions;

public class DashboardAssert extends AbstractAssert<DashboardAssert, DashboardPageValidator> {

  private final SoftAssertions softAssertions;

  private DashboardAssert(DashboardPageValidator dashboardPageValidator) {
    super(dashboardPageValidator, DashboardAssert.class);
    softAssertions = new SoftAssertions();
  }

  public static DashboardAssert assertThat(DashboardPageValidator dashboardPageValidator) {
    return new DashboardAssert(dashboardPageValidator);
  }

  public DashboardAssert isDashboardLoaded() {
    softAssertions.assertThat(actual.isSearchDisplayed())
      .withFailMessage(() -> "Search is not displayed")
      .isTrue();
    softAssertions.assertThat(actual.isHomeIconDisplayed())
      .withFailMessage(() -> "Home icon is not displayed")
      .isTrue();

    return this;
  }

  public void assertAll() {
    softAssertions.assertAll();
  }

}
