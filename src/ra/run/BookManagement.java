package ra.run;

import ra.bussiness.*;
import java.util.Scanner;

public class BookManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Book[] library = new Book[100];
        int bookCount = 0;

        while (true) {
            System.out.println("****************BASIC-MENU***************");
            System.out.println("1. Nhập số lượng sách thêm mới và nhập thông tin cho từng cuốn sách");
            System.out.println("2. Hiển thị thông tin tất cả sách trong thư viện");
            System.out.println("3. Sắp xếp sách theo lợi nhuận tăng dần");
            System.out.println("4. Xóa sách theo mã sách");
            System.out.println("5. Tìm kiếm tương đối sách theo tên sách hoặc mô tả");
            System.out.println("6. Thay đổi thông tin sách theo mã sách");
            System.out.println("7. Thoát");
            System.out.print("Chọn: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    if (bookCount < 100) {
                        System.out.print("Nhập số lượng sách cần thêm: ");
                        int n = scanner.nextInt();
                        scanner.nextLine();
                        for (int i = 0; i < n; i++) {
                            library[bookCount] = new Book();
                            library[bookCount].inputData();
                            bookCount++;
                        }
                    } else {
                        System.out.println("Thư viện đã đầy, không thể thêm sách mới.");
                    }
                    break;
                case 2:
                    for (int i = 0; i < bookCount; i++) {
                        library[i].displayData();
                    }
                    break;
                case 3:
                    for (int i = 0; i < bookCount - 1; i++) {
                        for (int j = i + 1; j < bookCount; j++) {
                            if (library[i].getInterest() > library[j].getInterest()) {
                                Book temp = library[i];
                                library[i] = library[j];
                                library[j] = temp;
                            }
                        }
                    }
                    System.out.println("Sách đã được sắp xếp theo lợi nhuận tăng dần:");
                    for (int i = 0; i < bookCount; i++) {
                        library[i].displayData();
                    }
                    break;
                case 4:
                    System.out.print("Nhập mã sách cần xóa: ");
                    int deleteBookId = scanner.nextInt();
                    scanner.nextLine();
                    for (int i = 0; i < bookCount; i++) {
                        if (library[i].getBookId() == deleteBookId) {
                            for (int j = i; j < bookCount - 1; j++) {
                                library[j] = library[j + 1];
                            }
                            bookCount--;
                            System.out.println("Đã xóa sách có mã " + deleteBookId);
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.print("Nhập chuỗi tìm kiếm: ");
                    String searchString = scanner.nextLine();
                    System.out.println("Kết quả tìm kiếm:");
                    for (int i = 0; i < bookCount; i++) {
                        if (library[i].getBookName().contains(searchString) || library[i].getDescriptions().contains(searchString)) {
                            library[i].displayData();
                        }
                    }
                    break;
                case 6:
                    System.out.print("Nhập mã sách cần thay đổi thông tin: ");
                    int editBookId = scanner.nextInt();
                    scanner.nextLine();
                    for (int i = 0; i < bookCount; i++) {
                        if (library[i].getBookId() == editBookId) {
                            library[i].inputData();
                            System.out.println("Đã cập nhật thông tin sách có mã " + editBookId);
                            break;
                        }
                    }
                    break;
                case 7:
                    System.out.println("Thoát chương trình.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Chọn không hợp lệ, vui lòng chọn lại.");
            }
        }
    }
}
