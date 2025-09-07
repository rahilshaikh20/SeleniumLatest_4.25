package javaPractice;

public class ChildClass1 extends ParentClass {

    public static void main(String[] args) {

        ParentClass parentClass = new ChildClass2();
        parentClass.functionInheritance3();
        ParentInterface2.methodStatic5();

    }

    public void functionInheritance() {
        System.out.println("Child1 Printed !!");
    }

    @Override
    void functionInheritance3() {
        System.out.println("Child 1 abs method printed");
    }
}
