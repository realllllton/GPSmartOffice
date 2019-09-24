package com.itsol.smartoffice.Services.Employee;

import com.itsol.smartoffice.dto.DepartmentDto;
import com.itsol.smartoffice.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDto> getEmployeeall();
    Boolean DeleteEmployee(String id_employee);
    Boolean addEmployee(EmployeeDto employeeDto);
//    List<EmployeeDto> search(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(String id_employee);
    Boolean UpdateEmployee(EmployeeDto employeeDto);
    List<EmployeeDto> getListEmployeeInDepartment(String id);
    List<EmployeeDto> getListEmployeeNotInDepartment();
    List<EmployeeDto> Search(EmployeeDto employeeDto);
}
