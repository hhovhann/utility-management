package com.hhovhann.utilitymanagement.service;

import com.hhovhann.utilitymanagement.entity.Gas;
import com.hhovhann.utilitymanagement.entity.Measurement;
import com.hhovhann.utilitymanagement.entity.User;
import com.hhovhann.utilitymanagement.entity.Water;
import com.hhovhann.utilitymanagement.model.RequestModel;
import com.hhovhann.utilitymanagement.model.ResponseModel;
import com.hhovhann.utilitymanagement.repository.MeasurementRepository;
import com.hhovhann.utilitymanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MeasurementServiceImpl implements MeasurementService {
    private final UserRepository userRepository;
    private final MeasurementRepository measurementRepository;

    @Override
    public ResponseModel addMeasurement(RequestModel model) {
        var user = userRepository.save(User.builder().id(model.getUserId()).build());
        if (Objects.isNull(user))
            return ResponseModel.builder().error("Something happened when trying to add a user.").build();
        var measurement = measurementRepository.save(
                Measurement.builder()
                        .user(user)
                        .gas(Gas.builder().gasMeter(model.getGasMeter()).build())
                        .water(Water.builder().coldWaterMeter(model.getColdWaterMeter()).hotWaterMeter(model.getHotWaterMeter()).build())
                        .build());
        if (Objects.isNull(measurement))
            return ResponseModel.builder().error("Something happened when trying to add a measurement.").build();
        return ResponseModel.builder()
                .userId(measurement.getUser().getId())
                .gasMeter(measurement.getGas().getGasMeter())
                .hotWaterMeter(measurement.getWater().getHotWaterMeter())
                .coldWaterMeter(measurement.getWater().getColdWaterMeter())
                .error("no errors").build();
    }

    @Override
    public ResponseModel getPreviousMeasurement(Long userId) {
        var lastMeasurement = measurementRepository.findByIdOrderByIdDesc(userId);
        if (Objects.isNull(lastMeasurement))
            return ResponseModel.builder().error("Something happened when trying to retrieve previously measurement.").build();
        return ResponseModel.builder()
                .userId(lastMeasurement.getUser().getId())
                .gasMeter(lastMeasurement.getGas().getGasMeter())
                .hotWaterMeter(lastMeasurement.getWater().getHotWaterMeter())
                .coldWaterMeter(lastMeasurement.getWater().getColdWaterMeter())
                .error("no error").build();
    }

    @Override
    public Optional<Measurement> findMeasurement(long measurementId) {
        return measurementRepository.findById(measurementId);
    }
}
