package com.example.rfq;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import org.springframework.beans.factory.annotation.Autowired;

public class RfqStateMachineTest {

    @Autowired
    private RfqStateMachine rfqStateMachine;

    @BeforeEach
    public void setUp() throws Exception {
        rfqStateMachine = new RfqStateMachine();
    }

    @Test
    public void testInitialState() {
        Assertions.assertEquals(RfqState.DRAFT, rfqStateMachine.getState());
    }

    @Test
    public void testSendEvent() {
        rfqStateMachine.send();
        Assertions.assertEquals(RfqState.SENT, rfqStateMachine.getState());
    }

    @Test
    public void testAcceptEvent() {
        rfqStateMachine.send();
        rfqStateMachine.accept();
        Assertions.assertEquals(RfqState.ACCEPTED, rfqStateMachine.getState());
    }

    @Test
    public void testRejectEvent() {
        rfqStateMachine.send();
        rfqStateMachine.reject();
        Assertions.assertEquals(RfqState.REJECTED, rfqStateMachine.getState());
    }
}





