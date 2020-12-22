package com.hhovhann.utilitymanagement.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@Embeddable
public class Water {
    @NotNull
    @Column(name = "cold_water_meter")
    private long coldWaterMeter;
    @NotNull
    @Column(name = "hot_water_meter")
    private long hotWaterMeter;
}
