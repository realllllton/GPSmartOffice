package com.itsol.smartoffice.Controllers;
import com.itsol.smartoffice.Services.Employee.EmployeeService;
import com.itsol.smartoffice.dto.DepartmentDto;
import com.itsol.smartoffice.dto.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/apis")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PreAuthorize("hasAuthority('ADMIN')||hasAuthority('MANAGER')||hasAuthority('LEADER')")
    @RequestMapping("/employee")
    public ResponseEntity<List<EmployeeDto>> getdepartall() {
        List<EmployeeDto> employeeDtos = employeeService.getEmployeeall();
        return new ResponseEntity<>(employeeDtos, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')||hasAuthority('MANAGER')||hasAuthority('LEADER')")
    @DeleteMapping("/DeleteEmployee/{id}")
    public boolean DeleteEmployee(@PathVariable String id) {
        return employeeService.DeleteEmployee(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')||hasAuthority('MANAGER')||hasAuthority('LEADER')")
    @PostMapping("/Addemployee")
    public ResponseEntity<EmployeeDto> addDepartment(@RequestBody EmployeeDto employeeDto) {
        boolean result = employeeService.addEmployee(employeeDto);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')||hasAuthority('MANAGER')||hasAuthority('LEADER')")
    @RequestMapping("/getEmployee/{id}")
    public ResponseEntity<EmployeeDto> getdepartbyid(@PathVariable String id) {
        EmployeeDto departmentDtos = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(departmentDtos, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')||hasAuthority('MANAGER')||hasAuthority('LEADER')")
    @PutMapping("/updateEmployee")
    public ResponseEntity<EmployeeDto> update(@RequestBody EmployeeDto employeeDto) {
        employeeService.UpdateEmployee(employeeDto);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')||hasAuthority('MANAGER')||hasAuthority('LEADER')")
    @PostMapping("/listEmployeeInDepartment")
    public ResponseEntity<List<EmployeeDto>> getListEmployeeInDepartment(@RequestBody String id) {
        List<EmployeeDto> employeeDtos = employeeService.getListEmployeeInDepartment(id);
        return new ResponseEntity<>(employeeDtos, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')||hasAuthority('MANAGER')||hasAuthority('LEADER')")
    @RequestMapping("/listEmployeeNotDepartment")
    public ResponseEntity<List<EmployeeDto>> getListEmployeeInDepartment() {
        List<EmployeeDto> employeeDtos = employeeService.getListEmployeeNotInDepartment();
        return new ResponseEntity<>(employeeDtos, HttpStatus.OK);
    }


}
