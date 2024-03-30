package com.amex.snowflake.driver;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "VIEW_ACTIVE_VENDORS_ID")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Driver {
    @Id
    @Column(name = "DRIVERID")
    private int id;
    @Column(name = "DRIVERNAME")
    private String name;
    @Column(name = "DRIVERGROUP")
    private String driverGroup;
    @Column(name = "DISPATCHGROUP")
    private String dispatchGroup;
    @Column(name = "SITECODE")
    private String siteCode;
    @Column(name = "DRIVERCODE")
    private String driverCode;
    @Column(name = "DRIVERSTATUS")
    private String status;
    @Column(name = "COMMISSIONPERCENT")
    private Float commissionPercentage;
}
