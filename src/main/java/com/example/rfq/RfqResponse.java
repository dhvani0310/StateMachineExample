package com.example.rfq;

public class RfqResponse {

    private String id;
    private RfqState state;

    public RfqResponse() {}

    public RfqResponse(String id, RfqState state) {
        this.id = id;
        this.state = state;
    }

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RfqState getState() {
        return state;
    }

    public void setState(RfqState state) {
        this.state = state;
    }

}

