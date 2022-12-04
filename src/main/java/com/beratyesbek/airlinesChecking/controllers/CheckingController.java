package com.beratyesbek.airlinesChecking.controllers;

import com.beratyesbek.airlinesChecking.dao.BoughtTicketDao;
import com.beratyesbek.airlinesChecking.dao.CheckedTicketDao;
import com.beratyesbek.airlinesChecking.models.BoughtTicket;
import com.beratyesbek.airlinesChecking.models.CheckedTicket;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("checking")
public class CheckingController {

    private final BoughtTicketDao boughtTicketDao;
    private final CheckedTicketDao checkedTicketDao;

    public CheckingController(BoughtTicketDao boughtTicketDao, CheckedTicketDao checkedTicketDao) {
        this.boughtTicketDao = boughtTicketDao;
        this.checkedTicketDao = checkedTicketDao;
    }

    @GetMapping("{checkingCode}")
    public ResponseEntity checkingTicket(@PathVariable String checkingCode) {
        BoughtTicket boughtTicket = boughtTicketDao.findByCheckingCode(checkingCode);
        if (boughtTicket != null) {
            if (boughtTicket.getCheckedTicket() == null) {
                checkedTicketDao.save(new CheckedTicket(0, boughtTicket, new Date()));
                return ResponseEntity.ok(boughtTicket);
            } else {
                return new ResponseEntity<>("Checking process has already been completed", HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>("Ticket cannot found", HttpStatus.BAD_REQUEST);
    }
}
