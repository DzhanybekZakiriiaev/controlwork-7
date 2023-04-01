package com.example.controlwork7.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
@Data
@RequiredArgsConstructor
public class Order {
    private Integer orderId;
    private User clientOrder;
    private Food foodOrder;
    private Place placeOrder;
    private LocalDateTime timeOrder;
}
