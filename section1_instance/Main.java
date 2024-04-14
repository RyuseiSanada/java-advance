import java.util.*;

public class Main {
  public static void main(String[] args) {
    Book b1 = new Book();
    b1.setTitle("まんなか");
    b1.setPublishDate(2018, 5, 22);
    b1.setComment("よき");

    Book b2 = new Book();
    b2.setTitle("あたらしい");
    b2.setPublishDate(2020, 5, 22);
    b2.setComment("よき");    
    
    Book b5 = new Book();
    b5.setTitle("ふるい");
    b5.setPublishDate(2015, 5, 22);
    b5.setComment("よき");    

    Book b3 = new Book();
    b3.setTitle("まんなか");
    b3.setPublishDate(2018, 5, 22);
    b3.setComment("よくない");    

    System.out.println(b1.equals(b3));

    List<Book> booksList = new ArrayList<>(){
      {
          add(b1);
          add(b2);
          add(b5);
      }
    };
    
    Collections.sort(booksList);
    for (Book book : booksList) {
      System.out.println(book.getTitle());
    }

    Collections.sort(booksList, new TitleComparator());
    for (Book book : booksList) {
      System.out.println(book.getTitle());
    }
    
    Book b4 = b1.clone();
    b4.setTitle("こらー！");
    System.out.println(b1.getTitle());

    Monster m = new Monster("うぇい", 50,false);
    System.out.println(m);
    Monster m2 = new Monster("うぇい", -5,false);
  }
}