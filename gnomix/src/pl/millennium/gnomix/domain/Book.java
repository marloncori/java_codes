package pl.millennium.gnomix.domain;

public class Book {

    private Long id;

    private String title;

    public Book(Long id, String title){
        this.id = id;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public Long getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
