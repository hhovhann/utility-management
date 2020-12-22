package com.hhovhann.utilitymanagement.service;

import com.hhovhann.utilitymanagement.entity.Gas;
import com.hhovhann.utilitymanagement.entity.Measurement;
import com.hhovhann.utilitymanagement.entity.User;
import com.hhovhann.utilitymanagement.entity.Water;
import com.hhovhann.utilitymanagement.model.RequestModel;
import com.hhovhann.utilitymanagement.model.ResponseModel;
import com.hhovhann.utilitymanagement.repository.MeasurementRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class MeasurementServiceImpl implements MeasurementService {
    private final MeasurementRepository measurementRepository;

    public MeasurementServiceImpl(MeasurementRepository measurementRepository) {
        this.measurementRepository = measurementRepository;
    }

    @Override
    public ResponseModel addMeasurement(RequestModel model) {
        Measurement measurement = measurementRepository.save(
                Measurement.builder()
                        .user(User.builder().id(model.getUserId()).build())
                        .gas(Gas.builder().gasMeter(model.getGasMeter()).build())
                        .water(Water.builder().coldWaterMeter(model.getColdWaterMeter()).hotWaterMeter(model.getColdWaterMeter()).build())
                        .build()
        );
        // TODO: After need replace runtime exception with validation checking, null checking to be sure that all insertion happened properly
        if (Objects.isNull(measurement)) throw new RuntimeException("Something happened during Measurement save.");
        return ResponseModel.builder()
                .gasMeter(measurement.getGas().getGasMeter())
                .coldWaterMeter(measurement.getWater().getColdWaterMeter())
                .hotWaterMeter(measurement.getWater().getHotWaterMeter())
                .error("no errors")
                .build();
    }

    @Override
    public ResponseModel getPreviousMeasurement(Long userId) {
        Measurement lastMeasurement = measurementRepository.findByIdOrderByIdDesc(userId);
        // TODO: After need replace runtime exception with validation checking, null checking to be sure that all insertion happened properly
        if (Objects.isNull(lastMeasurement))
            throw new RuntimeException("Something happened when trying to retrieve previous measurement.");
        return ResponseModel.builder()
                .gasMeter(lastMeasurement.getGas().getGasMeter())
                .coldWaterMeter(lastMeasurement.getWater().getColdWaterMeter())
                .hotWaterMeter(lastMeasurement.getWater().getHotWaterMeter())
                .error("no error")
                .build();
    }

    @Override
    public Optional<Measurement> findMeasurement(long measurementId) {
        return measurementRepository.findById(measurementId);
    }
}
