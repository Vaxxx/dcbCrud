package ng.com.createsoftware.dailycodebuffer.controller;

import ng.com.createsoftware.dailycodebuffer.entity.Department;
import ng.com.createsoftware.dailycodebuffer.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService service;
    private Department dept;

    @BeforeEach
    void setUp(){
        dept = Department.builder()
                .departmentName("Vax")
                .departmentAddress("Abuja")
                .departmentCode("001")
                .departmentId(1L)
                .build();
    }


    @Test
    void saveDepartment() throws Exception {
      Department inputDept =  Department.builder()
                .departmentName("Vax")
                .departmentAddress("Abuja")
                .departmentCode("001")
                .build();

      Mockito.when(service.saveDepartment(inputDept))
              .thenReturn(dept);

      mockMvc.perform(post("/departments")
              .contentType(MediaType.APPLICATION_JSON)
              .content(
                      "{\n" +
                              "    \"departmentId\": 1,\n" +
                              "    \"departmentName\": \"Vax\",\n" +
                              "    \"departmentAddress\": \"Abuja\",\n" +
                              "    \"departmentCode\": \"001\"\n" +
                              "}"

              ))
        .andExpect(status().isOk());
    }

    //@Test

//    void fetchDepartmentById() throws Exception {
//        Mockito.when(service.fetchDepartmentById(1L))
//                .thenReturn(dept);
//
//        mockMvc.perform(get("/departments/1")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.departmentName")
//                .value(dept.getDepartmentName()));
//
//    }
}