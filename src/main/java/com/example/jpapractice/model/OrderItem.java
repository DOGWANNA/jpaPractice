//package com.example.jpapractice.model;
//
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//
//@Entity
//@NoArgsConstructor
//@Table(name = "ORDER_ITEM")
//public class OrderItem {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "ITEM_ID")
//    private Item item;
//
//    @ManyToOne
//    @JoinColumn(name = "ORDER_ID")
//    private POrder order;
//
//    private int orderPrice;
//    private int count;
//}
