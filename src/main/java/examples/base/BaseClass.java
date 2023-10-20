package examples.base;

import org.jspecify.annotations.NonNull;

import java.util.Set;

public final class BaseClass<T extends SecondInteface<T>, K> extends FooClass<K> implements BaseInterface, SecondInteface<Integer> {


      enum InnerEnum {
        FIRST, LAST;
      }

    @Override
    public void method(Integer value) {

    }

    protected class InnerClass<T> {
        private final T field;

        public InnerClass(T field) {
            this.field = field;
        }
    }

    private final int[][] intArrayField;
    public int intField = 6;
    public double doubleField;

    private String stringField;

    InnerClass<T> innerStringField;


    public BaseClass(int intField, double doubleField, String stringField, int[][] intArrayField) {
        this.intField = intField;
        this.doubleField = doubleField;
        this.stringField = stringField;
        this.intArrayField = intArrayField;
    }

    public void method() {

        System.out.println("Hello");
    }

    public void method(T value) {


    }

    public String retStringMethod() {
        stringField = "Adb" + "Cda";
        return stringField;
    }

    private void method(int value, double value1) {
        final var a = value + 0xff;
        intField = value + a;
        doubleField = value1;
    }

}
