package com.hhovhann.utilitymanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Data
@Builder
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Gas {
    @NotNull
    @Column(name = "gas_meter")
    private long gasMeter;
}
