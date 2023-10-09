package ra.bussiness;

import java.util.Scanner;
public class Book {
    private static int nextBookId = 1;
    private int bookId;
    private String bookName;
    private String author;
    private String descriptions;
    private double importPrice;
    private double exportPrice;
    private float interest;
    private boolean bookStatus;

    public Book() {
        this.bookId = nextBookId++;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập thông tin sách:");
        System.out.print("Tên sách: ");
        this.bookName = scanner.nextLine();
        System.out.print("Tác giả: ");
        this.author = scanner.nextLine();
        System.out.print("Mô tả: ");
        this.descriptions = scanner.nextLine();
        while (this.descriptions.length() < 10) {
            System.out.println("Mô tả phải có ít nhất 10 ký tự. Nhập lại:");
            this.descriptions = scanner.nextLine();
        }
        System.out.print("Giá nhập: ");
        this.importPrice = scanner.nextDouble();
        while (this.importPrice <= 0) {
            System.out.println("Giá nhập phải lớn hơn 0. Nhập lại:");
            this.importPrice = scanner.nextDouble();
        }
        System.out.print("Giá xuất: ");
        this.exportPrice = scanner.nextDouble();
        while (this.exportPrice <= 1.2 * this.importPrice) {
            System.out.println("Giá xuất phải lớn hơn 1.2 lần giá nhập. Nhập lại:");
            this.exportPrice = scanner.nextDouble();
        }
        this.interest = (float) (this.exportPrice - this.importPrice);
    }

    public void displayData() {
        System.out.println("Mã sách: " + bookId);
        System.out.println("Tên sách: " + bookName);
        System.out.println("Tác giả: " + author);
        System.out.println("Mô tả: " + descriptions);
        System.out.println("Giá nhập: " + importPrice);
        System.out.println("Giá xuất: " + exportPrice);
        System.out.println("Lợi nhuận: " + interest);
        System.out.println("Trạng thái: " + (bookStatus ? "Có sẵn" : "Đã cho mượn"));
    }
}