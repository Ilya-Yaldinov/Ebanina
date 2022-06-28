import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        long start = System.currentTimeMillis();
        int output = minMultipliers(input);
        System.out.println(output);
        long finish = System.currentTimeMillis();
        long elapsed = finish - start;
        System.out.println("Прошло времени, мс: " + elapsed);
    }

    public static int minMultipliers(int input){
        BigInteger bigInteger = BigInteger.valueOf(input);
        boolean prime = bigInteger.isProbablePrime((int) Math.log(input));
        if(prime) return -1;
        if(input > 0 && input < 10) return input;
        else return divisionByMultipliers(input);
    }

    public static int divisionByMultipliers(int input){
        List<Integer> multipliers = new ArrayList<>();
        do {
            for (int i = 2; i < 10; i++){
                int multiplier = 1;
                int count = 0;
                while (input % i == 0){
                    count++;
                    if(multiplier < 10){
                        multiplier *= i;
                        input /= i;
                    }
                }
                if(count > 0){
                    if(multiplier > 10){
                        multipliers.add(multiplier/i);
                        multipliers.add(i);
                    }else {
                        multipliers.add(multiplier);
                    }
                }
            }
        }while (input != 1);
        int output = multipliersSort(multipliers);
        return output;
    }

    public static int multipliersSort(List<Integer> multipliers){
        String number = "";
        for (int i = 2; i < 10; i++){
            for (int j = 0; j < multipliers.size(); j++){
                if(multipliers.get(j).equals(i)) number += i;
            }
        }
        return Integer.parseInt(number);
    }
}
