package com.beratyesbek.airlinesChecking.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "checked_tickets")
@AllArgsConstructor
@NoArgsConstructor
public class CheckedTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToOne
    @JoinColumn(name = "bought_ticket_id")
    private BoughtTicket boughtTicket;

    private Date createdAt;
}
