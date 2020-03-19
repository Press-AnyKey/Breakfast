package ru.mail.kubryakova.olga.food;

import java.util.Objects;

public abstract class Food implements Consumable, Nutritious {

    private String name;
    public Food (String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return  name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Food food = (Food) o;

        return Objects.equals(name, food.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
