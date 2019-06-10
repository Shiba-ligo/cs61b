import static org.junit.Assert.*;
import org.junit.Test;
public class TestFlik {
    @Test
    public void testFlik() {
        int a = 5;
        int b = 6;
        int c = 5;
        assertTrue(Flik.isSameNumber(a, c));
        assertTrue(!Flik.isSameNumber(a, b));
    }
}
