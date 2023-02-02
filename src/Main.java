import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        String input;
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();

        System.out.println(calc(input));
    }
    public static String calc(String input) {
        String operator, stNumber_1, stNumber_2, stResult="";
        int number_1=0, number_2=0, result=0;
        String [] strings = input.trim().split(" ");
        //trim - возможность написания строки с несколькими пробелами в начале или конце строки//
        if(strings.length != 3){
            System.out.println("throws Exception: неккоректно введёная строчка");
            System.exit(0);
        }

        stNumber_1 = strings[0];
        stNumber_2 = strings[2];
        operator = strings[1];

        try {
            number_1 = Integer.parseInt(stNumber_1);
            number_2 = Integer.parseInt(stNumber_2);
            if (number_1 < 1 || number_1 > 10 || number_2 < 1 || number_2 > 10) {
                System.out.println("throws Exception: Арабские числа не входят в дипозон [1,10]");//исключение, т.к. числа не входят в диапозон [1, 10]
                System.exit(0);
            } else {
                switch (operator) {
                    case "+" -> result = number_1 + number_2;
                    case "-" -> result = number_1 - number_2;
                    case "*" -> result = number_1 * number_2;
                    case "/" -> result = number_1 / number_2;
                    default -> {
                        System.out.println("throws Exception: арифметический знак не явл. +/-/*//"); //завершить работу программы
                        System.exit(0);
                    }
                }
            }
            System.out.println(result);
        } catch (NumberFormatException e) {
            //перевести римские числа в арабские, обработать ошибку, если строки не явл. 10 римскими числами, данные: stNumber_1 -> Number_1, stNumber_2 -> Number_2

            switch(stNumber_1){
                case "I" -> number_1=1;
                case "II" -> number_1=2;
                case "III" -> number_1=3;
                case "IV" -> number_1=4;
                case "V" -> number_1=5;
                case "VI" -> number_1=6;
                case "VII" -> number_1=7;
                case "VIII" -> number_1=8;
                case "IX" -> number_1=9;
                case "X" -> number_1=10;
                default -> {
                    System.out.println("throws Exception: это не римское число в диапозоне [1, 10]!");
                    System.exit(0);
                }
            } switch(stNumber_2){
                case "I" -> number_2=1;
                case "II" -> number_2=2;
                case "III" -> number_2=3;
                case "IV" -> number_2=4;
                case "V" -> number_2=5;
                case "VI" -> number_2=6;
                case "VII" -> number_2=7;
                case "VIII" -> number_2=8;
                case "IX" -> number_2=9;
                case "X" -> number_2=10;
                default -> {
                    System.out.println("throws Exception: это не римское число!");
                    System.exit(0);
                }
            }

            switch (operator) {
                case "+" -> result = number_1 + number_2;
                case "-" -> result = number_1 - number_2;
                case "*" -> result = number_1 * number_2;
                case "/" -> result = number_1 / number_2;
                default -> {
                    System.out.println("throws Exception: арифметический знак не явл. +/-/*//"); //завершить работу программы
                    System.exit(0);
                }
            }
            if (result < 1) {
                System.out.println("throws Exception: римские числа не могут быть <1");
                System.exit(0);
            }

            int[] num ={100, 90, 50, 40, 10, 9, 5, 4, 1};
            String[] figure = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
            stResult="";

            for(int i=0; i<num.length; i++){
                while(result>=num[i]){
                    stResult = stResult + figure[i];
                    result = result - num[i];
                }
            }
        }
        return stResult;
    }
}




