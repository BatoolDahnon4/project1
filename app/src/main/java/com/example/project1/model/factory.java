package com.example.project1.model;

public class factory {
    public myInterface getModel(){return new DataAccess();}
}
