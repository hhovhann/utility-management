package com.hhovhann.utilitymanagement.repository;

import com.hhovhann.utilitymanagement.entity.Measurement;
import org.springframework.data.repository.CrudRepository;

public interface MeasurementRepository extends CrudRepository<Measurement, Long> {
    <T> T findPreviousMeasurement();

    <T> T  insertMeasurement();
}
