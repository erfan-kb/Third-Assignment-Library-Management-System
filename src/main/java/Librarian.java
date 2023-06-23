import java.util.ArrayList;
import java.util.Hashtable;

public class Librarian {
    /*
    * The librarian should have a username and a password
    * The librarian should be able to search users, librarians and books
    * The librarian should be able to add\remove\update user add\remove\update_
    _ librarian and add\remove\update book
     */
    private String username;
    private String password;

    public Hashtable<String,String> librarians = new Hashtable<>(10);

    private boolean searchResultForLibrarians;
    private boolean searchResultForBook;

    public Librarian(String username, String password) {
        this.username = username;
        this.password = password;
        librarians.put(username,password);
    }

    public boolean SearchForLibrarian(String librarian)
    {
        if(librarians.containsKey(librarian))
        {
            searchResultForLibrarians = true;
        }
        else {
            searchResultForLibrarians = false;
        }
        return searchResultForLibrarians;
    }



    public void addLibrarian(String username, String password)
    {
        librarians.put(username,password);
    }
    public void removeLibrarian(String librarian){
        librarians.remove(librarian);
    }
    public void updateLibrarian(String password){
        librarians.replace(username,password);
    }

}
