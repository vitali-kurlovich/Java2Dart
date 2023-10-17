public final class BaseClass {
    public BaseClass(int intField, double doubleField, String stringField, int[] intArrayField) {
        this.intField = intField;
        this.doubleField = doubleField;
        this.stringField = stringField;
        this.intArrayField = intArrayField;
    }

    public int intField;
    public double doubleField;

    private String stringField;

    private int[] intArrayField;

    private void method() {

    }

    public static String retStringMethod() {
        return "Adb" + "Cda";
    }

    private void method(int value, double value1) {

        intField = value;
        doubleField = value1;
    }

}
