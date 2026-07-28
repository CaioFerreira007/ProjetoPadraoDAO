package entities.dao;

import db.DB;
import entities.dao.impl.DepartmentDaoJDBC;
import entities.dao.impl.SellerDaoJDBC;

public class DaoFactory {

    public static SellerDAO createSellerDao(){
        return new SellerDaoJDBC(DB.getConnection());
    }
    public static  DepartmentDAO createDepartmentDao(){
        return new DepartmentDaoJDBC(DB.getConnection());
    }
}
