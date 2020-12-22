package com.hhovhann.utilitymanagement.controller;

import com.hhovhann.utilitymanagement.model.RequestModel;
import com.hhovhann.utilitymanagement.model.ResponseModel;
import com.hhovhann.utilitymanagement.service.MeasurementService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
public class MeasurementController {

    private final MeasurementService measurementService;

    public MeasurementController(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @PostMapping("measurements")
    ResponseEntity<ResponseModel> addMeasurement(@Valid @RequestBody RequestModel requestModel) {
        return ResponseEntity.ok(measurementService.addMeasurement(requestModel));
    }

    @GetMapping("measurements/{user_id}")
    ResponseEntity<ResponseModel> findPreviousMeasurement(@Valid @NotNull @PathVariable("user_id") Long userId) {
        return ResponseEntity.ok(measurementService.getPreviousMeasurement(userId));
    }
}
