package com.amex.snowflake.driver;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@DgsComponent
public class DriverDataFetcher {

    @Autowired
    private DriverService driverService;

    @DgsQuery
    public List<Driver> drivers(@InputArgument String driverCode){
        if(driverCode == null){
            return driverService.getAllDrivers();
        }
        return driverService.findDriverByDriverCode(driverCode);
    }
}
