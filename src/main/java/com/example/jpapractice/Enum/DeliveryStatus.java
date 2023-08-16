package com.example.jpapractice.Enum;

import lombok.Getter;

@Getter
public enum DeliveryStatus {
    READY("준비"),
    COMP("배송");

    private final String korean;

    DeliveryStatus(String korean){
        this.korean = korean;
    }
}
