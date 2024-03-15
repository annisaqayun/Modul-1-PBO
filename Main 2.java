import java.util.Scanner;

class Main {
    private static Book[] bookList = {
            new Book("001", "Harry Potter", "J.K. Rowling", 5),
            new Book("002", "Lord of the Rings", "J.R.R. Tolkien", 3),
            new Book("003", "To Kill a Mockingbird", "Harper Lee", 7)
    };
    private static Student[] userStudent = {
            new Student("Annisa", "202310370311113", "Teknik", "Informatika"),
            new Student("Qurrataayun", "123456789123456", "Teknik", "Informatika")
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Library System");
        System.out.println("1. Login as Admin");
        System.out.println("2. Login as Student");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // Admin login
                // Assuming we have only one admin
                Admin admin = new Admin();
                admin.menuAdmin();
                break;
            case 2:
                // Student login
                System.out.print("Enter your Student ID: ");
                String studentId = scanner.next();
                Student student = new Student();
                if (student.checkNim(studentId)) {
                    student.menuStudent();
                } else {
                    System.out.println("Invalid Student ID");
                }
                break;
            default:
                System.out.println("Pilihan tidak valid");
        }
    }

    static class Book {
        String id;
        String title;
        String author;
        int stock;

        public Book(String id, String title, String author, int stock) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.stock = stock;
        }
    }

    static class Student {
        String name;
        String nim;
        String faculty;
        String program;

        public Student() {}

        public Student(String name, String nim, String faculty, String program) {
            this.name = name;
            this.nim = nim;
            this.faculty = faculty;
            this.program = program;
        }

        public void displayBooks() {
            System.out.println("Available Books:");
            for (Book book : bookList) {
                System.out.println("ID: " + book.id + ", Title: " + book.title + ", Author: " + book.author + ", Stock: " + book.stock);
            }
        }

        public void menuStudent() {
            Scanner scanner = new Scanner(System.in);
            int choice;
            do {
                System.out.println("\nStudent Dashboard");
                System.out.println("1. Display Available Books");
                System.out.println("2. Logout");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        displayBooks();
                        break;
                    case 2:
                        System.out.println("Logging out...");
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            } while (choice != 2);
        }

        public boolean checkNim(String nim) {
            for (Student student : userStudent) {
                if (student.nim.equals(nim)) {
                    return true;
                }
            }
            return false;
        }
    }

    static class Admin {
        Scanner scanner = new Scanner(System.in);

        public void addStudent() {
            System.out.print("Enter student name: ");
            String name = scanner.next();
            System.out.print("Enter student NIM: ");
            String nim = scanner.next();
            System.out.print("Enter student faculty: ");
            String faculty = scanner.next();
            System.out.print("Enter student program: ");
            String program = scanner.next();

            if (nim.length() != 15) {
                System.out.println("Invalid NIM! NIM length should be 15 characters.");
                return;
            }

            Student newStudent = new Student(name, nim, faculty, program);
            // Assuming we can add only one student at a time
            for (int i = 0; i < userStudent.length; i++) {
                if (userStudent[i] == null) {
                    userStudent[i] = newStudent;
                    System.out.println("Student added successfully.");
                    return;
                }
            }
            System.out.println("Student list is full. Cannot add more students.");
        }

        public void displayStudent() {
            System.out.println("\nRegistered Students:");
            for (Student student : userStudent) {
                if (student != null) {
                    System.out.println("Name: " + student.name + ", NIM: " + student.nim + ", Faculty: " + student.faculty + ", Program: " + student.program);
                }
            }
        }

        public void menuAdmin() {
            int choice;
            do {
                System.out.println("\nAdmin Dashboard");
                System.out.println("1. Add Student");
                System.out.println("2. Display Registered Students");
                System.out.println("3. Logout");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        displayStudent();
                        break;
                    case 3:
                        System.out.println("Logging out...");
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            } while (choice != 3);
        }
    }
}