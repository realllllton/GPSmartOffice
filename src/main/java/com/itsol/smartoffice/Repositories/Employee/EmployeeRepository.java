package com.itsol.smartoffice.Repositories.Employee;

import com.itsol.smartoffice.dto.DepartmentDto;
import com.itsol.smartoffice.dto.EmployeeDto;

import java.util.List;

public interface EmployeeRepository {
    List<EmployeeDto> getEmployeeAll();
    boolean DeleteEmployee(String id_employee);
    boolean addEmployee(EmployeeDto employeeDto);
//    List<EmployeeDto> SearchEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(String id_employee);
    boolean UpdateEmployee(EmployeeDto employeeDto);
    List<EmployeeDto> getListEmployeeInDepartment(String id);
    public List<EmployeeDto> getListEmployeeNotInDepartment();
    List<EmployeeDto> Search(EmployeeDto employeeDto);
}
