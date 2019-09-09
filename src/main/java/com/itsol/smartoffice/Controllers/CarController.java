package com.itsol.smartoffice.Controllers;

import com.itsol.smartoffice.Services.Car.CarService;
import com.itsol.smartoffice.dto.CarDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/apis")
public class CarController {
    @Autowired
    private CarService carService;

    @RequestMapping("/car")
    public ResponseEntity<List<CarDto>> getcarall() {
        List<CarDto> car = carService.getcarall();
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @RequestMapping("/car/{numberplate}")
    public CarDto getcarinfo(@PathVariable String numberplate) {
        return carService.getcarinfo(numberplate);
    }

    @DeleteMapping("/car/{numberplate}")
    public boolean deletecarinfo(@PathVariable String numberplate) {
        return carService.deletecarinfo(numberplate);
    }
}
