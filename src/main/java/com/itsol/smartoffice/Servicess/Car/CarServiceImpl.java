package com.itsol.smartoffice.Servicess.Car;

import com.itsol.smartoffice.Repositories.Car.CarRepository;
import com.itsol.smartoffice.dto.CarDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private Logger logger = LoggerFactory.getLogger(CarServiceImpl.class);

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<CarDto> getcarall() {
        logger.info("Get list car all");
        return carRepository.getcarall();
    }

    @Override
    public CarDto getcarinfo(String numberplate) {
        logger.info("Get info car, "+ numberplate);
        return carRepository.getcarinfo(numberplate);
    }

    @Override
    public boolean deletecarinfo(String numberplate) {
        logger.info("Delete car, "+ numberplate);
        return carRepository.deletecarinfo(numberplate);
    }
}
