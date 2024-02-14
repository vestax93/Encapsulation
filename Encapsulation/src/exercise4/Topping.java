package exercise4;

public class Topping {
    private static final double BASE_CALORIES = 2;
    private static final String TYPE_MEAT = "Meat";
    private static final String TYPE_VEGGIES = "Veggies";
    private static final String TYPE_CHEESE = "Cheese";
    private static final String TYPE_SAUCE = "Sauce";
    private static final double TYPE_MEAT_VAL = 1.2;
    private static final double TYPE_VEGGIES_VAL = 0.8;
    private static final double TYPE_CHEESE_VAL = 1.1;
    private static final double TYPE_SAUCE_VAL = 0.9;

    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
       this.setToppingType(toppingType);
       this.setWeight(weight);
    }

    public String getToppingType() {
        return toppingType;
    }

    private void setToppingType(String toppingType) {
        validateToppingType(toppingType);
        this.toppingType = toppingType;
    }

    private void validateToppingType(String toppingType) {
        boolean isValid = toppingType.equals(TYPE_CHEESE) || toppingType.equals(TYPE_MEAT) || toppingType.equals(TYPE_SAUCE)
                || toppingType.equals(TYPE_VEGGIES);
        if(!isValid){
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.",toppingType));
        }
    }

    public double getWeight() {
        return weight;
    }

    private void setWeight(double weight) {
        if(weight < 1 || weight > 50){
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].",toppingType));
        }
        this.weight = weight;
    }

    public double calculateCalories(){
        double calories = BASE_CALORIES * this.weight *
                this.getModifierValue(this.toppingType);
        return calories;
    }

    private double getModifierValue(String modifier) {
        double modifierValue = 0;
        switch (modifier){
            case TYPE_MEAT:
                modifierValue = TYPE_MEAT_VAL;
                break;
            case TYPE_CHEESE:
                modifierValue = TYPE_CHEESE_VAL;
                break;
            case TYPE_SAUCE:
                modifierValue = TYPE_SAUCE_VAL;
                break;
            case TYPE_VEGGIES:
                modifierValue = TYPE_VEGGIES_VAL;
                break;
        }
        return modifierValue;
    }
}
