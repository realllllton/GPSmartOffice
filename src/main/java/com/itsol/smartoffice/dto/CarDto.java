package com.itsol.smartoffice.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CarDto {

    private String numberplate;
    private String namecar;
    private int yearofmanufacture;
    private String brand;
    private boolean haveinsurance;
    private String email;
    private boolean status;
}
