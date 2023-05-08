import com.shaltynov.GameTextCreator;
import com.shaltynov.ResponseCreator;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ResponseCreatorTest {

    private ResponseCreator responseCreator;

    @BeforeEach
    void setUp() {
        responseCreator = new ResponseCreator();
    }

    @Test
    void testCreateJSONResponse() {
        HttpServletRequest request = mock(HttpServletRequest.class);
        Map<String, Integer> userSession = new HashMap<>();
        when(request.getParameter("buttonOneState")).thenReturn("0");
        when(request.getParameter("buttonTwoState")).thenReturn("0");
        when(request.getParameter("textInputValue")).thenReturn("John");
        JSONObject json = responseCreator.createJSONResponse(request);
        assertEquals("Welcome to the  quest!", json.get("header"));
        assertEquals(0, json.get("step"));
        assertEquals("John", json.get("userName"));
        assertEquals(1, json.get("gameNumber"));
        assertEquals("Start quest", json.get("button1"));
        assertEquals("error in step 0", json.get("button2"));
        assertEquals("1", json.get("button1Visibility"));
    }
}
