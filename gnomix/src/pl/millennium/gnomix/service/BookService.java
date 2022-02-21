package pl.millennium.gnomix.service;

import pl.millennium.gnomix.domain.Book;
import pl.millennium.gnomix.error.BookNotFoundException;
import pl.millennium.gnomix.repository.BookRepository;
import pl.millennium.gnomix.error.BookAlreadyRegisteredException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public void createNewBook(String title) throws BookAlreadyRegisteredException {
        try {
            this.bookRepository.addNewBook(title);
        }catch(NullPointerException e){
            System.out.println(e.getCause() + " \n" + e.getMessage());
        }
    }

    public Book findSearchedBookByTitle(String title) throws BookNotFoundException {
        return this.bookRepository.findBookByTitle(title);
    }

    public Book findSearchedBookById(Long id) throws BookNotFoundException {
        return this.bookRepository.findBookById(id);
    }

    public List<Book> getAllBooks() throws BookNotFoundException {
        return this.bookRepository.showBooks();
    }

    public void readAllRegisteredBooks() throws FileNotFoundException {
        this.bookRepository.readAll();
    }

    public void saveAllEnteredBooks() throws IOException {
        this.bookRepository.saveAll();
    }
}
