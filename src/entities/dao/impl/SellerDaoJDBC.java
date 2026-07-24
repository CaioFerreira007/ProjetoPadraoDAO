package entities.dao.impl;

import db.DB;
import db.DbException;
import entities.Department;
import entities.Seller;
import entities.dao.SellerDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SellerDaoJDBC implements SellerDAO {

    private Connection connection;
    public SellerDaoJDBC(Connection connection) {
        this.connection = connection;
    }
    @Override
    public void insert(Seller obj) {

    }

    @Override
    public void update(Seller obj) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Seller findById(Integer id) {

        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
            statement = connection.prepareStatement(
                    "select seller. *,department.Name as DepName " +
                            "from seller inner join department  " +
                            "on seller.DepartmentId = department.Id " +
                            "where seller.Id = ?"
            );
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if(resultSet.next()){

                    Department department = instatiateDpartment(resultSet);
                    Seller seller = instantiateSeller(resultSet,department);
                    return seller;
            }
            return null;
        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(statement);
            DB.closeResultSet(resultSet);
        }

    }

    private Seller instantiateSeller(ResultSet resultSet, Department department) throws SQLException {
        Seller seller = new Seller();
        seller.setId(resultSet.getInt("Id"));
        seller.setName(resultSet.getString("Name"));
        seller.setEmail(resultSet.getString("Email"));
        seller.setBaseSalary(resultSet.getDouble("BaseSalary"));
        seller.setBirthDate(resultSet.getDate("BirthDate"));
        seller.setDepartment(department);
        return seller;

    }

    private Department instatiateDpartment(ResultSet resultSet) throws SQLException {
       Department department= new Department();
        department.setId(resultSet.getInt("DepartmentId"));
        department.setDepartmentName(resultSet.getString("DepName"));
        return department;
    }

    @Override
    public List<Seller> findAll() {
        return List.of();
    }
}
