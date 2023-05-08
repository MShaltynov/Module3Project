import com.shaltynov.GameTextCreator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTextCreatorTest {
    GameTextCreator gameTextCreator = new GameTextCreator();

    @Test
    public void testgetbuttin2() {
        String actual=gameTextCreator.getButton2text(1);
        String expected ="Reject the call";
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void testVoidMethod() {
        Assertions.assertDoesNotThrow(() -> gameTextCreator.setButton2State("on"));
        Assertions.assertEquals("on", gameTextCreator.getButton2state());

        Assertions.assertDoesNotThrow(() -> gameTextCreator.setButton2State("off"));
        Assertions.assertEquals("off", gameTextCreator.getButton2state());
    }
}
