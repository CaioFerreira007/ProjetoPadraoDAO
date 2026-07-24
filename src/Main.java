import entities.Department;
import entities.Seller;
import entities.dao.DaoFactory;
import entities.dao.SellerDAO;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        SellerDAO sellerDao = DaoFactory.createSellerDao();
        System.out.println("==== TEST 1: seller findById ====");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);
        System.out.println();
        System.out.println("==== TEST 2: seller findByDepartment ====");
        Department department = new Department(2,null);
        List<Seller> list = sellerDao.findByDepartment(department);
            list.forEach(System.out::println);

        System.out.println();

        System.out.println("==== TEST 3: seller findByAll ====");
        list = sellerDao.findAll();
        list.forEach(System.out::println);

    }

}