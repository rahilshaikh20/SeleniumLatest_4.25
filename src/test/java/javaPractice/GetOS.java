package javaPractice;

public class GetOS {
    public static void main(String[] args) {

        String os = System.getProperty("os.name");
        System.out.println("Operating System: " + os);
        System.out.println(System.getProperty("os.version"));
        System.out.println(System.getProperty("os.arch"));
        System.out.println(System.getProperty("user.name"));

    }
}
