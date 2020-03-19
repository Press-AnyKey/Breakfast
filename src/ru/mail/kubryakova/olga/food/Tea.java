package ru.mail.kubryakova.olga.food;

import java.util.Objects;

public class Tea extends Food {
    private String color;

    public Tea(String color) {
        super("Tea");
        if (color == null) {
            color = "Black";
        }
        this.color = color.toLowerCase();
    }

    public Tea() {
        this("Black");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (super.equals(o)) {
            return Objects.equals(color, ((Tea) o).color);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + " " + color;
    }

    @Override
    public void consume() {
        System.out.println(this + " выпит") ;
    }

    @Override
    public int calculateCalories() {
        return 0;
    }
}
