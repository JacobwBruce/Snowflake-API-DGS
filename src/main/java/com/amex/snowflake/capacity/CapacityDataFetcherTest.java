package com.amex.snowflake.capacity;

import com.amex.snowflake.driver.DriverDataFetcher;
import com.netflix.graphql.dgs.DgsQueryExecutor;
import com.netflix.graphql.dgs.autoconfig.DgsAutoConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalTime;
import java.util.List;

@SpringBootTest(classes = {DgsAutoConfiguration.class, CapacityDataFetcher.class})
public class CapacityDataFetcherTest {

    List<Capacity> capacities = List.of(new Capacity(
            1,
            "John Doe",
            "johndoe@gmail.com",
            "New York",
            "Jane Doe",
            LocalTime.of(8, 0),
            LocalTime.of(17, 0),
            LocalTime.of(16, 0),
            true,
            false,
            true,
            false,
            true,
            "Car",
            2,
            "8am-5pm",
            "8am-5pm",
            "8am-5pm",
            "8am-5pm",
            "8am-5pm",
            null,
            null
    ));

    @Autowired
    DgsQueryExecutor dgsQueryExecutor;

    @MockBean
    CapacityService capacityService;

    @BeforeEach
    public void before() {
        Mockito.when(capacityService.getAllCapacities()).thenAnswer(invocation -> capacities);
        Mockito.when(capacityService.getCapacityCount()).thenAnswer(invocation -> 1L);
    }

    @Test
    void capacities() {
        List<String> names = dgsQueryExecutor.executeAndExtractJsonPath(
                "{ capacity { name } }",
                "data.capacity[*].name");

        assert (names).contains("John Doe");
    }

    @Test
    void capacityCount() {
        Integer count = dgsQueryExecutor.executeAndExtractJsonPath(
                "{ capacityCount }",
                "data.capacityCount");

        assert (count == 1);
    }

}
