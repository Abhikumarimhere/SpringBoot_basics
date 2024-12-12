package com.Abhishek.SpringbootDemo.respository;

import com.Abhishek.SpringbootDemo.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class DepartmentRepositoryTest {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department= Department.builder()
                .departmentAddress("Mumbai")
                .departmentName("Electrical")
                .departmentCode("EE-09")
                .build();
        entityManager.persist(department);
    }


    @Test
    public void whendeptIDfound_returndepartment(){
        Department department=departmentRepository.findById(1L).get();
        assertEquals(department.getDepartmentName(),"Electrical");
    }
}