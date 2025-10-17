package operationPackage;

import java.io.Serializable;

public class Operation implements Serializable {
    private int a;
    private int b;
    private char op;

    public Operation(int a, int b, char op) {
        this.a =a;
        this.b =b;
        this.op =op;
    }

    public int getA() { return a; }
    public int getB() { return b; }
    public char getOperateur() { return op; }
}
