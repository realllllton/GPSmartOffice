package com.itsol.smartoffice.dto;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * Create class model base
 * <p>
 * project
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class DepartmentDto {

    private String id_department;
    private String name_department;
    private String count_employee;
}
