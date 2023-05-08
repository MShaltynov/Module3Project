import com.shaltynov.MyServlet;
import org.junit.Test;
import org.json.JSONObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MyServletTest {
    @Test
    public void testDoGet() throws ServletException, IOException {
        // Create a mock HttpServletRequest and HttpServletResponse
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        // Create a StringWriter to capture the response output
        StringWriter writer = new StringWriter();
        PrintWriter printWriter = new PrintWriter(writer);
        when(response.getWriter()).thenReturn(printWriter);

        // Call the doGet method on the servlet
        MyServlet servlet = new MyServlet();
        servlet.doGet(request, response);

        // Verify that the response has the expected JSON content
        JSONObject expectedJson = new JSONObject();
        expectedJson.put("header", "Welcome to the quest!");
        expectedJson.put("button1", "Play");
        expectedJson.put("button2", "No");

        JSONObject actualJson = new JSONObject(writer.toString());
        assertEquals(expectedJson.toString(), actualJson.toString());
    }
}
