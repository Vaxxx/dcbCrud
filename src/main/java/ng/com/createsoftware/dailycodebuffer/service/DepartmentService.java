package ng.com.createsoftware.dailycodebuffer.service;

import ng.com.createsoftware.dailycodebuffer.entity.Department;
import ng.com.createsoftware.dailycodebuffer.exception.DepartmentNotFoundException;

import java.util.List;


public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> fetchDepartmentList();

    Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    void deleteDepartmentById(Long departmentId);

    Department updateDepartmentById(Long departmentId, Department department);

    Department fetchDepartmentByName(String departmentName);

    Department fetchDepartmentByNameIgnoreCase(String departmentName);
}
