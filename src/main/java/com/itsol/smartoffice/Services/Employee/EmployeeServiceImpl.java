package com.itsol.smartoffice.Services.Employee;

import com.itsol.smartoffice.Repositories.Employee.EmployeeRepository;
import com.itsol.smartoffice.dto.DepartmentDto;
import com.itsol.smartoffice.dto.EmployeeDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{
    private Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @Override
    public List<EmployeeDto> getEmployeeall() {
        logger.info("get list all employee");
        return employeeRepository.getEmployeeAll();
    }

    @Override
    public Boolean DeleteEmployee(String id_employee) {
        logger.info("Delete employee, "+ id_employee);
        return employeeRepository.DeleteEmployee(id_employee);
    }

    @Override
    public Boolean addEmployee(EmployeeDto employeeDto) {
        logger.info("Add employee");
        return employeeRepository.addEmployee(employeeDto);
    }


    @Override
    public EmployeeDto getEmployeeById(String id_employee) {
        EmployeeDto employeeDto = employeeRepository.getEmployeeById(id_employee);
        logger.info("get by id employee");
        return employeeDto;
    }

    @Override
    public Boolean UpdateEmployee(EmployeeDto employeeDto) {
        logger.info(""+employeeDto);
        return employeeRepository.UpdateEmployee(employeeDto);
    }

    @Override
    public List<EmployeeDto> getListEmployeeInDepartment(String id){
        logger.info("get list Employee in Depratment");
        return employeeRepository.getListEmployeeInDepartment(id);
    }

    @Override
    public List<EmployeeDto> getListEmployeeNotInDepartment() {
        logger.info("get list employee not in department");
        return employeeRepository.getListEmployeeNotInDepartment();
    }


}
