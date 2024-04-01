package com.amex.snowflake.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

interface DriverService {
    List<Driver> getAllDrivers();
    List<Driver> findDriverByDriverCode(String driverCode);

}

@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepository driverRepository;

    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    public List<Driver> findDriverByDriverCode(String driverCode) {
        return driverRepository.findByDriverCode(driverCode);
    }

}

