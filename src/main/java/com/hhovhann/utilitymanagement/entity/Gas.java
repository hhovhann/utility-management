package com.hhovhann.utilitymanagement.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Data
@Builder
@Embeddable
public class Gas {
    @NotNull
    private long gasMeter;
}
