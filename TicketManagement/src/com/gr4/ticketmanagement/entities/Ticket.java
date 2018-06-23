/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gr4.ticketmanagement.entities;

/**
 *
 * @author hailo
 */
public class Ticket {
    private int id;
    private Seat seat;
    private Schedule schedule;
    private float price;

    public Ticket(int id, Seat seat, Schedule schedule, float price) {
        this.id = id;
        this.seat = seat;
        this.schedule = schedule;
        this.price = price;
    }

    public Ticket() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public Seat getSeat() {
        return seat;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public float getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
}
