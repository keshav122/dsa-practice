/*Author: keshav122 */
package com.dsa_series.roadmap.oops.relationships_and_object_behaviors;

import java.util.ArrayList;
import java.util.List;

class Book {
    String title;
    String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}

class Library {
    String name;
    List<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Library shallowClone() {
        Library newLibrary = new Library(this.name);
        newLibrary.books = this.books;
        return newLibrary;
    }

    public Library deepClone() {
        Library newLibrary = new Library(this.name);
        for (Book book : books) {
            newLibrary.addBook(new Book(book.title, book.author)); // Creates new copies of books
        }
        return newLibrary;
    }

    void display() {
        System.out.println("Library : " + name);
        for (Book book : books) {
            System.out.println("Book : " + book.title + ", Author : " + book.author);
        }
    }
}

// Please Do not change anything below, It is only for your reference.
/*
 * 
 * This is the driver code that will execute and demonstrate the functionality
 * of your class `Library` and the class 'Book'.
 * 
 * 
 * public class Main {
 * 
 * public static void main(String[] args) {
 * 
 * 
 * String name;
 * List<String> titles, List<String> authors;
 * 
 * //creating the Library class object
 * Library library = new Library(name);
 * 
 * //adding the title and author names to in the list of books present in the
 * class Library
 * for (int j = 0; j < x; j++) {
 * library.addBook(new Book(titles.get(j), authors.get(j)));
 * }
 * 
 * System.out.println("Original Library : ");
 * 
 * //calling the display function to display the original details that we set in
 * above part of code
 * library.display();
 * 
 * //cloning objects using shallowClone and deepClone clone methods
 * Library shallowLibrary = library.shallowClone();
 * Library deepLibrary = library.deepClone();
 * 
 * 
 * int changeIndex;
 * String changeTitle, changeAuthor;
 * 
 * //changing the title and author of the book present at index changeIndex
 * using the original library object
 * library.getBooks().get(changeIndex).title = changeTitle;
 * library.getBooks().get(changeIndex).author = changeAuthor;
 * 
 * 
 * System.out.println("\nAfter Modification : ");
 * System.out.println("\nOriginal Library : ");
 * 
 * //calling the display method through original library object to print the
 * output
 * library.display();
 * 
 * 
 * System.out.println("\nShallow Clone : ");
 * 
 * //calling the display method through shallow clone object to print the output
 * shallowLibrary.display();
 * 
 * 
 * System.out.println("\nDeep Clone : ");
 * 
 * //calling the display method through deep clone object to print the output
 * deepLibrary.display();
 * 
 * scanner.close();
 * }
 * }
 * 
 */

/*
 * //Below are the output statements
 * 
 * System.out.println("Library : " + name);
 * System.out.println("Book : " + book.title + ", Author : " + book.author);
 * 
 */
public class Cloning_Practice {

}
