package com.mathservice.models;

import com.mathservice.entities.PersonEntity;

import java.util.List;

public class PeopleResponse {

    private String server;
    private String sistema;
    private List<PersonEntity> data;

    public PeopleResponse() {
    }

    public PeopleResponse(String server, String sistema, List<PersonEntity> data) {
        this.server = server;
        this.sistema = sistema;
        this.data = data;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    public List<PersonEntity> getData() {
        return data;
    }

    public void setData(List<PersonEntity> data) {
        this.data = data;
    }
}