import org.junit.Test;
import static org.junit.Assert.*;

public class testFlik {

    @Test
    public void testFlik() {
        int a = 128;
        int b = 128;
        boolean res = Flik.isSameNumber(a, b);
        boolean res2 = a == b;
        assertTrue(Flik.isSameNumber(a, b));
    }
}