public class Pocket<E>{ // E extends ~~~ とすれば~~~とその子孫のみ入れられる
  // E にStringなどが指定されれば、全部置き換わる
  private E data;
  public void put(E d) { this.data = d;}
  public E get() { return this.data; }
}