package exercise4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] pizzaTokens = br.readLine().split("\\s+");
        String[] doughTokens = br.readLine().split("\\s+");

        try{
            Pizza pizza = new Pizza(pizzaTokens[1],Integer.parseInt(pizzaTokens[2]));
            Dough dough = new Dough(doughTokens[1],doughTokens[2], Double.parseDouble(doughTokens[3]));
            pizza.setDough(dough);

            String line = br.readLine();
            while(!line.equals("END")){
                String[] toppingTokens = line.split("\\s+");
                Topping topping = new Topping(toppingTokens[1],Double.parseDouble(toppingTokens[2]));
                pizza.addTopping(topping);
                line = br.readLine();
            }
            System.out.printf("%s - %.2f", pizza.getName(),pizza.getOverallCalories());
        } catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }


    }
}
