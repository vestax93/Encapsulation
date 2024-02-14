package exercise4;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, int numberOfToppings ) {
        this.setName(name);
        this.setToppings(numberOfToppings);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.trim().isEmpty() || name.length() > 15){
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    public Dough getDough() {
        return dough;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(int numberOfToppics) {
        if(numberOfToppics >= 10){
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.toppings = new ArrayList<>();
    }

    public void addTopping(Topping topping){
        /*if(toppings.size() >= 10){
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }*/
        toppings.add(topping);
    }

    public double getOverallCalories(){
        double overallCalories = dough.calculateCalories() + this.toppings.stream().mapToDouble(Topping::calculateCalories).sum();
        return overallCalories;
    }
}
