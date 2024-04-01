package com.amex.snowflake.capacity;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CapacityRepository extends JpaRepository<Capacity, Integer> {

  @Query(value = "SELECT COUNT(CASE WHEN COMPLETION_TIME IS NULL THEN 1 END) AS OPEN, COUNT(CASE WHEN COMPLETION_TIME IS NOT NULL THEN 1 END) AS COMPLETED, CITY_LOCATION FROM STG_AMEX.VIC.CAPACITY_DATA GROUP BY CITY_LOCATION;", nativeQuery = true)
  List<Map<String, Object>> getCapacityCount();

  @Query(value = "SELECT COUNT(CASE WHEN COMPLETION_TIME IS NULL THEN 1 END) AS OPEN, COUNT(CASE WHEN COMPLETION_TIME IS NOT NULL THEN 1 END) AS COMPLETED, CITY_LOCATION FROM STG_AMEX.VIC.CAPACITY_DATA WHERE CITY_LOCATION = ?1  GROUP BY CITY_LOCATION;", nativeQuery = true) 
  Map<String, Object> getCapacityCountByLocation(String location);
}


