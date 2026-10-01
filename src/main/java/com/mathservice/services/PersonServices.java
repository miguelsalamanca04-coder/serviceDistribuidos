package com.mathservice.services;

import org.springframework.stereotype.Service;

import com.mathservice.models.Person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServices {

    // /mnt/personas/people.csv
    private final String csvPath = "/mnt/personas/people.csv";


    public List<Person> getPeople(int refId, int size) {

        List<Person> persons = new ArrayList<>();


        try (BufferedReader reader = new BufferedReader(new FileReader(csvPath))) {

            String line;
            int j = refId+1;

            for (int i = 0; i < refId; i++) {
                reader.readLine();
            }


            while ((line = reader.readLine()) != null && j < refId+1+size) {

                String[] data = line.split(",");
                persons.add(new Person(data[0], data[1], data[2], Integer.parseInt(data[3])));
                j++;
            }
            

        } catch (IOException e) {
            throw new RuntimeException("Error leyendo el archivo CSV", e);
        }

        return persons;
    }
}
