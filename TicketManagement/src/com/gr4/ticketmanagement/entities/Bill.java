/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gr4.ticketmanagement.entities;

import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author hailo
 */
public class Bill {
    private int id;
    private String billType;
    private Client buyer;
    private ArrayList<Ticket> listTickets;
    private Time buyTime;
    private float totalPrice;
    private Employee employee;

    public Bill(int id, String billType, Client buyer, ArrayList<Ticket> listTickets, Time buyTime, Employee employee) {
        this.id = id;
        this.billType = billType;
        this.buyer = buyer;
        this.listTickets = listTickets;
        this.buyTime = buyTime;
        this.totalPrice =0;
        for(Ticket t: listTickets){
            this.totalPrice+=t.getPrice();
        }     
        this.employee = employee;
    }
    

    public int getId() {
        return id;
    }

    public String getBillType() {
        return billType;
    }

    public Client getBuyer() {
        return buyer;
    }

    public ArrayList<Ticket> getListTickets() {
        return listTickets;
    }

    public Time getBuyTime() {
        return buyTime;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public void setBuyer(Client buyer) {
        this.buyer = buyer;
    }

    public void setListTickets(ArrayList<Ticket> listTickets) {
        this.listTickets = listTickets;
    }

    public void setBuyTime(Time buyTime) {
        this.buyTime = buyTime;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
}
