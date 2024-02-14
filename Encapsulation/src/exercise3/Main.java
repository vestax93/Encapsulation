package exercise3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Person> people = new LinkedHashMap<>(); //LinkedHashMap jer je potrebno pamtiti u kojem su se redosledu ljudi javili
        Map<String, Product> products = new HashMap<>();
        try{
            Arrays.stream(br.readLine().split(";")) //splitovanje po ; za dobijanje podataka za osobu
                    .forEach(p -> {
                                String[] tokens = p.split("="); //splitovanje po = za dobijanje imena i iznosa
                                Person person = new Person(tokens[0], Double.parseDouble(tokens[1]));
                                people.putIfAbsent(tokens[0],person);
                            }
                    );
            Arrays.stream(br.readLine().split(";"))
                    .forEach(p -> {
                                String[] tokens = p.split("=");
                                Product product = new Product(tokens[0], Double.parseDouble(tokens[1]));
                                products.putIfAbsent(tokens[0],product);
                            }
                    );

        } catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
            return;
        }
        String line;
        while(true){
            if("END".equals(line = br.readLine())){
                break;
            }
            String[] tokens = line.split("\\s+");

            String personName = tokens[0];
            String productName = tokens[1];

            Person person = people.get(personName);
            Product product = products.get(productName);

            if(person == null || product == null){
                continue;
            }

            try{
                person.buyProduct(product);
                System.out.printf("%s bought %s\n",personName,productName);
            } catch(IllegalArgumentException iae){
                System.out.println(iae.getMessage());
            }
        }
        people.values().stream().forEach(
                p -> {
                    StringBuilder sb = new StringBuilder();
                    if(p.getProducts().size() == 0){ //ako nema nista kupljeno
                        System.out.printf("%s - Nothing bought",p.getName());
                    } else {
                        sb.append(String.format("%s - %s",p.getName(),
                                p.getProducts().stream().map(Product::getName).collect(Collectors.joining(", ")))); //stampanje svih kupljenih proizvoda
                    }
                    System.out.println(sb.toString());
                }
        );
    }
}
