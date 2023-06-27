package calculator;

public class Calculator {
    public int add(int n1, int n2) {
        return n1 + n2;
    }

    public int substract(int n1, int n2) {
        return n1 - n2;
    }

    public int multiply(int n1, int n2) {
        return n1 * n2;
    }

    public int divide(int n1, int n2) {
        if (n2 == 0) throw new IllegalArgumentException("분모가 0이 될 수 없습니다.");
        return n1 / n2;
    }

}