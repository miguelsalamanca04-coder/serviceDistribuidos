package com.mathservice.controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mathservice.entities.PersonEntity;
import com.mathservice.models.PeopleResponse;
import com.mathservice.services.PersonServices;

@RestController
@RequestMapping("/people")
public class PersonController {

    @Value ("${SERVER_ID:unknown}")
    private String serverId;
    private HashMap<String, Object> response;
    private PersonServices personServices;

    public PersonController(PersonServices personServices) {
        this.personServices =  personServices;
        response = new HashMap<>();
    }
    
    @GetMapping("/getPeopleNFS")
    public HashMap<String, Object> getPeople(@RequestParam int refId, @RequestParam int size) {    
       
        response.put("server", serverId);
        response.put("people", personServices.getPeopleNFS(refId, size));
        return response;
    }

    
    @GetMapping("/getPeopleDB")
    public PeopleResponse getAllPeople(@RequestParam int refId, @RequestParam  int size){
        return new PeopleResponse(serverId,"Dato Quemado",personServices.getPeople(refId, size));
    }

    @GetMapping("/getById")
    public PersonEntity getBYId(@RequestParam Long id){
        return personServices.getPersonById(id);
    }

    @PutMapping("/put/{id}")
    public PersonEntity updatePerson(@PathVariable Long id, @RequestBody PersonEntity person) {

        return personServices.updatePerson(id, person);
    }

}
