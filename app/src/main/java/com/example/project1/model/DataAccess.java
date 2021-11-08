package com.example.project1.model;

import java.util.ArrayList;
import java.util.List;

public class DataAccess implements myInterface{
    ArrayList<HaveToDo> haveToDo=new ArrayList<>();
    ArrayList<Avoid> avoids = new ArrayList<>();
    ArrayList<String> category=new ArrayList<>();

    public DataAccess() {
        category.add("kids");
        category.add("adults");
        //========================================================================
        haveToDo.add(new HaveToDo("kids","UnderWeight","Base your meals on starchy carbohydrates, such as wholemeal pasta, brown rice or potatoes.\n" +
                "Have some dairy or dairy alternatives each day – have whole milk until you build your weight back up.\n" +
                "Cut down on foods that may be high in saturated fat, including processed meats, pies, cakes, pastries and biscuits. Vegetable oils, nuts, nut butters and seeds are good sources of healthier fats.\n" +
                "Cut down on food and drinks high in sugar, such as chocolate, ice cream, cakes, biscuits and sugary soft drinks.\n" +
                "Try whole-milk yoghurts and milky puddings, such as rice pudding, to help build your weight up."));
        //----------------------------------------------------------------------------
        haveToDo.add(new HaveToDo("kids","obesity","Breastfeed infants, when possible\n" +
                "Feed growing children appropriate portion sizes\n" +
                "Eat healthy foods as a family\n" +
                "Encourage eating slowly and only when hungry\n" +
                "Limit \n" +
                "Incorporate fun and exciting physical activity\n" +
                "Limit your child’s screen time\n" +
                "Make sure everyone is getting enough sleepg"));
        //---------------------------------------------------------------------------------
        haveToDo.add(new HaveToDo("adults","UnderWeight","Add more calories from healthier foods to your diet to help you gain weight\n" +
                "sprinkle grated cheese on savoury dishes\n" +
                "add cheese or milk to soups\n" +
                "spread avocado on toast for a high-energy and healthy snack\n" +
                "pour white sauce (made with butter, flour and milk) on fish or vegetables\n" +
                "replace 1 cup of tea or coffee each day with a cup of warm full-fat milk\n" +
                "put milk or butter into mashed potato"));
        //-------------------------------------------------------------------------------
        haveToDo.add(new HaveToDo("adults","obesity",""));
        //========================================================================
        avoids.add(new Avoid("kids","UnderWeight","Base your meals on starchy carbohydrates, such as wholemeal pasta, brown rice or potatoes.\n" +
                "Have some dairy or dairy alternatives each day – have whole milk until you build your weight back up.\n" +
                "Cut down on foods that may be high in saturated fat, including processed meats, pies, cakes, pastries and biscuits. Vegetable oils, nuts, nut butters and seeds are good sources of healthier fats.\n" +
                "Cut down on food and drinks high in sugar, such as chocolate, ice cream, cakes, biscuits and sugary soft drinks.\n" +
                "Try whole-milk yoghur6ts and milky puddings, such as rice pudding, to help build your weight up."));
        //----------------------------------------------------------------------------
        avoids.add(new Avoid("kids","obesity","Breastfeed infants, when possible\n" +
                "Feed growing children appropriate portion sizes\n" +
                "Eat healthy foods as a family\n" +
                "Encourage eating slowly and only when hungry\n" +
                "Limit \n" +
                "Incorporate fun and exciting physical activity\n" +
                "Limit your child’s screen time\n" +
                "Make sure everyone is getting enough sleepg"));
        //---------------------------------------------------------------------------------
        avoids.add(new Avoid("adults","'UnderWeight'","Add more calories from healthier foods to your diet to help you gain weight\n" +
                "sprinkle grated cheese on savoury dishes\n" +
                "add cheese or milk to soups\n" +
                "spread avocado on toast for a high-energy and healthy snack\n" +
                "pour white sauce (made with butter, flour and milk) on fish or vegetables\n" +
                "replace 1 cup of tea or coffee each day with a cup of warm full-fat milk\n" +
                "put milk or butter into mashed potato"));
        //-------------------------------------------------------------------------------
        avoids.add(new Avoid("adults","obesity",""));




    }


    @Override
    public List<HaveToDo> getHaveToDo(String cat, String weight) {
        ArrayList<HaveToDo> data = new ArrayList<>();
        for (HaveToDo c : haveToDo)
        {
            if (c.getCategory().equals(cat)&&c.getWeight().equals(weight))
            {
                data.add(c);
            }
        }
        return data;
    }

    @Override
    public List<Avoid> getAvoid(String cat, String weight) {
        ArrayList<Avoid> data = new ArrayList<>();
        for (Avoid c : avoids)
        {
            if (c.getCategory().equals(cat)&&c.getWeight().equals(weight))
            {
                data.add(c);
            }
        }
        return data;
    }

    @Override
    public List<String> getAllCategory() {

        return category;
    }


}
