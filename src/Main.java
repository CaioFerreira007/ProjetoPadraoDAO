import db.DB;
import entities.Department;
import entities.Seller;
import entities.dao.DaoFactory;
import entities.dao.SellerDAO;
import entities.dao.impl.SellerDaoJDBC;

import java.util.Date;

public class Main {

    public static void main(String[] args) {

        SellerDAO sellerDao = DaoFactory.createSellerDao();
        System.out.println("==== TEST 1: seller findById ====");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

    }

}