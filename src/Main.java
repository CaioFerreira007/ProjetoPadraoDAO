import entities.Department;
import entities.Seller;
import entities.dao.DaoFactory;
import entities.dao.SellerDAO;

import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {

//        SellerDAO sellerDao = DaoFactory.createSellerDao();
//        System.out.println("==== TEST 1: seller findById ====");
//        Seller seller = sellerDao.findById(3);
//        System.out.println(seller);
//        System.out.println();
//        System.out.println("==== TEST 2: seller findByDepartment ====");
//        Department department = new Department(2,null);
//        List<Seller> list = sellerDao.findByDepartment(department);
//            list.forEach(System.out::println);
//
//        System.out.println();
//
//        System.out.println("==== TEST 3: seller findByAll ====");
//        list = sellerDao.findAll();
//        list.forEach(System.out::println);
//        System.out.println();
//
//
//      //  System.out.println("==== TEST 4: seller insert ====");
//        //Seller newSeller = new Seller (4000.0,new Date(),department,"Greg@gmail.com",null,"Greg");
//        //sellerDao.insert(newSeller);
//        //System.out.println("New seller inserted: "+ newSeller.getId());
//
//        System.out.println();
//
////        System.out.println("==== TEST 5: seller update ====");
////        seller = sellerDao.findById(1);
////        seller.setName("Batman ");
////        sellerDao.update(seller);
////        System.out.println("New seller updated: "+ seller.getName());
////        list = sellerDao.findAll();
////        list.forEach(System.out::println);
//
//
//        System.out.println();
//
//        System.out.println("==== TEST 6: seller delete ====");
//
//            sellerDao.deleteById(100);
//        list = sellerDao.findAll();
//        list.forEach(System.out::println);


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("==== TEST 7: seller delete ====");
            }
        });
t1.run();

    }

}