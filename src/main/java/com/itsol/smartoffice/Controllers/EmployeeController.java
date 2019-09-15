package com.itsol.smartoffice.Controllers;




import com.itsol.smartoffice.Servicess.Employee.EmployeeService;
import com.itsol.smartoffice.dto.DepartmentDto;
import com.itsol.smartoffice.dto.EmployeeDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(EmployeeController.BASE_URL)
public class EmployeeController {
    public static final String BASE_URL = "/apis";

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @RequestMapping("/employee")
    public ResponseEntity<List<EmployeeDto>> getdepartall(){
        List<EmployeeDto> employeeDtos = employeeService.getEmployeeall();
        return new ResponseEntity<>(employeeDtos, HttpStatus.OK);
    }

    @DeleteMapping("/DeleteEmployee/{id}")
    public boolean DeleteEmployee(@PathVariable String id) {
        return employeeService.DeleteEmployee(id);
    }

    @PostMapping("/Addemployee")
    public ResponseEntity<EmployeeDto> addDepartment(@RequestBody EmployeeDto employeeDto){
        boolean result = employeeService.addEmployee(employeeDto);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }

//    @PostMapping("/search")
//    public ResponseEntity<List<DepartmentDto>> search(@RequestBody DepartmentDto departmentDto) {
//        List<DepartmentDto> departmentDtos = departmentService.search(departmentDto);
//        return new ResponseEntity<>(departmentDtos, HttpStatus.OK);
//    }

    @RequestMapping("/getEmployee/{id}")
    public ResponseEntity<EmployeeDto> getdepartbyid(@PathVariable String id){
        EmployeeDto departmentDtos = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(departmentDtos, HttpStatus.OK);
    }

    @PutMapping("/updateEmployee")
    public ResponseEntity<EmployeeDto> update(@RequestBody EmployeeDto employeeDto){
        employeeService.UpdateEmployee(employeeDto);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }

    @PostMapping("/listEmployeeInDepartment")
    public ResponseEntity<List<EmployeeDto>> getListEmployeeInDepartment(@RequestBody String id){
        List<EmployeeDto> departmentDtos = employeeService.getListEmployeeInDepartment(id);
        return new ResponseEntity<>(departmentDtos, HttpStatus.OK);
    }

}
