/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gr4.ticketmanagement.entities;

import java.util.logging.Logger;

/**
 *
 * @author hailo
 */
public class Seat {
    private int id;
    private String position;
    private String type;

    public Seat(int id, String position, String type) {
        this.id = id;
        this.position = position;
        this.type = type;
    } 

    public String getPosition() {
        return position;
    }

    public String getType() {
        return type;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setType(String type) {
        this.type = type;
    }
    
}
