package ng.com.createsoftware.dailycodebuffer.service;

import ng.com.createsoftware.dailycodebuffer.entity.Department;
import ng.com.createsoftware.dailycodebuffer.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {
    @Autowired
    private DepartmentService service;

    @MockBean
    private DepartmentRepository repository;

    @BeforeEach
    void setUp() {
        //builder was configured in the Department model
        Department dept =
                Department.builder()
                .departmentName("Vakpo")
                .departmentAddress("Niger")
                .departmentCode("023")
                .departmentId(1L)
                .build() ;

        Mockito.when(repository.findByDepartmentName("Vakpo"))
                .thenReturn(dept);
    }

    @Test
    @DisplayName("Get Data based on Valid Department Name")
    public void whenValidDepartmentName_thenDepartmentShouldFound(){
          String departmentName = "Vakpo";
          Department found = service.fetchDepartmentByName(departmentName);

          assertEquals(departmentName, found.getDepartmentName());
    }
}