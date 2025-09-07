package jacocoTestCoverage;

import javaCode.CodeClass;
import org.junit.jupiter.api.Test;

public class TestCodeClass {

    @Test
    public void addTest() {
        CodeClass codeClass = new CodeClass();
        int c = codeClass.add(10, 15);
    }

    @Test
    public void mulTest() {
        CodeClass codeClass = new CodeClass();
        int c = codeClass.mul(10, 15);
    }
}
