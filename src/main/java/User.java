import java.util.Hashtable;

public class User {
    //User should have a list of books
    //User should have a username and a password
    private String username;
    private String password;

    public Hashtable<String, Integer> books = new Hashtable<>(5);

    public User(){}
    public User(String username, String password)
    {
        this.username = username;
        this.password = password;
    }
    public void rentBook(String book, int isbn){
        books.put(book,isbn);
    }
    public void returnBook(String book){
        books.remove(book);
    }

    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
