package javaPractice;

public interface ParentInterface1 {

    public default void method1() {
        System.out.println("Default Method from ParentInterface1");
    }

    public  void method2();


    interface ChildInterface1{

        public default void methodChildInterface() {
            System.out.println("***method from Child Interface executed !!!");

        }


    }

}
