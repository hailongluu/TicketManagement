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
public class Schedule {
    private int id;
    private Movie movie;
    private Room room;
    private ShowTime showTime;

    public Schedule(int id, Movie movie, Room room, ShowTime showTime) {
        this.id = id;
        this.movie = movie;
        this.room = room;
        this.showTime = showTime;
    }

    public ShowTime getShowTime() {
        return showTime;
    }

    public void setShowTime(ShowTime showTime) {
        this.showTime = showTime;
    }

    public int getId() {
        return id;
    }

    public Movie getMovie() {
        return movie;
    }

    public Room getRoom() {
        return room;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
    
}
