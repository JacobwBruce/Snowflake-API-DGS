package com.amex.snowflake.capacity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Entity
@Table(name = "CAPACITY_DATA")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Capacity {
    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "Email")
    private String email;

    @Column(name = "CITY_LOCATION")
    private String city;

    @Column(name = "OPERATION_MANAGER")
    private String operationManager;

    @Column(name = "START_TIME")
    private LocalTime startTime;

    @Column(name = "COMPLETION_TIME")
    private LocalTime completionTime;

    @Column(name = "LAST_MODIFIED_TIME")
    private LocalTime lastModifiedTime;

    @Column(name = "DG")
    private Boolean dg;

    @Column(name = "DG7")
    private Boolean dg7;

    @Column(name = "MARKEN")
    private Boolean marken;

    @Column(name = "PARCEL_SHIELD")
    private Boolean parcelShield;

    @Column(name = "TSA_REQUIRED")
    private Boolean tsaRequired;

    @Column(name = "VEHICLE_TYPE_NEEDED")
    private String vehicleType;

    @Column(name = "NUMBER_OF_ICS_NEEDED")
    private Integer numberOfIcsNeeded;

    @Column(name = "MONDAY")
    private String monday;

    @Column(name = "TUESDAY")
    private String tuesday;

    @Column(name = "WEDNESDAY")
    private String wednesday;

    @Column(name = "THURSDAY")
    private String thursday;

    @Column(name = "FRIDAY")
    private String friday;

    @Column(name = "SATURDAY")
    private String saturday;

    @Column(name = "SUNDAY")
    private String sunday;

}
