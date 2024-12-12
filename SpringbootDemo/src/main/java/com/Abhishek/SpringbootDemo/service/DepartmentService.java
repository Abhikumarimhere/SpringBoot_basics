package com.Abhishek.SpringbootDemo.service;

import com.Abhishek.SpringbootDemo.Error.DepartmentNotFoundException;
import com.Abhishek.SpringbootDemo.entity.Department;

import java.util.List;
import java.util.Optional;


public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchalldept();

    public Department fetchDepartmentbyID(Long departmentID)throws DepartmentNotFoundException;

   public void deletedept(Long departmentID) throws DepartmentNotFoundException;

   public Department Updatedeptbyid(Department department, Long departmentID);

   public  Department getDeptByName(String departmentName);
}
