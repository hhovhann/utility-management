package com.hhovhann.utilitymanagement.model;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class RequestModel {
    @NotNull(message = "User id is mandatory")
    private final Long userId;
    @NotNull(message = "Gas Meter is mandatory")
    private final Long gasMeter;
    @NotNull(message = "Cold water meter is mandatory")
    private final Long coldWaterMeter;
    @NotNull(message = "Hot water meter is mandatory")
    private final Long hotWaterMeter;
}
