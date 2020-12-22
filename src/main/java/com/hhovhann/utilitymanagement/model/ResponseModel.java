package com.hhovhann.utilitymanagement.model;

import com.hhovhann.utilitymanagement.entity.Gas;
import com.hhovhann.utilitymanagement.entity.Water;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ResponseModel {
    Gas gas;
    Water water;
    String error;
}
