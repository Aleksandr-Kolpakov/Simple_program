class Calculator {
    private static String result;

    public static String calculation(int x, int y, String operator, boolean isRoman) throws CustomException {
        int preResult = switch (operator) {
            case "+" -> x + y;
            case "-" -> x - y;
            case "*" -> x * y;
            case "/" -> x / y;
            default -> 0;
        };

        if (isRoman) {
            if (preResult < 1) {
                throw new CustomException("В римской системе счисления нет нуля и отрицательных чисел");
            } else {
                result = RomanNumbers.changeArabianToRoman(preResult);
            }
        } else {
            result = Integer.toString(preResult);
        }

        return result;
    }
}
