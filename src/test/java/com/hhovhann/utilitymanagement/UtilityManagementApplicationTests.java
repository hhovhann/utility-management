package com.hhovhann.utilitymanagement;

import com.hhovhann.utilitymanagement.controller.MeasurementController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UtilityManagementApplicationTests {

    @Autowired
    private MeasurementController measurementController;

    @Test
    void contextLoads() {
        assertThat(measurementController).isNotNull();
    }
}
