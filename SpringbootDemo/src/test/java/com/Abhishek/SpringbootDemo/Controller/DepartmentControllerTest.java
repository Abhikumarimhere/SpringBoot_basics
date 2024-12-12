package com.Abhishek.SpringbootDemo.Controller;

import com.Abhishek.SpringbootDemo.Error.DepartmentNotFoundException;
import com.Abhishek.SpringbootDemo.entity.Department;
import com.Abhishek.SpringbootDemo.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockitoBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp(){
        department=Department.builder()
                .departmentID(1L)
                .departmentCode("CSE-09")
                .departmentAddress("Kolkata")
                .departmentName("CSE")
                .build();
    }

    @Test
    void saveDepartment() throws Exception {
        Department inputdepartment=Department.builder()
                .departmentAddress("Kolkata")
                .departmentName("CSE")
                .departmentCode("CSE-09")
                .build();
        Mockito.when(departmentService.saveDepartment(inputdepartment)).thenReturn(department);
        mockMvc.perform(post("/departments").
                contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\t\"departmentName\":\"CSE\",\n" +
                        "\t\"departmentAddress\":\"Kolkata\",\n" +
                        "\t\"departmentCode\":\"CSE-09\"\n" +
                        "}"))
                .andExpect(status().isOk());

    }

    @Test
    void fetchbyID() throws Exception {
        Long departmetID=1l;
        Mockito.when(departmentService.fetchDepartmentbyID(departmetID)).thenReturn(department);
        mockMvc.perform(get("/departments/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departmentName").value(department.getDepartmentName()));
    }
}