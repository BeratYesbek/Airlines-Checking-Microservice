package com.beratyesbek.airlinesChecking.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "bought_tickets")
public class BoughtTicket {
    @Id
    @Column(name = "bought_ticket_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int boughtTicketId;

    @Column(name = "externalId",nullable = false)
    private int externalId;

    @Column(name = "checking_code", columnDefinition = "VARCHAR(255)", unique = true, nullable = false)
    private String checkingCode;

    @Column(name = "full_name",nullable = false)
    private String fullName;

    @Column(name = "user_email",nullable = false)
    private String userEmail;

    @Column(name = "identity_number",nullable = false)
    private String identityNumber;

    @Column(name = "seat_number")
    private int seatNumber;

    @Column(name = "seat_group",nullable = false)
    private char seatGroup;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",nullable = false)
    private Date createdAt = new Date();

    @OneToOne(mappedBy = "boughtTicket")
    private CheckedTicket checkedTicket;
}
