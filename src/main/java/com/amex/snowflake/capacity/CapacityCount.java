package com.amex.snowflake.capacity;


import java.util.Map;


public class CapacityCount {

  private Long open;

  private Long completed;

  private String location;

  public CapacityCount() {
  }

  public CapacityCount(Long open, Long completed, String location) {
    this.open = open;
    this.completed = completed;
    this.location = location;
  }

  public CapacityCount(Map<String, Object> values) {
    this.open = (Long) values.get("OPEN");
    this.completed = (Long) values.get("COMPLETED");
    this.location = (String) values.get("CITY_LOCATION");
  }

  public Long getOpen() {
    return open;
  }

  public Long getCompleted() {
    return completed;
  }

  public String getLocation() {
    return location;
  }

  public void setOpen(Long open) {
    this.open = open;
  }

  public void setCompleted(Long completed) {
    this.completed = completed;
  }

  public void setLocation(String location) {
    this.location = location;
  }
}
