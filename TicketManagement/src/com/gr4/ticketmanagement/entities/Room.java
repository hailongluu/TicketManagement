/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gr4.ticketmanagement.entities;

import java.util.ArrayList;

/**
 *
 * @author hailo
 */
public class Room {
    private int id,number ;
    private ArrayList<Seat> listSeat;

    public Room(int id, int number, ArrayList<Seat> listSeat) {
        this.id = id;
        this.number = number;
        this.listSeat = listSeat;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setListSeat(ArrayList<Seat> listSeat) {
        this.listSeat = listSeat;
    }

    public int getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public ArrayList<Seat> getListSeat() {
        return listSeat;
    }
    
}
