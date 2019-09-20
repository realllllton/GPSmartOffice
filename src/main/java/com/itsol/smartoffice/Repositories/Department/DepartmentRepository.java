package com.itsol.smartoffice.Repositories.Department;

import com.itsol.smartoffice.dto.DepartmentDto;

import java.util.List;

public interface DepartmentRepository {
    List<DepartmentDto> getdepartall();
    boolean DeleteDepartment(String id_department);
    boolean addDepartment(DepartmentDto departmentDto);
    List<DepartmentDto> Search(DepartmentDto departmentDto);
    DepartmentDto getDepartmentById(String id_department);
    boolean UpdateDepartment(DepartmentDto departmentDto);
//    public List<?> getListEmployeeInDepartment(DepartmentDto departmentDto);
    List<DepartmentDto> GetCountListEmployeeInDepartment(String id_department);
}
