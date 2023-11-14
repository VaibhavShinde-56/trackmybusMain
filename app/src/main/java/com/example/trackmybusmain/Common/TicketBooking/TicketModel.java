package com.example.trackmybusmain.Common.TicketBooking;

public class TicketModel {
    // all the variables needed in the card view we want to set in run time
    String fromLocName,toLocName,fromLocTime,toLocTime,fromLocDate,toLocDate,passengers,busNo,ticketId;
    public TicketModel(String fromLocName,String toLocName,String fromLocTime,String toLocTime,String fromLocDate,String toLocDate,String passengers,String busNo,String ticketId){
        this.fromLocName = fromLocName;
        this.toLocName = toLocName;
        this.fromLocTime = fromLocTime;
        this.toLocTime = toLocTime;
        this.fromLocDate = fromLocDate;
        this.toLocDate = toLocDate;
        this.passengers = passengers;
        this.busNo = busNo;
        this.ticketId = ticketId;

    }
}
