import java.util.*;

public class MemoryEater{
  public static void main(String[] args) {
    System.out.println("メモリの無駄遣い");
    long[] larray = new long[1280000];
    for (int i=0; i< larray.length; i++) {
      larray[i] = i;
    }
  }
}