package com.hhovhann.utilitymanagement.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
public class RequestModel {
    @NotNull(message = "User id is mandatory")
    private Long userId;
    @NotNull(message = "Gas Meter is mandatory")
    private Long gasMeter;
    @NotNull(message = "Cold water meter is mandatory")
    private Long coldWaterMeter;
    @NotNull(message = "Hot water meter is mandatory")
    private Long hotWaterMeter;
}
