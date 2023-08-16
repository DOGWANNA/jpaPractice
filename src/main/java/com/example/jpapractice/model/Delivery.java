package com.example.jpapractice.model;

import com.example.jpapractice.Enum.DeliveryStatus;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class Delivery {
    @Id @GeneratedValue
    @Column(name = "DELIVERY_ID")
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private POrder order;

    private String city;
    private String street;
    private String zipode;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;
}
