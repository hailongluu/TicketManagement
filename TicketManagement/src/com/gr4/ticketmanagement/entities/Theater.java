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
public class Theater {
    int id;
    String name,add;
    ArrayList<Room> listRoom;

    public Theater(int id, String name, String add, ArrayList<Room> listRoom) {
        this.id = id;
        this.name = name;
        this.add = add;
        this.listRoom = listRoom;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAdd() {
        return add;
    }

    public ArrayList<Room> getListRoom() {
        return listRoom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public void setListRoom(ArrayList<Room> listRoom) {
        this.listRoom = listRoom;
    }
    
}
