package com.example.rfq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rfq")
public class RfqController {


    private final RfqService rfqService;

    @Autowired
    public RfqController(RfqService rfqService) {
        this.rfqService = rfqService;
    }

    @PostMapping
    public ResponseEntity<RfqResponse> processRfqRequest(@RequestBody RfqRequest request, @RequestParam RfqEvent event) {
        RfqResponse response = rfqService.processRfqRequest(request, event);
        return ResponseEntity.ok(response);
    }

}

