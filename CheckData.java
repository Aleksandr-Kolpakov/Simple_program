import java.util.Objects;

class CheckData {
    private static String a, b, operator;
    private static int x, y;
    private static boolean isRomanNumber = false;

    CheckData(String[] arr) throws CustomException {
        if (arr.length == 3) {
            a = arr[0];
            b = arr[2];
            operator = arr[1];

            convertStringToInt();
        } else if (arr.length < 3) {
            throw new CustomException("Введенная строка не является математической операцией");
        }

        if (!checkOperator() || arr.length > 3) throw new CustomException("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
    }

    private static void convertStringToInt() throws CustomException {
        checkNumberSystem(a, b);

        try {
            x = Integer.parseInt(a);
            y = Integer.parseInt(b);

        } catch (NumberFormatException e) {
            if (RomanNumbers.checkInRomanNumbers(a) && RomanNumbers.checkInRomanNumbers(b)) {
                isRomanNumber = true;
                x = RomanNumbers.changeRomanToArabian(a);
                y = RomanNumbers.changeRomanToArabian(b);
            } else {
                throw new CustomException("Один или оба операнда не отвечают условию задачи: не являются целыми числами");
            }
        }
        checkOperandsRange(x, y);
    }

    private static void checkNumberSystem(String a, String b) throws CustomException {
        if (checkOperandIsNumber(a) && RomanNumbers.checkInRomanNumbers(b) || RomanNumbers.checkInRomanNumbers(a) && checkOperandIsNumber(b)) throw new CustomException("Не допускается использовать разные системы счисления");
    }

    private static boolean checkOperandIsNumber(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static void checkOperandsRange(int x, int y) throws CustomException {
        if (x < 1 || x > 10 || y < 1 || y > 10) throw new CustomException("Введенные числа не должны быть меньше 1 и больше 10");
    }

    private boolean checkOperator() {
        String[] operators = {"+", "-", "*", "/"};

        for (String element : operators) {
            if (Objects.equals(operator, element)) return true;
        }
        return false;
    }

    public static int getX() { return x; }

    public static int getY() { return y; }

    public static String getOperator() { return operator; }

    public static boolean IsRomanNumber() { return isRomanNumber; }
}
