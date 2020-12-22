package com.hhovhann.utilitymanagement.controller;

import com.hhovhann.utilitymanagement.entity.Measurement;
import com.hhovhann.utilitymanagement.entity.User;
import com.hhovhann.utilitymanagement.model.RequestModel;
import com.hhovhann.utilitymanagement.model.ResponseModel;
import com.hhovhann.utilitymanagement.service.MeasurementService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Validated
@RestController("/measurements")
public class MeasurementController {

    private final MeasurementService measurementService;

    public MeasurementController(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @PostMapping("/{user_id}")
    ResponseEntity<ResponseModel> addMeasurement(@Valid String userId, @Valid @RequestBody RequestModel requestModel) {

        return ResponseEntity.ok(measurementService.addMeasurement());
    }

    @GetMapping("/{user_id}")
    ResponseEntity<ResponseModel> findPreviousMeasurement(@Valid @RequestBody RequestModel requestModel) {
        return ResponseEntity.ok(measurementService.getPreviousMeasurement(requestModel));
    }
}
