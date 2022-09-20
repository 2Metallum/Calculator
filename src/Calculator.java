import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        String answer = calc(expression);
        System.out.println(answer);

    }
    public static String calc(String input) throws Exception {
        String[] strings = input.split(" ");
        if(arabicRomanCheck(strings) && strings.length == 3  && rangeCheck(strings)){
            return mathOperations(strings);
        }else{
            throw new IllegalArgumentException();
        }
    }

    public static boolean arabicRomanCheck(String[] numbers){
        return Converter.isRoman(numbers[0]) == Converter.isRoman(numbers[2]);
    }

    public static boolean rangeCheck(String[] numbers){
            if(Converter.isRoman(numbers[0])){
                int a = Converter.romanToInteger(numbers[0]);
                int b = Converter.romanToInteger(numbers[2]);
                if( a >= 1 && b >= 1 && a <= 10 && b <= 10){
                    return true;
                }else{
                    throw new IllegalArgumentException();
                }
            }else{
                int a = Integer.parseInt(numbers[0]);
                int b = Integer.parseInt(numbers[2]);
                if( a >= 1 && b >= 1 && a <= 10 && b <= 10){
                    return true;
                }else{
                    throw new IllegalArgumentException();
                }
            }
    }
    public static String mathOperations(String[] numbers) throws Exception{
        if(!(Converter.isRoman(numbers[0]))){
            int a = Integer.parseInt(numbers[0]);
            int b = Integer.parseInt(numbers[2]);
            switch(numbers[1]){
                case "+":
                    return Integer.toString(a+b);
                case "-":
                    return Integer.toString(a - b);
                case "*":
                    return Integer.toString(a * b);
                case "/":
                    return Integer.toString(a / b);
            }
        }else{
            int a = Converter.romanToInteger(numbers[0]);
            int b = Converter.romanToInteger(numbers[2]);
            int sum = 0;
            switch(numbers[1]){
                case "+":
                    sum = a + b;
                break;
                case "-":
                    sum = a - b;
                break;
                case "*":
                    sum = a * b;
                break;
                case "/":
                    sum = a / b;
                break;
            }
            return Converter.intToRoman(sum);
        }
        throw new IllegalArgumentException();
    }
}