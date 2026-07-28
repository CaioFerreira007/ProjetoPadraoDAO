package entities.dao.impl;

import db.DB;
import db.DbException;
import entities.Department;
import entities.dao.DepartmentDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDAO {
    private Connection connection;
    public DepartmentDaoJDBC(Connection connection){
            this.connection = connection;
    }
    @Override
    public void deleteById(Integer id) {

        PreparedStatement st = null;
        try{
            st = connection.prepareStatement(" delete from  Department where id=?"
            );
            st.setInt(1, id);
            int rowsAffected = st.executeUpdate();
            if(rowsAffected == 0){
                throw new DbException("Delete department failed");
            }else{
                System.out.println("Delete department successful");
            }
        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }

    }

    @Override
    public void insert(Department obj) {

        PreparedStatement st = null;
        try{
            st = connection.prepareStatement(
                    "INSERT INTO department (Name) values (?)", Statement.RETURN_GENERATED_KEYS
            );
            st.setString(1, obj.getDepartmentName());
            int rowsAffected = st.executeUpdate();
            if(rowsAffected > 0){
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){
                    int id = rs.getInt(1);
                    obj.setId(id);
                }
                DB.closeResultSet(rs);
            }else{
                throw new DbException("insert failed");
            }
        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }


    }

    @Override
    public void update(Department obj) {


        PreparedStatement st = null;
        try{
            st = connection.prepareStatement(
                    "UPDATE department SET Name=? WHERE id=?"
            );
            st.setString(1, obj.getDepartmentName());
            st.setInt(2, obj.getId());

            int rowsAffected = st.executeUpdate();
            if(rowsAffected == 0){
                throw new DbException("Update department failed");
            }else{
                System.out.println("Update department successful");
            }
        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }


    }

    @Override
    public Department findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = connection.prepareStatement("SELECT * from department where Id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            if(rs.next()){
                Department department = new Department();
                department.setId(rs.getInt("id"));
                department.setDepartmentName(rs.getString("name"));
                return department;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Department> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = connection.prepareStatement("Select * from department");
            rs = st.executeQuery();
            List<Department> departmentList = new ArrayList<>();
            while(rs.next()){
              Department  department = new Department();
                department.setId(rs.getInt("id"));
                department.setDepartmentName(rs.getString("name"));
                departmentList.add(department);

            }
            return departmentList;

        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }finally {
                DB.closeResultSet(rs);
                DB.closeStatement(st);
        }
    }
}
