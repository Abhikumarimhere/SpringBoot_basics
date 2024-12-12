package com.Abhishek.SpringbootDemo.service;

import com.Abhishek.SpringbootDemo.entity.Department;
import com.Abhishek.SpringbootDemo.respository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DepartmentServiceTest {
    @Autowired
    private DepartmentService departmentService;
    @MockitoBean
    private DepartmentRepository departmentRepository;
    @BeforeEach
    void setUp() {
        Department department= Department.builder().departmentCode("IT-09").
                departmentID(1L).
                departmentName("CSE").
                departmentAddress("Bangalore").build();
        Mockito.when(departmentRepository.findByDepartmentName("CSE")).thenReturn(department);
    }
@Test
@DisplayName("Department name testing")
    public void whendeptnamevalid_returndept(){
        String departmentName="CSE";
        Department found=departmentService.getDeptByName(departmentName);
        assertEquals(departmentName,found.getDepartmentName());
    }
}