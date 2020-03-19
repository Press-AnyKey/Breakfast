package ru.mail.kubryakova.olga;

import ru.mail.kubryakova.olga.food.Dessert;
import ru.mail.kubryakova.olga.food.Food;
import ru.mail.kubryakova.olga.food.Pie;
import ru.mail.kubryakova.olga.food.Tea;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Comparator;

public class Breakfast {
    private static final short CAPASITY = 20;
    private Food[] foodList = new Food[CAPASITY];
    private short count = 0;

    public boolean addFood(Food food) {
        if (food != null && count < CAPASITY) {
            foodList[count] = food;
            count++;
            return true;
        }
        return false;
    }

    public boolean addFood(String name) {
        try {
            Class myClass = Class.forName("ru.mail.kubryakova.olga.food." + name);
            Constructor constructor = myClass.getConstructor();
            Food food = (Food) constructor.newInstance();
            return addFood(food);
        } catch (ClassNotFoundException e) {
            System.out.println("Вы ввели еду, которой нет в программе. " + name);
            e.printStackTrace();
            return false;
        } catch (NoSuchMethodException e) {
            System.out.println("Нет конструктора без параметров. " + name);
            e.printStackTrace();
            return false;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return false;
        } catch (InstantiationException e) {
            e.printStackTrace();
            return false;
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean addFood(String name, String param1) {
        try {
            Class myClass = Class.forName("ru.mail.kubryakova.olga.food." + name);
            Constructor constructor = myClass.getConstructor(String.class);
            Food food = (Food) constructor.newInstance(param1);
             return addFood(food);
        } catch (ClassNotFoundException e) {
            System.out.println("Вы ввели еду, которой нет в программе. " + name);
            e.printStackTrace();
            return false;
        } catch (NoSuchMethodException e) {
            System.out.println("Нет конструктора с 1 параметром. " + name);
            e.printStackTrace();
            return false;
        } catch (InstantiationException e) {
            e.printStackTrace();
            return false;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return false;
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean addFood(String name, String param1, String param2) {
        try {
            Class myClass = Class.forName("ru.mail.kubryakova.olga.food." + name);
            Constructor constructor = myClass.getConstructor(String.class, String.class);
            Food food = (Food) constructor.newInstance(param1, param2);
            return addFood(food);
        } catch (ClassNotFoundException e) {
            System.out.println("Вы ввели еду, которой нет в программе. " + name);
            e.printStackTrace();
            return false;
        } catch (NoSuchMethodException e) {
            System.out.println("Нет конструктора с 2 параметрами. " + name);
            e.printStackTrace();
            return false;
        } catch (InstantiationException e) {
            e.printStackTrace();
            return false;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return false;
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public String toString() {
        String buff = "Your breackfast: \n{\n";
        for (int i = 0; i < count; i++) {
            buff += foodList[i];
            buff += "\n";
        }
        buff += "}\n";
        return buff;
    }

    public Food getFood(int index) {
        if (index >= 0 && index < count) {
            return foodList[index];
        }
        return null;
    }

    public int countEqualFood(Food food) {
        if (food == null) {
            return 0;
        }
        int countEq = 0;
        for (int i = 0; i < count; i++) {
            if (food.equals(foodList[i])) {
                countEq++;
            }
        }
        return countEq;
    }

    public int getCount() {
        return count;
    }

    public void setFoodList(Food[] foodList) {
        this.foodList = foodList;
    }

    public void sort() {
        Arrays.sort(foodList, new Comparator<Food>() {
            public int compare(Food f1, Food f2) {
                if (f1 == null) return 1;
                if (f2 == null) return -1;
                int rezult = ((Food) f1).getName().compareTo(((Food) f2).getName());
                if (rezult != 0) {
                    return rezult;
                }
                if (f1 instanceof Pie) {
                    Pie ic1 = (Pie) f1;
                    Pie ic2 = (Pie) f2;
                    return (ic1.getFilling().length() - ic2.getFilling().length()) * -1;
                }
                if (f1 instanceof Tea) {
                    Tea t1 = (Tea) f1;
                    Tea t2 = (Tea) f2;
                    return (t1.getColor().length() - t2.getColor().length());
                }
                if (f1 instanceof Dessert) {
                    Dessert sand1 = (Dessert) f1;
                    Dessert sand2 = (Dessert) f2;
                    if (sand1.getComponent1().length() - sand2.getComponent1().length() != 0) {
                        return (sand1.getComponent1().length() - sand2.getComponent1().length());
                    } else {
                        return (sand1.getComponent2().length() - sand2.getComponent2().length());
                    }
                }
                return 0;
            }
        });
    }


}
