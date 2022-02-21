package pl.millennium.gnomix.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import pl.millennium.gnomix.domain.Book;
import pl.millennium.gnomix.domain.ErrorMessage;
import pl.millennium.gnomix.error.BookAlreadyRegisteredException;
import pl.millennium.gnomix.error.BookNotFoundException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BookRepository {

    private final List<Book> books = new ArrayList<>();

    public void addNewBook(String title) throws BookAlreadyRegisteredException {
        Random rd = new Random();
        Book newBook = new Book(rd.nextLong(), title);
        if(!books.isEmpty()){
            if(books.contains(newBook)){
                throw new BookAlreadyRegisteredException(ErrorMessage.getMsg());
             }
        }
        this.books.add(newBook);
    }

    public Book findBookByTitle (String title) throws BookNotFoundException {
        Book searchedBook = new Book(null, null);
        for(Book book : books){
            if(book.getTitle().equalsIgnoreCase(title)){
                searchedBook.setId((book.getId()));
                searchedBook.setTitle(book.getTitle());
            }
        }
        if (searchedBook.getTitle() == null){
            throw new BookNotFoundException(ErrorMessage.getError());
        }
        return searchedBook;
    }

    public Book findBookById (Long id) throws BookNotFoundException {
        Book searchedBook = new Book(null, null);
        for(Book book : books){
            if(book.getId().equals(id)){
                searchedBook.setId(book.getId());
                searchedBook.setTitle(book.getTitle());
            }
        }
        if (searchedBook.getId() != null) {
            return searchedBook;
        } else {
            throw new BookNotFoundException(ErrorMessage.getError());
        }
    }

    public List<Book> showBooks() throws BookNotFoundException {
        if(books.isEmpty()){
            throw new BookNotFoundException(ErrorMessage.getFatalError());
        }
        return books;
    }

    public void readAll() throws FileNotFoundException {
        Gson gson = new Gson();
        FileReader fr = new FileReader("./books.json");
        List<Book> loadedBooks = gson.fromJson(fr, new TypeToken<List<Book>>() {}.getType());
        for (Book b : this.books) {
            System.out.println("  ==> Zapisane książki do tej pory: \n\tTytuł: " + b.getTitle());
        }
    }

    public void saveAll() throws IOException {
        Gson gson = new Gson();
        FileWriter fw = new FileWriter("./books.json");
        gson.toJson(this.books, fw);
        fw.flush();
        fw.close();
    }
}
