import java.util.*;

public class StrongBox<E> {
  private E data;
  public void put(E d) { this.data = d;}
  private int count = 0 ; 
  private KeyType keyType;

  public Optional<E> get() {
    E value = null;
    int lock = 0;
    switch (keyType) {
      case KeyType.PADLOCK -> lock = KeyType.PADLOCK.getLock();
      case KeyType.BUTTON -> lock = KeyType.BUTTON.getLock();
      case KeyType.DIAL -> lock = KeyType.DIAL.getLock();
      case KeyType.FINGER-> lock = KeyType.FINGER.getLock();
    }
    if (this.count >= lock) {
      value = this.data;
    }
    count++ ;
    return Optional.ofNullable(value);
  }

  public StrongBox(KeyType keyType, E data) {
    setKeytype(keyType);
    setData(data); 
  }

  public void setKeytype(KeyType keyType) {
    this.keyType = keyType;
  }
  public void setData(E data) {
    this.data = data;
  }
}