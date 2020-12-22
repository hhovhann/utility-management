package com.hhovhann.utilitymanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Measurement {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Embedded
    private Gas gas;
    @Embedded
    private Water water;
    @OneToOne
    @JoinColumn(name = "id")
    private User user;
}
