package com.luoyingmm.dao;

import com.luoyingmm.pojo.Department;
import com.luoyingmm.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees = null;

    @Autowired
    DepartmentDao departmentDao;
    static {
        employees = new HashMap<>();
        employees.put(1001,new Employee(1001,"AA","A1420234232@qq.com",0,new Department(101,"教学部")));
        employees.put(1002,new Employee(1002,"BB","B1420234232@qq.com",1,new Department(102,"市场部")));
        employees.put(1003,new Employee(1003,"CC","C1420234232@qq.com",0,new Department(103,"教研部")));
        employees.put(1004,new Employee(1004,"DD","D1420234232@qq.com",1,new Department(104,"运营部")));
        employees.put(1005,new Employee(1005,"EE","E1420234232@qq.com",0,new Department(105,"后勤部")));
    }

    private static Integer initId=1006;

    public void save(Employee employee){
        if (employee.getId() == null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getId()));

        employees.put(initId,employee);
    }

    public Collection<Employee> getAll(){
        return employees.values();
    }

    public Employee getEmployee(Integer id){
        return employees.get(id);
    }

    public void deleteEmployee(Integer id){
        employees.remove(id);
    }
}
