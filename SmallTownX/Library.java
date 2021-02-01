/*
 ** Name : Israel Kwawu
 ** Programming Lab: 3
 */

import java.util.ArrayList;
public class Library {
      // Add the missing implementation to this class
    private String address;
    private ArrayList<Book> books;
    private boolean isEmpty;
    private boolean isAvailable;

    public Library(String address) {
        this.address = address;
        this.books = new ArrayList<>();
        this.isEmpty = true;
        this.isAvailable=false;
    }

    public static void printOpeningHours(){
        System.out.println("Libraries are open daily from 9am to 5pm.");
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void printAddress(){
        System.out.println(this.address);
    }

    public void borrowBook(String title){
        this.isEmpty = books.isEmpty();
        if (this.isEmpty){
            System.out.println("Sorry, this book is not in our catalog.");
        }else {

            boolean found = false;

            for (int i =0 ;i<books.size();i++){
                if (title.equals(books.get(i).getTitle())){
                    books.get(i).borrowed();
                    found = true;
                    System.out.println("You successfully borrowed "+books.remove(i).getTitle());
                    break;
                }

                found =false;
            }

            if (found == false){
                System.out.println("Sorry, this book is already borrowed.");
            }

        }
    }

    public void printAvailableBooks(){
        this.isEmpty = books.isEmpty();
        if (this.isEmpty){
            System.out.println("No book in catalog");
        }else {
            for (int i=0; i < books.size(); i++){
                System.out.println(books.get(i).getTitle());
            }
        }

    }

    public void returnBook(String title){
        this.isAvailable = books.add(new Book(title));
        if (this.isAvailable){
            System.out.println("You successfully returned "+ title);
        }else {
            System.out.println("Could not add book to catalog");
        }
    }

    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");
        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));
        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();
        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();
        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();
        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();
        // Return The Lords of the Rings to the first library

        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();
        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();

    }
}