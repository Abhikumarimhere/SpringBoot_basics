package com.Abhishek.SpringbootDemo.Controller;

import com.Abhishek.SpringbootDemo.Error.DepartmentNotFoundException;
import com.Abhishek.SpringbootDemo.entity.Department;
import com.Abhishek.SpringbootDemo.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER=LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchalldept(){
        LOGGER.info("Inside fetchalldept of DepartmentController");
        return departmentService.fetchalldept();
    }
    @GetMapping("/departments/{id}")
    public Department fetchbyID(@PathVariable("id")Long departmentID) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentbyID(departmentID);
    }
    @DeleteMapping("/departments/{id}")
    public String DeletedeptbyID(@PathVariable("id")Long departmentID)throws DepartmentNotFoundException {
        departmentService.deletedept(departmentID);
        return "department deleted sucessfully";
    }
    @PutMapping("/departments/{id}")
    public Department Updatedeptbyid(@RequestBody Department department,@PathVariable("id")Long departmentID){
        return departmentService.Updatedeptbyid(department,departmentID);
    }
    @GetMapping("/departments/name/{name}")
    public Department getDeptByName(@PathVariable("name")String departmentName)throws DepartmentNotFoundException{
        return departmentService.getDeptByName(departmentName);
    }
}

