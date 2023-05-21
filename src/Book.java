import java.util.*;
import java.util.stream.Collectors;

public abstract class Book {

    private final String title;
    private final String author;
    private final Genre genre;
    private final int publicationYear;
    private boolean availabilityStatus;
    private final int bookID;
    private static int iterateBookID;

    public static Map<Genre, List<Book>> allBooks = new HashMap<>();

    public Book(String title, String author, int publicationYear, Genre genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publicationYear = publicationYear;
        this.bookID = ++iterateBookID;
        if(!allBooks.containsKey(genre)){
            allBooks.put(genre, new ArrayList<>());
        }
        allBooks.get(genre).add(this);
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public boolean getAvailabilityStatus() {
        return availabilityStatus;
    }

    public int getBookID() {
        return bookID;
    }

    public void setAvailabilityStatus(boolean availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    @Override
    public String toString() {
        return "id: " + getBookID() +
                ", name: " + getTitle() +
                ", was written by author: " + getAuthor() +
                ", was published in: " + getPublicationYear() +
                ", and availability status is: " + getAvailabilityStatus();
    }

    public Genre getGenre() {
        return genre;
    }

    public static void getBooksByGenre(Genre genre) {
        allBooks.entrySet().stream()
                .filter(entry -> entry.getKey().equals(genre))
                .forEach(entry -> {
                    Genre g = entry.getKey();
                    List<Book> book = entry.getValue();
                    System.out.println("Genre: " + g + ", Book: " + book);
                });
    }

    public static void getAllBooks() {
        allBooks.entrySet()
           .forEach(entry -> {
                    Genre g = entry.getKey();
                    List<Book> book = entry.getValue();
                    System.out.println("Genre: " + g + ", Book: " + book);
                });
    }

    public static List<Book> getBooksByAuthor(String authorName){
        return allBooks.values().stream()
                .flatMap(List::stream)
                .filter(book -> book.getAuthor().equalsIgnoreCase(authorName))
                .collect(Collectors.toList());
    }
    }


