package com.hhovhann.utilitymanagement.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseModel {
    private final Long userId;
    private final Long gasMeter;
    private final Long coldWaterMeter;
    private final Long hotWaterMeter;
    private final String error;
}
