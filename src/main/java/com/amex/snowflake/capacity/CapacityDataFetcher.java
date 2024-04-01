package com.amex.snowflake.capacity;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;

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
    public List<CapacityCount> capacityCount(@InputArgument String location) {
        if(location == null){
            return capacityService.getCapacityCount();
        }
        
        CapacityCount capacityCount = capacityService.getCapacityCountByLocation(location);
        if (capacityCount == null) {
            return List.of();
        }
        return List.of(capacityCount);
    }
}
