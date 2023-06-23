public class Book{
    //Book should contain name,author,year of publish and ISBN
    private String name;
    private String author;
    private int year;
    private int isbn;

    private boolean borrowed = false;

    public Book (String name, String author, int year, int isbn)
    {
        this.name = name;
        this.author = author;
        this.year = year;
        this.isbn = isbn;
        borrowed = true;
    }

    public boolean isBorrowed() {
        return borrowed;
    }


    public String getName() {
        return name;
    }
    protected void setName(String name){
        this.name = name;
    }
    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public int getIsbn() {
        return isbn;
    }
    protected void setIsbn(int isbn){
        this.isbn = isbn;
    }
}
