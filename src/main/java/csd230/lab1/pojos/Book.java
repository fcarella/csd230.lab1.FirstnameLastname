package csd230.lab1.pojos;
/**
 * DTO for {@link csd230.lab1.entities.Book}
 */
/**
 * DTO for {@link csd230.lab1.entities.Book}
 */
public class Book extends Publication {
    private String author;
    private String ISBN;
//    private String ISBN_10;
    public Book() {}

    public Book(double price, int quantity, String description, Cart cart, String title, int copies, String author, String ISBN) {
        super(price, quantity, description, cart, title, copies);
        this.author = author;
        this.ISBN = ISBN;
    }

}
