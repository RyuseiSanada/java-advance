import java.io.*;
import java.util.*;

public class RB {
  public static void main(String[] args) {
    ResourceBundle rb = ResourceBundle.getBundle("pref");
    System.out.println(rb.getString("aichi.capital"));
  }
}