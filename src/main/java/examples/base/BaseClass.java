package examples.base;

import org.jspecify.annotations.NonNull;



public final class BaseClass<T extends BaseInterface> implements BaseInterface {

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

   @NonNull BaseClass<T> baseField;

    public BaseClass(int intField, double doubleField, String stringField, int[][] intArrayField) {
        this.intField = intField;
        this.doubleField = doubleField;
        this.stringField = stringField;
        this.intArrayField = intArrayField;
    }

    public void method() {

        System.out.println("Hello");
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
