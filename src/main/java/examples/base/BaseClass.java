package examples.base;

import org.jspecify.annotations.NonNull;

import java.util.List;
import java.util.Set;


public final class BaseClass<T extends SecondInteface<T>, K> extends FooClass<K> implements BaseInterface, SecondInteface<Integer> {


    private final int[][] intArrayField;
    public int intField = 6;
    private BaseEnum enumField = BaseEnum.LAST;
    double doubleField = 0.0;
    InnerClass<T> innerStringField;
    private String stringField;

    public BaseClass(int intField, double doubleField, String stringField, int[][] intArrayField) {
        this.intField = intField;
        this.doubleField = doubleField;
        this.stringField = stringField;
        this.intArrayField = intArrayField;
    }

    void throwFunc(boolean flag) throws IllegalStateException {
        if (!flag) {
            throw  new IllegalStateException("Throw exception");
        }
    }


    void tryCatch() {
        try {
            throwFunc(true);
        } catch (Exception  err) {
            System.out.println(err.getMessage());
        } finally {
            System.out.println("Finally");
        }
    }

    void forLoop(int begin, int end) {
        var sum = 0;
        for(int i=begin; i<end; i++) {
            if (i == 4) {
                continue;
            }

            sum += i;
        }
    }

    void forEach(List<Integer> array) {
        var sum = 0;
        for (final var item: array) {
            sum += item;
        }
    }

     int whileLoop() {
        var sum = 0;
        while (sum % 200 != 3) {
            sum += (sum + 1);
        }
        return sum;
    }

    int doLoop(int start) {
        var sum = start;
        do {
            sum += (sum + 1);
        } while ( (sum % 200 != 3));
        return sum;
    }

    @Override
    public void method(Integer value) {

        switch (value) {
            case 1, 3, 5:
                this.intField *= 2;
                break;
            case 2:
                break;
            default:
                this.intField /= 2;
                break;
        }
    }

    public void method() {

        System.out.println("Hello");

        switch (enumField) {
            case LAST -> {
                this.intField += 2;
            }
            case FIRST -> {
                this.intField--;
            }
        }


    }

    public void method(T value) {
        if (doubleField > 5 && doubleField <= 10) {
            System.out.println(doubleField);
        } else if (intField == 9) {
            System.out.println(intField);
        } else {
            System.out.println(stringField);
        }
    }

    public String retStringMethod(String stringField) {

        assert (!stringField.isEmpty());

        this.stringField = "Adb" + "Cda" + stringField;

        int[] x = new int[]{0, 1, 42};

        x[1] = stringField.length() > 3 ? x[0] : x[2];

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

