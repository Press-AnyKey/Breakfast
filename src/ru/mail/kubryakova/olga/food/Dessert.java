package ru.mail.kubryakova.olga.food;

import java.util.Objects;

public class Dessert extends Food {
    private String component1;
    private String component2;
    //карамель, шоколад, сливки

    public Dessert(String component1, String component2) {
        super("Dessert");
        if (component1 == null) {
            component1 = "карамель";
        }
        if (component2 == null) {
            component2 = "сливки";
        }
        this.component1 = component1.toLowerCase();
        this.component2 = component2.toLowerCase();
    }

    public Dessert() {
        this("карамель", "сливки");
    }

    public Dessert(String component) {
        this(component, "сливки");
    }

    public String getComponent1() {
        return component1;
    }

    public void setComponent1(String component1) {
        this.component1 = component1;
    }

    public String getComponent2() {
        return component2;
    }

    public void setComponent2(String component2) {
        this.component2 = component2;
    }

    @Override
    public boolean equals(Object o) {
        if (super.equals(o)) {
            return Objects.equals(component1, ((Dessert) o).component1)
                    && Objects.equals(component2, ((Dessert) o).component2);
        }
        return false;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (component1 != null ? component1.hashCode() : 0);
        result = 31 * result + (component2 != null ? component2.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + " из " + component1 + " и " + component2;
    }

    @Override
    public void consume() {
        System.out.println(this + " скушан");
    }

    @Override
    public int calculateCalories() {
        int sum = 0;
        switch (component1) {
            case "сливки": {
                sum = 120;
                break;
            }
            case "шоколад": {
                sum = 107;
                break;
            }
            case "карамель": {
                sum = 130;
                break;
            }
            default: {
                System.out.println("I don't know this component " + component1);
            }
        }
        switch (component2) {
            case "сливки": {
                return sum + 120;
            }
            case "шоколад": {
                return sum + 107;
            }
            case "карамель": {
                return sum + 130;
            }
            default: {
                System.out.println("I don't know this component " + component2);
                return 0;
            }
        }

    }
}
