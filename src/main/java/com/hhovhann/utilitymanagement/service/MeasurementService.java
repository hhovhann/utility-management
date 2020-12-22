package com.hhovhann.utilitymanagement.service;

import com.hhovhann.utilitymanagement.entity.Measurement;
import com.hhovhann.utilitymanagement.model.RequestModel;
import com.hhovhann.utilitymanagement.model.ResponseModel;

import java.util.Optional;

public interface MeasurementService {
    ResponseModel addMeasurement(RequestModel model);

    ResponseModel getPreviousMeasurement(Long userId);

    Optional<Measurement> findMeasurement(long measurementId);
}
