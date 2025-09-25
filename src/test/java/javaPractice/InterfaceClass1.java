package javaPractice;

public class InterfaceClass1 implements ParentInterface1.ChildInterface1,ParentInterface1, ParentInterface2 {

    @Override
    public void method1() {System.out.println("Child class method");
 }

    public static void main(String[] args) {
        System.out.println("Main run !!");

        InterfaceClass1 obj1 = new InterfaceClass1();

        obj1.method1();
        obj1.method2();
        obj1.methodChildInterface();
        obj1.method4();

    }

    @Override
    public void method2() {
        System.out.println("Method 2 from class");
    }


    @Override
    public void method4() {

    }
}
