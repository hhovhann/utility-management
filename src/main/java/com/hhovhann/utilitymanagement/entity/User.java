package com.hhovhann.utilitymanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "full_name")
    @NotBlank(message = "Full name is mandatory")
    private String fullName;
    @OneToOne(mappedBy = "measurement", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private Measurement measurement;
}
