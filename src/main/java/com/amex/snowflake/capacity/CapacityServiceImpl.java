package com.amex.snowflake.capacity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

interface CapacityService {
    List<Capacity> getAllCapacities();
    long getCapacityCount();
}
@Service
public class CapacityServiceImpl implements CapacityService{

    @Autowired
    private CapacityRepository capacityRepository;

    public List<Capacity> getAllCapacities() {
        return capacityRepository.findAll();
    }

    public long getCapacityCount() {
        return capacityRepository.count();
    }
}
