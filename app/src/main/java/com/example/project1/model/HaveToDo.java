package com.example.project1.model;

public class HaveToDo {
    private String category;
    private String weight;
    private String info;

    public HaveToDo(String category, String weight, String info) {
        this.category = category;
        this.weight = weight;
        this.info = info;
    }

    public String getCategory() {
        return category;
    }

    public String getWeight() {
        return weight;
    }

    public String getInfo() {
        return info;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
