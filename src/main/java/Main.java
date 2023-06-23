import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("<< Welcome to our library! >>");
        System.out.println("please choose one of User/Librarian for log in, then enter you're username and password:");

        Scanner input = new Scanner(System.in);
        String userOrLibrarian = input.next();
        String username = input.next();
        String password = input.next();

        Library library = new Library();
        User user1 = null;
        Librarian librarian = null;

        if (userOrLibrarian.equals("user")) {
            user1 = new User(username, password);
            library.usersList.put(username, password);
        } else {
            librarian = new Librarian(username, password);
        }

        runMenu(userOrLibrarian);

        if (userOrLibrarian.equals("user")) {
            int number;
            do {
                System.out.println("Now what you wanna do?" + "\n" +
                        "1. rent book" + "\n" +
                        "2. return book" + "\n" +
                        "3. see your favorite book is exist or not" + "\n" +
                        "4. see how many of your favorie book has left" + "\n" +
                        "5. see your borrowed books" + "\n" +
                        "6. show your username and password" + "\n" +
                        "7. update your username and password" + "\n" +
                        "8. log out");

                number = input.nextInt();
                if (number == 1) { //rent book
                    System.out.println("please enter the book's name");
                    String name = input.next();
                    int isbn = library.booksListWithNames.get(name);
                    if (library.searchBook(name, isbn)) {
                        if (user1.books.containsKey(name)) {
                            System.out.println("You can't borrow the same book");
                        } else {
                            user1.rentBook(name, isbn);
                            library.decreaseBook(isbn, 1);
                            user1.books.put(name, isbn);
                            System.out.println("You added this book to your list successfully");
                        }
                    } else {
                        System.out.println("This book is out of stock");
                    }
                } else if (number == 2) {
                    System.out.println("please enter the book's name");
                    String name = input.next();
                    if (user1.books.containsKey(name)) {
                        user1.returnBook(name);
                        library.increaseBook(library.booksListWithNames.get(name), 1);
                        user1.books.remove(name);
                        System.out.println("Thank you for returning this book :)");
                    } else {
                        System.out.println("You have nothing to return!");
                    }
                } else if (number == 3) {
                    System.out.println("please enter the book's name");
                    String name = input.next();
                    if (library.booksListWithNames.containsKey(name)) {
                        System.out.println("Yes!");
                    } else {
                        System.out.println("No!");
                    }

                } else if (number == 4) {
                    System.out.println("please enter the book's name");
                    String name = input.next();
                    if (library.booksListWithNames.containsKey(name)) {
                        System.out.println(library.getCountOfBooks(library.booksListWithNames.get(name)));
                    } else {
                        System.out.println("we don't have this book in our library");
                    }

                } else if (number == 5) {
                    for (int i = 0; i < user1.books.size(); i++) {
                        if (user1.books.isEmpty()) {
                            System.out.println("your borrowed list is empty");
                        } else {
                            System.out.println(user1.books.keySet());
                        }
                    }
                    System.out.println();
                } else if (number == 6) {
                    System.out.println("your username is:" + user1.getUsername() + " and your password is:" + user1.getPassword());

                } else if (number == 7) {
                    System.out.println("enter your new username and password :");
                    String usernameNew = input.next();
                    String passwordNew = input.next();
                    library.updateUser(user1, usernameNew, passwordNew);
                    System.out.println("Done!");
                } else {
                    System.out.println("bye bye! see you later!");
                }
            } while (number != 8);
        } else {
            int number;
            do {
                System.out.println("Now what you wanna do?" + "\n" +
                        "1. search user" + "\n" +
                        "2. search book" + "\n" +
                        "3. search librarian" + "\n" +
                        "4. add librarian" + "\n" +
                        "5. remove librarian" + "\n" +
                        "6. update your info" + "\n" +
                        "7. add book" + "\n" +
                        "8. remove book" + "\n" +
                        "9. update book" + "\n" +
                        "10. add user" + "\n" +
                        "11. remove user" + "\n" +
                        "12. update user" + "\n" +
                        "13. books list" + "\n" +
                        "14. users list" + "\n" +
                        "15. librarians list" + "\n" +
                        "16. log out");

                number = input.nextInt();
                if (number == 1) {
                    System.out.println("please enter username:");
                    String user = input.next();
                    library.searchUser(user);
                } else if (number == 2) {
                    System.out.println("please enter the book's name:");
                    String name = input.next();
                    if (library.booksListWithNames.containsKey(name)) {
                        System.out.println("Yes this book is in the list!");
                    } else {
                        System.out.println("No, this book is not in the list!");
                    }
                } else if (number == 3) {
                    System.out.println("please enter username: ");
                    String user = input.next();
                    if (librarian.SearchForLibrarian(user)) {
                        System.out.println("Yes we have this librarian in the list ");
                    } else {
                        System.out.println("No we don't have this librarian iin the list ");
                    }

                } else if (number == 4) {
                    System.out.println("please enter librarian's username");
                    String user = input.next();
                    System.out.println("please enter librarian's password");
                    String pass = input.next();
                    librarian.addLibrarian(user, pass);
                    System.out.println("Done!");
                } else if (number == 5) {
                    System.out.println("please enter librarian's username");
                    String user = input.next();
                    librarian.removeLibrarian(user);
                    System.out.println("Done!");
                } else if (number == 6) {
                    System.out.println("please enter new password: ");
                    String pass = input.next();
                    librarian.updateLibrarian(pass);
                    System.out.println("Done!");
                } else if (number == 7) {
                    System.out.println("please enter the new book's name: ");
                    String name = input.next();
                    System.out.println("please enter isbn: ");
                    int isbn = input.nextInt();
                    System.out.println("please enter the count of books you want to add: ");
                    int count = input.nextInt();
                    library.addBook(name, isbn, count);
                    library.booksListWithNames.put(name, isbn);
                } else if (number == 8) {
                    System.out.println("please enter the book's name: ");
                    String name = input.next();
                    library.removeBook(name);
                } else if (number == 9) {
                    System.out.println("please enter the book's name: ");
                    String name = input.next();
                    int isbn = library.booksListWithNames.get(name);
                    System.out.println("please enter the count of books: ");
                    int count = input.nextInt();
                    library.updateBook(isbn, count);
                } else if (number == 10) {
                    System.out.println("please enter username: ");
                    String name = input.next();
                    System.out.println("please enter password: ");
                    String pass = input.next();
                    library.addUser(name, pass);
                } else if (number == 11) {
                    System.out.println("please enter username: ");
                    String user = input.next();
                    library.removeUser(user);
                } else if (number == 12) {
                    System.out.println("please enter the user's username: ");
                    String name = input.next();
                    System.out.println("please enter the new password: ");
                    String pass = input.next();
                    library.usersList.replace(name, pass);
                } else if (number == 13) {
                    library.printBookList();
                } else if (number == 14) {
                    System.out.println(library.usersList);
                } else if (number == 15) {
                    System.out.println(librarian.librarians);
                } else {
                    System.out.println("bye bye! see you later!");
                }
            } while (number != 16);

        }

    }


    public static void runMenu(String userOrLibrarian) {
        System.out.println("Hi! you loged in as " + userOrLibrarian);
    }

    }
