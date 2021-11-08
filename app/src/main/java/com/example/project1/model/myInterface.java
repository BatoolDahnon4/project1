package com.example.project1.model;

import java.util.List;

public interface myInterface {
    List<HaveToDo> getHaveToDo(String cat,String weight);
    List<Avoid> getAvoid(String cat,String weight);
    List<String> getAllCategory();

}
