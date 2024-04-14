import java.util.*;

public class Book implements Comparable<Book>, Cloneable{
  private String title;
  private Date publishDate;
  private String comment;

  public boolean equals(Object o) {
    if (o == this) return true;
    if (o == null) return false;
    if (!(o instanceof Book)) return false;
    Book b = (Book)o;
    if(this.title == b.title && this.publishDate == b.publishDate) {
      return true;
    }
    else {
      return false;
    }
  }

  public int hashCode() {
    return Objects.hash(this.title, this.publishDate, this.comment);
  }

  public int compareTo(Book b) {
    return this.publishDate.compareTo(b.publishDate);
  }

  public Book clone() {
    Book result = new Book();
    setTitle(this.title);
    // setPublishDate(this.publishDate);
    setComment(this.comment);
    return result;
  }
  
  //getter, setter
  public String getTitle() {
    return this.title;
  }
  public Date getPublishDate() {
    return this.publishDate;
  }
  public String getComment() {
    return this.comment;
  }

  public void setTitle(String title) {
    this.title = title;
  }
  public void setPublishDate(int year, int month, int date) {
    this.publishDate = new Date(year, month, date);
  }
  public void setComment(String comment) {
    this.comment = comment;
  }

}