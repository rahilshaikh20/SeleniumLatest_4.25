package javaPractice;

public interface ParentInterface1 {

    public default void method1() {
        System.out.println("Method from ParentInterface1");
    }

    public void method2();

}
