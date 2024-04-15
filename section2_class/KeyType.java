public enum KeyType {
  PADLOCK(1024),
  BUTTON(10000),
  DIAL(30000),
  FINGER(1000000);

  private int lock;
  private KeyType(int num) {
    this.lock = num;
  }
  public int getLock() {
    return this.lock;
  }
}