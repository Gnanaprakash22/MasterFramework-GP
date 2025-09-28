package com.tmb.pages.web.electra.validator;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DashboardPageValidator {
  private boolean searchDisplayed;
  private boolean homeIconDisplayed;
}
