package bookreader;

public class Book {
  private String name;
  private String author;
  private double userRating;
  private int reviews;
  private double price;
  private int year;
  private String genre;

  public Book(
    String name,
    String author,
    double userRating,
    int reviews,
    double price,
    int year,
    String genre
  ) {
    this.name = name;
    this.author = author;
    this.userRating = userRating;
    this.reviews = reviews;
    this.price = price;
    this.year = year;
    this.genre = genre;
  }

  public String getName() {
    return this.name;
  }

  public String getAuthor() {
    return this.author;
  }

  public double getUserRating() {
    return this.userRating;
  }

  public int getReviews() {
    return this.reviews;
  }

  public double getPrice() {
    return this.price;
  }

  public int getYear() {
    return this.year;
  }

  public String getGenre() {
    return this.genre;
  }

  public void printDetails() {
    System.out.println("Details of Book: " + this.name);
    System.out.println(" - Author: " + this.author);
    System.out.println(" - User Rating: " + this.userRating);
    System.out.println(" - Reviews: " + this.reviews);
    System.out.println(" - Price: " + this.price);
    System.out.println(" - Year: " + this.year);
    System.out.println(" - Genre: " + this.genre);
    System.out.println();
  }
}
