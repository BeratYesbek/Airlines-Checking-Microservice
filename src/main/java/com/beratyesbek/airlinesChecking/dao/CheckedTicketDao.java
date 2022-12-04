package com.beratyesbek.airlinesChecking.dao;

import com.beratyesbek.airlinesChecking.models.CheckedTicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckedTicketDao extends JpaRepository<CheckedTicket, Integer> {
}
