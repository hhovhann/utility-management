package com.hhovhann.utilitymanagement.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ResponseModel {
    private Long userId;
    private Long gasMeter;
    private Long coldWaterMeter;
    private Long hotWaterMeter;
    private String error;
}
