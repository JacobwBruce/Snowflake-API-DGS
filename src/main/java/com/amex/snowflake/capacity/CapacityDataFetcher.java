package com.amex.snowflake.capacity;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@DgsComponent
public class CapacityDataFetcher {

    @Autowired
    private CapacityService capacityService;

    @DgsQuery
    public List<Capacity> capacity() {
        return capacityService.getAllCapacities();
    }

    @DgsQuery
    public long capacityCount() {
        return capacityService.getCapacityCount();
    }
}
