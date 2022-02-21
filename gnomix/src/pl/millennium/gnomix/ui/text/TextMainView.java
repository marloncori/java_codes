package pl.millennium.gnomix.ui.text;

import pl.millennium.gnomix.domain.Book;
import pl.millennium.gnomix.domain.ErrorMessage;
import pl.millennium.gnomix.error.BookAlreadyRegisteredException;
import pl.millennium.gnomix.error.BookNotFoundException;
import pl.millennium.gnomix.service.BookService;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class TextMainView {

    private static int option = -1;

    private ErrorMessage error;

    private BookService bookService;

    public TextMainView(BookService bookService){
        this.bookService = bookService;
    }
    public void init() throws InterruptedException, BookNotFoundException, BookAlreadyRegisteredException, FileNotFoundException {
        String line = "\033[1;36m====================================================\033[0m";
        System.out.println("\n" + line + "\n\033[1;35m  ::::::: G   N   O   M   I   X  :::::: \033[0m\n" + line);

        System.out.println("\n" + line + "\n\033[1;35m   System do zarządzania zbiorami bibliotecznymi\033[0m\n" + line);
        Thread.sleep(2000);

        this.bookService.readAllRegisteredBooks();

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\033[1;35m >>>> Wybierz operację! <<<< \033[0m");
        Thread.sleep(1000);

        while(option != 0){
            System.out.println("\n\033[1;31m¦  [ 0 ] Wyloguj się z systemu      ¦033[0m");
            Thread.sleep(500);

            System.out.println("\033[1;33m¦  [ 1 ] Zarejestruj nową książkę   ¦033[0m");
            Thread.sleep(500);

            System.out.println("\033[1;32m¦  [ 2 ] Wyszukuj książkę po tytule ¦033[0m");
            Thread.sleep(500);

            System.out.println("\033[1;36m¦  [ 3 ] Wyszukuj książkę po kod    ¦033[0m");
            Thread.sleep(500);

            System.out.println("\033[1;35m¦  [ 4 ] Zobacz wszystkie książki   ¦033[0m");
            Thread.sleep(500);

            System.out.println("\n" + line);
            System.out.print(":::::::: OPTION = ");
            option = Integer.parseInt(scanner.nextLine());
            switch(option){
                case 1:
                    this.handleCreateNewBook(scanner, line);
                    break;
                case 2:
                    this.handleFindBookByTitle(scanner, line);
                    break;
                case 3:
                    this.handleFindBookById(scanner, line);
                    break;
                case 4:
                    this.handleShowAllBooks(line);
                    break;
                default:
                    System.out.println(error.getErrMsg());
                    break;
            }
            if(option == 0){
                System.out.println("\n" + line + "\n\033[1;35m :::: Zapraszamy ponownie! :::: \n  >>>> Wylogowanie z systemu... \033[0m\n" + line);
                Thread.sleep(1000);
            }
        }
    }

   private void handleCreateNewBook(Scanner scanner, String line) throws BookAlreadyRegisteredException, InterruptedException {
        System.out.println("\033[1;35m :::::: Wprowadź tytuł książki: \033[0m");
        System.out.print(" ====> tytuł: ");
        String title = scanner.nextLine();
        this.bookService.createNewBook(title);
        System.out.println("\n" + line + "\n\033[1;33m#### Książka została pomyślnie zapisana do bazy danych! #### \033[0m\n" + line);
        Thread.sleep(3000);
   }

    private void handleFindBookByTitle(Scanner scanner, String line) throws BookNotFoundException, InterruptedException {
        System.out.println("\033[1;35m :::::: Wprowadź tytuł książki: \033[0m");
        System.out.print(" ====> tytuł: ");
        String title = scanner.nextLine();
        Book found = bookService.findSearchedBookByTitle(title);
        System.out.println("\033[1;33m\n  --> Book id: " + found.getId() + "\033[0m\n  --> Book title: " + found.getTitle() + "\n" + line);
        Thread.sleep(3000);
    }

    private void handleFindBookById(Scanner scanner, String line) throws BookNotFoundException, InterruptedException {
        System.out.println("\033[1;35m :::::: Wprowadź kod książki: \033[0m");
        System.out.print(" ====> identyfikacja: ");
        Long id = scanner.nextLong();
        Book book = bookService.findSearchedBookById(id);
        System.out.println( "::: Oto dane znalezionej książki: ");
        Thread.sleep(500);
        System.out.println("\033[1;33m  --> Book id: " + book.getId() + "\033[0m\n  --> Book title: " + book.getTitle() + "\n" + line);
        Thread.sleep(2000);
    }

    private void handleShowAllBooks(String line) throws BookNotFoundException, InterruptedException {
        List<Book> allBooks = bookService.getAllBooks();
        System.out.println( "::: Oto wszystkie książki obecnie zarejestrowane: ");
        Thread.sleep(500);
        for(Book book : allBooks){
            System.out.println("\n" + line + "\033[1;33m  --> Book id: " + book.getId() + "\033[0m\n  --> Book title: " + book.getTitle() + "\n" + line);
            Thread.sleep(500);
        }
        Thread.sleep(2000);
    }
}
