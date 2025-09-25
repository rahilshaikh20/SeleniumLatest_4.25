package javaPractice;

public class TryCatchFinally {

    public static void main(String[] args) throws ArithmeticException{

        try {
            int i = 9 / 0;
        } catch (Exception e) {
            System.out.println("Exception is: " + e);
        } finally {
            System.out.println("Finally executed!!");
        }
        System.out.println("Is this executed?");

        throw new RuntimeException("This is runtime by Rahil !");
    }
}
