import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws CustomException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение:");
        String input = sc.nextLine();

        System.out.println(calc(input));
    }

    public static String calc(String input) throws CustomException {

        CheckData cd = new CheckData(input.split(" "));

        return Calculator.calculation(CheckData.getX(), CheckData.getY(), CheckData.getOperator(), CheckData.IsRomanNumber());

    }
}
