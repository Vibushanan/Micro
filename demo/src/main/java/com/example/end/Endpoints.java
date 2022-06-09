package com.example.end;

import com.example.model.H2Repo;
import com.example.model.coffee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Endpoints {

    @Autowired
    private H2Repo repo;


    @GetMapping("/")
    public String hello(){

        coffee c = new coffee();
        c.setId(1);
        c.setName("Shyamal");
        repo.save(c);
        return "Hello";

    }

    @GetMapping("/all")
    public String bye(){

        coffee c = new coffee();
       coffee i=repo.getById(1);

       //


       
       System.out.println("Out from DB: "+i.toString());
        return "Hello :"+i.toString();

    }
    
}
