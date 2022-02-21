package pl.millennium.gnomix;

import pl.millennium.gnomix.error.BookAlreadyRegisteredException;
import pl.millennium.gnomix.error.BookNotFoundException;
import pl.millennium.gnomix.repository.BookRepository;
import pl.millennium.gnomix.service.BookService;
import pl.millennium.gnomix.ui.text.TextMainView;

import java.io.FileNotFoundException;

public class GnomixApp {

    public static void main(String[] args) throws BookNotFoundException, BookAlreadyRegisteredException,
                                                        InterruptedException, FileNotFoundException {
        /* wstrzykiwanie zależności */
        BookRepository bookRepository = new BookRepository();
        BookService bookService = new BookService(bookRepository);
        TextMainView system = new TextMainView(bookService);
        system.init();
    }
}
