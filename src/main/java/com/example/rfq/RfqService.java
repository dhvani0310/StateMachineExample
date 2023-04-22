package com.example.rfq;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RfqService {

    private Map<String, RfqState> rfqStateMap = new HashMap<>();

    public RfqResponse processRfqRequest(RfqRequest request, RfqEvent event) {
        String id = request.getId();
        RfqState currentState = rfqStateMap.getOrDefault(id, RfqState.DRAFT);
        RfqState newState = getNextState(currentState, event);
        rfqStateMap.put(id, newState);
        return new RfqResponse(id, newState);
    }

    private RfqState getNextState(RfqState currentState, RfqEvent event) {
        switch (currentState) {
            case DRAFT:
                if (event == RfqEvent.SEND) {
                    return RfqState.SENT;
                }
                break;
            case SENT:
                if (event == RfqEvent.ACCEPT) {
                    return RfqState.ACCEPTED;
                } else if (event == RfqEvent.REJECT) {
                    return RfqState.REJECTED;
                }
                break;
            case ACCEPTED:
            case REJECTED:
                // Terminal states, no more state transitions are allowed
                break;
            default:
                throw new IllegalArgumentException("Invalid state: " + currentState);
        }
        throw new IllegalArgumentException("Invalid event: " + event + " for state: " + currentState);
    }

}

