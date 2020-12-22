package com.hhovhann.utilitymanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Data
@Builder
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Gas {
    @NotNull
    private long gasMeter;
}
