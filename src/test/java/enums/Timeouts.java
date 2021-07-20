package enums;

public enum Timeouts {
  AFTER_CLICK_TIMEOUT(1),
  CHECK_ELEMENT_TIMEOUT(1);

  private int code;

  Timeouts(int code) {
    this.code = code;
  }

  public int get() {
    return code;
  }
}
