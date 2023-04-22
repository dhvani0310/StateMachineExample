package com.example.rfq;

import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineBuilder;
import org.springframework.stereotype.Component;

@Component
public class RfqStateMachine {

    private StateMachine<RfqState, RfqEvent> stateMachine;

    public RfqStateMachine() throws Exception {
        stateMachine = buildStateMachine();
        stateMachine.start();
    }

    private StateMachine<RfqState, RfqEvent> buildStateMachine() throws Exception {
        StateMachineBuilder.Builder<RfqState, RfqEvent> builder = StateMachineBuilder.builder();

        builder.configureStates()
                .withStates()
                .initial(RfqState.DRAFT)
                .state(RfqState.SENT)
                .end(RfqState.ACCEPTED)
                .end(RfqState.REJECTED);

        builder.configureTransitions()
                .withExternal()
                .source(RfqState.DRAFT)
                .target(RfqState.SENT)
                .event(RfqEvent.SEND)
                .and()
                .withExternal()
                .source(RfqState.SENT)
                .target(RfqState.ACCEPTED)
                .event(RfqEvent.ACCEPT)
                .and()
                .withExternal()
                .source(RfqState.SENT)
                .target(RfqState.REJECTED)
                .event(RfqEvent.REJECT);

        return builder.build();
    }

    public void send() {
        stateMachine.sendEvent(RfqEvent.SEND);
    }

    public void accept() {
        stateMachine.sendEvent(RfqEvent.ACCEPT);
    }

    public void reject() {
        stateMachine.sendEvent(RfqEvent.REJECT);
    }

    public RfqState getState() {
        return stateMachine.getState().getId();
    }

}

