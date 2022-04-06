package ng.com.createsoftware.dailycodebuffer.repository;

import ng.com.createsoftware.dailycodebuffer.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository repository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department dept =
                Department.builder()
                .departmentName("law")
                .departmentAddress("Abuja")
                .departmentCode("002")
                .build();
        entityManager.persist(dept);
    }

    @Test
    @DisplayName("Repository Testing")
    public void whenFindById_thenReturnDepatment(){
        Department dept = repository.findById(1L).get();
        assertEquals(dept.getDepartmentName(), "law");
    }
}