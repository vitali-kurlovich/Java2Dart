package examples.base;

import org.jspecify.annotations.NonNull;

import java.util.Set;

public final class BaseClass<T extends SecondInteface<T>, K> extends FooClass<K> implements BaseInterface, SecondInteface<Integer> {


    private final int[][] intArrayField;
    public int intField = 6;
    public double doubleField;
    InnerClass<T> innerStringField;
    private String stringField;
    public BaseClass(int intField, double doubleField, String stringField, int[][] intArrayField) {
        this.intField = intField;
        this.doubleField = doubleField;
        this.stringField = stringField;
        this.intArrayField = intArrayField;
    }

    @Override
    public void method(Integer value) {
    final var prefix = "sdf";
    }

    public void method() {

        System.out.println("Hello");
    }

    public void method(T value) {


    }

    public String retStringMethod(String stringField) {
        this.stringField = "Adb" + "Cda" + stringField;

        int[] x = new int[] { 0, 1, 42};

        return stringField;
    }

    private void method(int value, double value1) {
        final var a = value + 0xff;
        intField = value + a;
        doubleField = value1;
    }

    enum InnerEnum {
        FIRST, LAST
    }

    protected final class InnerClass<T> {
        private final T field;

        public InnerClass(T field) {
            this.field = field;
        }
    }

}

