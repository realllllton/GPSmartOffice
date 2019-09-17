package com.itsol.smartoffice.Servicess.Department;

import com.itsol.smartoffice.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    List<DepartmentDto> getdepartall();
    Boolean DeleteDepartment(String id_department);
    Boolean addDepartment(DepartmentDto departmentDto);
    List<DepartmentDto> search(DepartmentDto departmentDto);
    DepartmentDto getDepartById(String id_department);
    Boolean UpdateDepartment(DepartmentDto departmentDto);
//    List<DepartmentDto> getListEmployeeInDepartment(DepartmentDto departmentDto);
    List<DepartmentDto> GetListCountEmployeeInDepartment(String id_department);
}
