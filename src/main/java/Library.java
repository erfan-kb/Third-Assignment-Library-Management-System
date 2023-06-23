import java.util.Hashtable;

public class Library extends Librarian{
    public Hashtable<Integer, Integer> booksList;
    public Hashtable<String, Integer> booksListWithNames;
    public Hashtable<String, String> usersList ;
    public Hashtable<String, String> librariansList;

    public Library() {
        super("username", "password");
        booksList = new Hashtable<>(10);
        booksListWithNames = new Hashtable<>(100);
        usersList = new Hashtable<>(100);
        librariansList = new Hashtable<>(10);
        addBook("HarryPotter", 1, 10);
        addBook("kimiagar", 2, 5);

    }
    public void addBook(String name,int isbn, int countOfBooks){
        booksList.put(isbn,countOfBooks);
        booksListWithNames.put(name,isbn);
    }

    public void removeBook(String bookName){
        booksList.remove(bookName);
    }

    public void updateBook(int isbn, int count){
        booksList.replace(isbn,getCountOfBooks(isbn) + count);
    }

    public boolean searchBook(String name, int isbn){
        if(booksList.get(isbn) != 0)
        {
            return true;
        }
        else {
            return false;
        }
    }

        public int getCountOfBooks(int isbn){
            return booksList.get(isbn);
        }

        public void increaseBook(int isbn, int increase){
            int count = getCountOfBooks(isbn) + increase;
            booksList.replace(isbn,count);
        }

        public void decreaseBook(int isbn, int decrease){
            int count = getCountOfBooks(isbn) - decrease;
            booksList.replace(isbn,count);
        }

    //user related functions


    public void addUser(String username, String password){
        usersList.put(username,password);
    }

    public void removeUser(String username){
        usersList.remove(username);
    }
    public void updateUser(User user,String username, String password){
        user.setUsername(username);
        user.setPassword(password);
    }

    public void searchUser(String username ){
        if(usersList.containsKey(username))
        {
            System.out.println("Yes we have this username in the list");
        }
        else {
            System.out.println("No we don't have this user name in the list");
        }
    }

    //librarian related functions

    public void printBookList() {
        System.out.println(" names: " + booksListWithNames.keySet());
        System.out.println(" with count of : " + booksList.values());
    }


}
