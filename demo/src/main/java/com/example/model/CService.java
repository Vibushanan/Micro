package com.example.model;

import org.springframework.beans.factory.annotation.Autowired;

public class CService implements coffeeService{

    @Autowired
    private H2Repo repo;
    
    @Override
    public void getALL() {

        System.out.println("Called business.......");
        
        
        repo.getById(1);

        System.out.println("Take data and write to file...........");
    }


    
}
