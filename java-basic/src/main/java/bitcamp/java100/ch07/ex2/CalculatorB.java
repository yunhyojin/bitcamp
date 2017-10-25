package bitcamp.java100.ch07.ex2;

public class CalculatorB extends Calculator {
    int result;

    void remainder(int value) {
        this.result %= value;
    }
}
