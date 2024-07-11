import java.util.Scanner;

// LibraryItem.java
interface LibraryItem {
    String getInfo();
}

// Book.java
class Book implements LibraryItem {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getInfo() {
        return "Book Title: " + title + ", Author: " + author;
    }
}

// Member.java
class Member {
    private String name;

    public Member(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Library.java
class Library {
    private LibraryItem[] items;
    private Member[] members;
    private int itemCount;
    private int memberCount;

    public Library(int itemCapacity, int memberCapacity) {
        items = new LibraryItem[itemCapacity];
        members = new Member[memberCapacity];
        itemCount = 0;
        memberCount = 0;
    }

    public void addItem(LibraryItem item) {
        if (itemCount < items.length) {
            items[itemCount++] = item;
        } else {
            System.out.println("Library is full. Cannot add more items.");
        }
    }

    public void addMember(Member member) {
        if (memberCount < members.length) {
            members[memberCount++] = member;
        } else {
            System.out.println("Library has reached its member limit.");
        }
    }

    public void displayItems() {
        System.out.println("Library Items:");
        for (int i = 0; i < itemCount; i++) {
            System.out.println(items[i].getInfo());
        }
    }

    public void displayMembers() {
        System.out.println("Library Members:");
        for (int i = 0; i < memberCount; i++) {
            System.out.println("Member Name: " + members[i].getName());
        }
    }
}

public class  LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library(5, 5);
        int choice;
        
        do {
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Display Books");
            System.out.println("4. Display Members");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    library.addItem(new Book(title, author));
                    break;
                case 2:
                    System.out.print("Enter member name: ");
                    String name = scanner.nextLine();
                    library.addMember(new Member(name));
                    break;
                case 3:
                    library.displayItems();
                    break;
                case 4:
                    library.displayMembers();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}

