package ru.mail.kubryakova.olga.food;

import java.util.Objects;

public class Pie extends Food {
    private String filling;

    public Pie(String filling) {
        super("Pie");
        if (filling == null) {
            filling = "apple";
        }
        this.filling = filling.toLowerCase();
    }

    public Pie() {
        this("apple");
    }

    public String getFilling() {
        return filling;
    }

    public void setFilling(String filling) {
        this.filling = filling;
    }

    @Override
    public boolean equals(Object o) {
        if (super.equals(o)) {
            return Objects.equals(filling, ((Pie) o).filling);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (filling != null ? filling.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + " " + filling;
    }

    @Override
    public void consume() {
        System.out.println(this + " скушан");
    }

    @Override
    public int calculateCalories() {
        switch (filling) {
            case "apple": {
                return 211;
            }
            case "cherry": {
                return 305;
            }
            case "strawberry": {
                return 240;
            }
            default: {
                System.out.println("I dont now zis feeling " + filling);
                return 0;
            }
        }
    }
}
