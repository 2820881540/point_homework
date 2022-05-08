package operator_test;

public class OperatorTest {
    public static void main(String[] args) {
        int a = 66, b = 77, c = 88;
        System.out.println(a>b?(a>c?a:c):(b>c?b:c));
    }
}
