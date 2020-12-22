package com.hhovhann.utilitymanagement.service;

import com.hhovhann.utilitymanagement.entity.Measurement;
import com.hhovhann.utilitymanagement.model.RequestModel;
import com.hhovhann.utilitymanagement.model.ResponseModel;
import com.hhovhann.utilitymanagement.repository.MeasurementRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MeasurementServiceImpl implements MeasurementService {
    private final MeasurementRepository measurementRepository;

    public MeasurementServiceImpl(MeasurementRepository measurementRepository) {
        this.measurementRepository = measurementRepository;
    }

    @Override
    public ResponseModel addMeasurement() {
        return measurementRepository.insertMeasurement();
    }

    @Override
    public ResponseModel getPreviousMeasurement(RequestModel model) {
        return measurementRepository.findPreviousMeasurement();
    }

    @Override
    public Optional<Measurement> findMeasurement(long measurementId) {
        return measurementRepository.findById(measurementId);
    }
}
