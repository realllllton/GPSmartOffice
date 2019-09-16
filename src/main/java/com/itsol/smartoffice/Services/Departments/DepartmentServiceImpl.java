package com.itsol.smartoffice.Services.Departments;

import com.itsol.smartoffice.Repositories.Departments.DepartmentRepository;
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
        logger.info("get list all departments");
        return departmentRepository.getdepartall();
    }
}
