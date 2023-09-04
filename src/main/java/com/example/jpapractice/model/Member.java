//package com.example.jpapractice.model;
//
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@NoArgsConstructor
//public class Member {
//    @Id
//    @Column(name = "MEMBER_ID")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String name;
//    private String city;
//    private String street;
//    private String zipcode;
//
//    @OneToMany(mappedBy = "member")
//    private List<POrder> orders = new ArrayList<POrder>();
//}
