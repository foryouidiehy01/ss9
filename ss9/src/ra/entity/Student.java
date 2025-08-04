package ra.entity;

import java.util.Scanner;

public class Student {
    private String studentId;
    private String name;
    private int age;
    private String major;

    public Student() {
    }

    public Student(String studentId, String name, int age, String major) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.major = major;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age > 0)
            this.age = age;
        else
            this.age = 18; // mặc định nếu nhập không hợp lệ
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void inputData(Scanner scanner) {
        System.out.print("Nhập mã sinh viên: ");
        this.studentId = scanner.nextLine();

        System.out.print("Nhập tên sinh viên: ");
        this.name = scanner.nextLine();

        System.out.print("Nhập tuổi: ");
        while (true) {
            try {
                this.age = Integer.parseInt(scanner.nextLine());
                if (age > 0) break;
                else System.out.print("Tuổi phải lớn hơn 0. Nhập lại: ");
            } catch (NumberFormatException e) {
                System.out.print("Tuổi không hợp lệ. Nhập lại: ");
            }
        }

        System.out.print("Nhập chuyên ngành: ");
        this.major = scanner.nextLine();
    }

    public void displayData() {
        System.out.printf("Mã SV: %s | Tên: %s | Tuổi: %d | Chuyên ngành: %s\n",
                studentId, name, age, major);
    }
}
