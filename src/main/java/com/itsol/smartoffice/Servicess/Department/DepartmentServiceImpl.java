package com.itsol.smartoffice.Servicess.Department;

import com.itsol.smartoffice.Repositories.Department.DepartmentRepository;
import com.itsol.smartoffice.dto.DepartmentDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<DepartmentDto> getdepartall() {
        logger.info("get list all department");
        return departmentRepository.getdepartall();
    }

//    @Override
//    public List<DepartmentDto> getListEmployeeInDepartment(DepartmentDto departmentDto){
//        logger.info("get list Employee in Deprtment");
//        return departmentRepository.getListEmployeeInDepartment(departmentDto);
//    }
    @Override
    public Boolean DeleteDepartment(String id_department) {
        logger.info("Delete Department, "+ id_department);
        return departmentRepository.DeleteDepartment(id_department);
    }

    @Override
    public Boolean addDepartment(DepartmentDto departmentDto) {
        logger.info("Add Department");
        return departmentRepository.addDepartment(departmentDto);
    }
    @Override
    public List<DepartmentDto> search(DepartmentDto departmentDto) {
        logger.info("Search Department");
        logger.info(""+departmentDto);
        return departmentRepository.Search(departmentDto);
    }
    @Override
    public DepartmentDto getDepartById(String id_department){
        DepartmentDto departmentDto = departmentRepository.getDepartmentById(id_department);
        logger.info("get by id department");
        return departmentDto;
    }
    @Override
    public Boolean UpdateDepartment(DepartmentDto departmentDto) {
        logger.info(""+departmentDto);
        departmentRepository.UpdateDepartment(departmentDto);
        return true;
    }

}
