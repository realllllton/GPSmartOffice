package com.itsol.smartoffice.Servicess.Car;

import com.itsol.smartoffice.dto.CarDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {
    List<CarDto> getcarall();

    CarDto getcarinfo(String numberplate);

    boolean deletecarinfo(String numberplate);
}
