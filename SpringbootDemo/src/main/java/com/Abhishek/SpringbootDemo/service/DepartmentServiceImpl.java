package com.Abhishek.SpringbootDemo.service;


import com.Abhishek.SpringbootDemo.Error.DepartmentNotFoundException;
import com.Abhishek.SpringbootDemo.entity.Department;
import com.Abhishek.SpringbootDemo.respository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchalldept() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentbyID(Long departmentID) throws DepartmentNotFoundException {
        Optional<Department> dep=departmentRepository.findById(departmentID);
        if(!dep.isPresent()){
            throw new DepartmentNotFoundException("Department not Available");
        }
        return dep.get();
    }

    @Override
    public void deletedept(Long departmentID) throws DepartmentNotFoundException {
        Optional<Department> dep=departmentRepository.findById(departmentID);
        if(!dep.isPresent()){
            throw new DepartmentNotFoundException("No Department Exist");
        }
        departmentRepository.deleteById(departmentID);
    }

    @Override
    public Department Updatedeptbyid(Department department, Long departmentID) {
        Department depdb=departmentRepository.findById(departmentID).get();
        if(Objects.nonNull(department.getDepartmentName()) &&
                !" ".equalsIgnoreCase(department.getDepartmentName())){
            depdb.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentAddress()) &&
                !" ".equalsIgnoreCase(department.getDepartmentAddress())){
            depdb.setDepartmentAddress(department.getDepartmentAddress());
        }
        if(Objects.nonNull(department.getDepartmentCode()) &&
                !" ".equalsIgnoreCase(department.getDepartmentCode())){
            depdb.setDepartmentCode(department.getDepartmentCode());
        }
        return departmentRepository.save(depdb);
    }

    @Override
    public Department getDeptByName(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName);
    }


}
