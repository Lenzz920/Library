import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Transaction implements Loanable{

    public Book book;
    public Member member;
    private final LocalDate dueDate;
    private double fee;
    private boolean oweFee;
    private boolean bookReturned;
    static Map<Book, Member> transactions = new HashMap<>();
    private Object transactionID;
    static private int iterateTransactionID;

    public Transaction(Book book, Member member) {
        this.book = book;
        this.member = member;
        rentBook();
        this.dueDate = LocalDate.now().plusDays(14);
    }

    public boolean getOweFee() {
        return oweFee;
    }

    public double getFee() {
        return fee;
    }

    public Object getTransactionID() {
        return transactionID;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    private void rentBook() {
        if(book.getAvailabilityStatus()) {
            transactionID = ++iterateTransactionID;
            transactions.put(this.book,this.member);
            System.out.println(this);
        } else {
            System.out.println("The Book is not available");
            this.book = null;
            this.member = null;
            this.transactionID = null;
        }
    }

    public void returnBook () {
        if(statusOweFee()) {
            fee = 10.00;
            System.out.println("Your fee is 10$. Please pay it before you return the book");
        } else {
            transactions.remove(book, member);
            bookReturned = true;
        }
    }

    public boolean statusOweFee() {
        if(LocalDate.now().isAfter(dueDate)){
            oweFee = true;
            fee = 10.00;
        } else {
            oweFee = false;
        }
        return oweFee;
    }

    @Override
    public String toString() {
        return "Transaction " + transactionID + " details: " + member +
                ", who took " + book;
    }

}