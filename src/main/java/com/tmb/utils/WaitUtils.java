package com.tmb.utils;

public final class WaitUtils {

  private WaitUtils() {
  }

  public static void waitFor(int seconds, String message) {
    try {
      Thread.sleep(seconds * 1000L);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  public static void waitFor(long milliSeconds) {
    try {
      Thread.sleep(milliSeconds);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
