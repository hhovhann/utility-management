package com.hhovhann.utilitymanagement.repository;

import com.hhovhann.utilitymanagement.entity.Measurement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementRepository extends CrudRepository<Measurement, Long> {
    Measurement findByIdOrderByIdDesc(Long id);
}
