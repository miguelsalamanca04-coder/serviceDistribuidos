package com.mathservice.controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mathservice.services.PersonServices;

@RestController
@RequestMapping("/people")
public class PersonController {

    @Value ("${SERVER_ID:unknown}")
    private String serverId;
    private HashMap<String, Object> response;
    private PersonServices personServices;

    public PersonController() {
        this.personServices = new PersonServices();
        response = new HashMap<>();
    }
    
    @GetMapping("/getPeople")
    public HashMap<String, Object> getPeople(@RequestParam int refId, @RequestParam int size) {    
       
        response.put("server", serverId);
        response.put("people", personServices.getPeople(refId, size));
        return response;
    }

}
