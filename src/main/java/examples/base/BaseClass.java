package examples.base;

import org.jspecify.annotations.NonNull;

public final class BaseClass {
    public BaseClass(int intField, double doubleField, String stringField, int[] intArrayField) {
        this.intField = intField;
        this.doubleField = doubleField;
        this.stringField = stringField;
        this.intArrayField = intArrayField;
    }

    public int intField = 6;
    public double doubleField;

    private String stringField;

    private final int[] intArrayField;

    private void method() {

        System.out.println("Hello");
    }

    public  String retStringMethod() {
        stringField = "Adb" + "Cda";
        return stringField;
    }

    private void method(int value, double value1) {
        final var a = value +  0xff;
        intField = value + a;
        doubleField = value1;
    }

}
