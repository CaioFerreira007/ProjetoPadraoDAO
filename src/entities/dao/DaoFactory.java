package entities.dao;

import db.DB;
import entities.dao.impl.SellerDaoJDBC;

public class DaoFactory {

    public static SellerDAO createSellerDao(){
        return new SellerDaoJDBC(DB.getConnection());
    }
}
