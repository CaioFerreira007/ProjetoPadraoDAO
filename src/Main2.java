import entities.Department;
import entities.dao.DaoFactory;
import entities.dao.DepartmentDAO;
import entities.dao.impl.DepartmentDaoJDBC;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
            DepartmentDAO departmentDAO = DaoFactory.createDepartmentDao();
     System.out.println("==== TEST 1 ====");
     Department newDepartment = new Department(null,"Apple watch");
   departmentDAO.insert(newDepartment);
     System.out.println("New department added successfully " + newDepartment.getId());
     System.out.println();
       System.out.println("==== TEST 2 ====");
       departmentDAO.deleteById(6);

        System.out.println();
        System.out.println("==== TEST 3 ====");
       Department department = new Department(4,"Foods");
       departmentDAO.update(department);

        System.out.println();

        System.out.println("==== TEST 4 ====");
        Department departments = departmentDAO.findById(3);
        System.out.println(departments);

        System.out.println();
        System.out.println("==== TEST 5 ====");
        List<Department> departmentList = departmentDAO.findAll();
        departmentList.forEach(System.out::println);
    }
}
