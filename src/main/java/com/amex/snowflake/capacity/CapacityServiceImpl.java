package com.amex.snowflake.capacity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

interface CapacityService {
  List<Capacity> getAllCapacities();

  List<CapacityCount> getCapacityCount();

  CapacityCount getCapacityCountByLocation(String location);
}

@Service
public class CapacityServiceImpl implements CapacityService {

  @Autowired
  private CapacityRepository capacityRepository;

  public List<Capacity> getAllCapacities() {
    return capacityRepository.findAll();
  }

  public List<CapacityCount> getCapacityCount() {
    List<Map<String, Object>> results = capacityRepository.getCapacityCount(); 
    return results.stream().map(CapacityCount::new).collect(Collectors.toList());
  }

  public CapacityCount getCapacityCountByLocation(String location) {
    Map<String, Object> result = capacityRepository.getCapacityCountByLocation(location);
    CapacityCount capacityCount = new CapacityCount(result); 
    if (capacityCount.getLocation() == null) {
      return null;
    }
    return capacityCount;
  }
}
