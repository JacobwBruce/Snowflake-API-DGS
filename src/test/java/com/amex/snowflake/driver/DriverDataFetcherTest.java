package com.amex.snowflake.driver;

import com.netflix.graphql.dgs.autoconfig.DgsAutoConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.netflix.graphql.dgs.DgsQueryExecutor;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

@SpringBootTest(classes = {DgsAutoConfiguration.class, DriverDataFetcher.class})
class DriverDataFetcherTest {

    List<Driver> drivers = List.of(new Driver(
            1,
            "Lewis Hamilton",
            "driver group 1",
            "dispatch group 1",
            "site code 1",
            "123456",
            "active",
            0.1f
    ));

    @Autowired
    DgsQueryExecutor dgsQueryExecutor;

    @MockBean
    DriverService driverService;

    @BeforeEach
    public void before() {
        Mockito.when(driverService.getAllDrivers()).thenAnswer(invocation -> drivers);
        Mockito.when(driverService.findDriverByDriverCode("123456")).thenAnswer(invocation -> List.of(drivers.get(0)));
    }

    @Test
    void drivers() {
        List<String> names = dgsQueryExecutor.executeAndExtractJsonPath(
                "{ drivers { name } }",
                "data.drivers[*].name");

        assert (names).contains("Lewis Hamilton");
    }

    @Test
    void driversByDriverCode() {
        List<String> names = dgsQueryExecutor.executeAndExtractJsonPath(
                "{ drivers(driverCode: \"123456\") { name } }",
                "data.drivers[*].name");

        assert (names).contains("Lewis Hamilton");
    }
}

