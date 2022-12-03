package com.beratyesbek.airlinesChecking.dao;

import com.beratyesbek.airlinesChecking.models.BoughtTicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoughtTicketDao extends JpaRepository<BoughtTicket, Integer> {
}
