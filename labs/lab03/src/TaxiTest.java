import static org.junit.Assert.*;

import org.junit.*;

public class TaxiTest {
    
    Taxi t;
    
    @Before
    public void setup() {
        t = new Taxi(12.00, 5);
    }

    //Sample Unit Test
    @Test(timeout=100)
    public void testPickUpSuccess() {
        assertTrue(t.pickUp(5));
    }
    
    //calculateFare() test
    @Test(timeout=100)
    public void testCalculateFare() {
        
        int passLeaving = 4;
        int duration = 20;

        double actual = t.calculateFare(4,20);
        double expected = 960;
        
        assertEquals("Fare not calculated correctly", expected, actual, 0.1);
    }
    
    //pickUp() test #1
    @Test(timeout=100)
    public void testPickUpEnoughRoom() {
        int passLoading = 3;
        
        assertTrue(t.pickUp(passLoading));
        
    }
    
    //pickUp() test #2
    @Test(timeout=100)
    public void testPickUpEnoughRoom2() {
        int passLoading = 6;
        
        assertFalse(t.pickUp(passLoading));
        
    }
}
