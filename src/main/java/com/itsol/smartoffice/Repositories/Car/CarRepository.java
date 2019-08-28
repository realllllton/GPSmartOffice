package com.itsol.smartoffice.Repositories.Car;


import com.itsol.smartoffice.dto.CarDto;

import java.util.List;

public interface CarRepository {

    List<CarDto> getcarall();

    CarDto getcarinfo(String numberplate);

    boolean deletecarinfo(String numberplate);
}
