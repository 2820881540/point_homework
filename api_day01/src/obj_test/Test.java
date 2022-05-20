package obj_test;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("aaa");
        Student stu1 = new Student("张三",18);
        Student stu2 = (Student) stu1.clone();

        System.out.println(stu1==stu2);

        long millis = System.currentTimeMillis();
        System.out.println(millis);
        System.out.println(1000l*60*60*24*30);
        System.out.println(millis + 1000l*60*60*24*30);
    }
}
