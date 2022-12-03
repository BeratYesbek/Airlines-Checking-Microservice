package com.beratyesbek.airlinesChecking.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "checked_tickets")
public class CheckedTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToOne
    @JoinColumn(name = "bought_ticket_id")
    private BoughtTicket boughtTicket;

    private Date createdAt;
}
