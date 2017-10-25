package bitcamp.java100.ch07.ex1;

public class CalculatorB {
    int result;

    void multiple(int value) {
        this.result *= value;
    }

    void divide(int value) {
        if (value == 0) {
            System.err.println("0으로 나누면 안됩니다!");
            return;
        }
        this.result /= value;
    }

    void remainder(int value) {
        this.result %= value;
    }
}
