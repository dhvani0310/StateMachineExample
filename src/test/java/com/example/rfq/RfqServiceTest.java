package com.example.rfq;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RfqServiceTest {

    private RfqService rfqService;

    @Before
    public void setUp() {
        rfqService = new RfqService();
    }

    @Test
    public void testProcessRfqRequest() {
        RfqRequest request = new RfqRequest("12345", "Test RFQ",2,1L);
        RfqResponse response = rfqService.processRfqRequest(request, RfqEvent.SEND);
        assertEquals(RfqState.SENT, response.getState());

        response = rfqService.processRfqRequest(request, RfqEvent.ACCEPT);
        assertEquals(RfqState.ACCEPTED, response.getState());

        response = rfqService.processRfqRequest(request, RfqEvent.REJECT);
        assertEquals(RfqState.REJECTED, response.getState());

        response = rfqService.processRfqRequest(request, RfqEvent.ACCEPT);
        assertEquals(RfqState.REJECTED, response.getState()); // Invalid event for current state
    }

}

