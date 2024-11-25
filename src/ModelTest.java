import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ModelTest {
    @Before
    public void getFrame() {
        String[] fd = new String[0];
        Main.main(fd);
    }

    @Test
    public void testGetArrayList() {
        Model m1 = new Model("words.txt");
        assertNotNull(m1.handleLines());
    }

    @Test
    public void testArrayLength() {
        Model m1 = new Model("words.txt");
        assertFalse(m1.handleLines().isEmpty());
    }
}
