/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gr4.ticketmanagement.entities;

import java.sql.Date;


/**
 *
 * @author hailo
 */
public class Movie {
    int id,duration;
    String name,director, type, description;
    Date releaseDate, endDate;

    public Movie(int id, String name , String director, int duration,   String type, String description, Date releaseDate, Date enDate) {
        this.id = id;
        this.duration = duration;
        this.name = name;
        this.director = director;
        this.type = type;
        this.description = description;
        this.releaseDate = releaseDate;
        this.endDate = enDate;
    }

    public int getId() {
        return id;
    }

    public int getDuration() {
        return duration;
    }

    public String getName() {
        return name;
    }

    public String getDirector() {
        return director;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setEndDate(Date enDate) {
        this.endDate = enDate;
    }

    @Override
    public String toString() {
        return "Movie{" + "id=" + id + ", duration=" + duration + ", name=" + name + ", director=" + director + ", type=" + type + ", description=" + description + ", releaseDate=" + releaseDate + ", endDate=" + endDate + '}';
    }
    
}
