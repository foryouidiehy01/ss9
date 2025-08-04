package ra.presentation;

import ra.entity.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            showMenu();
            choice = readInt("Lựa chọn của bạn: ");
            switch (choice) {
                case 1:
                    displayStudentList();
                    break;
                case 2:
                    addStudents();
                    break;
                case 3:
                    updateStudentById();
                    break;
                case 4:
                    deleteStudentById();
                    break;
                case 5:
                    searchStudentByName();
                    break;
                case 6:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
            }
        } while (choice != 6);
    }

    private static void showMenu() {
        System.out.println("\n*********************QUẢN LÝ SINH VIÊN********************");
        System.out.println("1. Hiển thị danh sách sinh viên");
        System.out.println("2. Thêm sinh viên");
        System.out.println("3. Cập nhật thông tin sinh viên theo mã sinh viên");
        System.out.println("4. Xóa sinh viên theo mã sinh viên");
        System.out.println("5. Tìm sinh viên theo tên sinh viên");
        System.out.println("6. Thoát");
    }

    private static int readInt(String prompt) {
        int result;
        while (true) {
            System.out.print(prompt);
            try {
                result = Integer.parseInt(scanner.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Giá trị nhập không hợp lệ. Vui lòng nhập số.");
            }
        }
    }

    private static void displayStudentList() {
        if (studentList.isEmpty()) {
            System.out.println("Danh sách sinh viên trống.");
            return;
        }
        System.out.println("\nDanh sách sinh viên:");
        for (Student s : studentList) {
            s.displayData();
        }
    }

    private static void addStudents() {
        System.out.println("Nhập số sinh viên muốn thêm:");
        int n = readInt("Số lượng: ");
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin sinh viên thứ " + (i + 1) + ":");
            Student student = new Student();
            student.inputData(scanner);
            studentList.add(student);
            System.out.println("Thêm sinh viên thành công.\n");
        }
    }

    private static void updateStudentById() {
        System.out.print("Nhập mã sinh viên cần cập nhật: ");
        String id = scanner.nextLine();
        Student student = findStudentById(id);
        if (student == null) {
            System.out.println("Mã sinh viên không tồn tại.");
            return;
        }
        System.out.println("Nhập thông tin mới cho sinh viên:");
        student.inputData(scanner);
        System.out.println("Cập nhật thông tin thành công.");
    }

    private static void deleteStudentById() {
        System.out.print("Nhập mã sinh viên cần xóa: ");
        String id = scanner.nextLine();
        Student student = findStudentById(id);
        if (student == null) {
            System.out.println("Mã sinh viên không tồn tại.");
            return;
        }
        studentList.remove(student);
        System.out.println("Xóa sinh viên thành công.");
    }

    private static void searchStudentByName() {
        System.out.print("Nhập tên sinh viên cần tìm: ");
        String name = scanner.nextLine().toLowerCase();
        ArrayList<Student> foundList = new ArrayList<>();
        for (Student s : studentList) {
            if (s.getName().toLowerCase().contains(name)) {
                foundList.add(s);
            }
        }
        if (foundList.isEmpty()) {
            System.out.println("Không tìm thấy sinh viên nào với tên \"" + name + "\".");
        } else {
            System.out.println("Tìm thấy " + foundList.size() + " sinh viên:");
            for (Student s : foundList) {
                s.displayData();
            }
        }
    }

    private static Student findStudentById(String id) {
        for (Student s : studentList) {
            if (s.getStudentId().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }
}
