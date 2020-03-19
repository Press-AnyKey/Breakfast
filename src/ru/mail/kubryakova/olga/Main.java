package ru.mail.kubryakova.olga;

import ru.mail.kubryakova.olga.food.Food;

public class Main {
    public static void main(String[] args) {
        Breakfast breackfast = new Breakfast();
        boolean ccal = false;
        boolean sort = false;
        for (int i = 0; i < args.length; i++) {
            if ("-calories".equals(args[i])) {
                ccal = true;
                continue;
            }
            if ("-sort".equals(args[i])) {
                sort = true;
                continue;
            }
            String[] foodWithParam = args[i].split("/");
            if (foodWithParam.length == 1) {
                breackfast.addFood(foodWithParam[0]);
            }
            if (foodWithParam.length == 2) {
                breackfast.addFood(foodWithParam[0], foodWithParam[1]);
            }
            if (foodWithParam.length == 3) {
                breackfast.addFood(foodWithParam[0], foodWithParam[1], foodWithParam[2]);
            }
        }

        Food check = breackfast.getFood(0);

        System.out.println("Кол-во " + check + ": " + breackfast.countEqualFood(check));

        if (ccal) {
            int ccalBreackfast = 0;
            for (int i = 0; i < breackfast.getCount(); i++) {
                int ccalFood = breackfast.getFood(i).calculateCalories();
                System.out.println(breackfast.getFood(i).toString()
                        + " калорийность: " + ccalFood);
                ccalBreackfast += ccalFood;
            }
            System.out.println("Калорийность завтрака: " + ccalBreackfast);
        }

        if (sort) {
            breackfast.sort();
            System.out.println(breackfast.toString());
        }
    }
}
