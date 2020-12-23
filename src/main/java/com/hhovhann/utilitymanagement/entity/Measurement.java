package com.hhovhann.utilitymanagement.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Measurement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    @Column(name = "id")
    private Long id;
    @Embedded
    private Gas gas;
    @Embedded
    private Water water;
    @MapsId
    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
    private User user;
}
