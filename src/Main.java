import entities.Department;
import entities.Seller;

import java.util.Date;

public class Main {

    public static void main(String[] args) {

        Department department = new Department(1, "Books");
        Seller seller = new Seller(3000.00, new Date(),department, "John@gmail.com",287,"John");
        System.out.println(seller);
        System.out.println(department);
    }

}