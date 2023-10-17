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

    private int[] intArrayField;

    private void method() {

        System.out.println("Hello");
    }

    public static String retStringMethod() {
        return "Adb" + "Cda";
    }

    private void method(int value, double value1) {
        final var a = value + 100;
        intField = value + a;
        doubleField = value1;
    }

}
