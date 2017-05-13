package app01b; /**
 * Created by zlby9 on 2017/5/12.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FormServlet", urlPatterns = {"/app01b/form"})
public class FromServlet extends HttpServlet {
    private static final long serialVersionUID = 54L;
    private static final String TITLE = "Order Form";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>" + TITLE + "</title></head>");
        writer.println("<body><h1>" + TITLE + "</h1>");
        writer.print("<form method='post'>\n" +
                "    <table>\n" +
                "        <tr>\n" +
                "            <td>Name:</td>\n" +
                "            <td><input name='name'/></td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td>Address:</td>\n" +
                "            <td><textarea name='address' cols='40' rows='5'></textarea></td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td>Country:</td>\n" +
                "            <td>\n" +
                "                <select name='country'>\n" +
                "                    <option>United States</option>\n" +
                "                    <option>Canada</option>\n" +
                "                </select>\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td>Delivery Method:</td>\n" +
                "            <td><input type='radio' name='deliveryMethod' value='First Class'/>First Class\n" +
                "                <input type='radio' name='deliveryMethod' value='Second Class'/>Second Class\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td>Shipping Instructions:</td>\n" +
                "            <td><textarea name='instruction' cols='40' rows='5'></textarea> </td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td>&nbsp;</td>\n" +
                "            <td><textarea name='instruction' cols='40' rows='5'></textarea></td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td>Please send me the latest product catalog:</td>\n" +
                "            <td><input type='checkbox' name='catalogRequest'/></td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td>&nbsp;</td>\n" +
                "            <td><input type='reset'/>&nbsp;<input type='submit'></td>\n" +
                "        </tr>\n" +
                "    </table>\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<html>\n" +
                "<head>\n" +
                "    <title>" + TITLE + "</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>" + TITLE + "</h1>\n" +
                "<table>\n" +
                "    <tr>\n" +
                "        <td>Name:</td>\n" +
                "        <td>" + req.getParameter("name") +  "</td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "        <td>Address:</td>\n" +
                "        <td>" + req.getParameter("address") + "</td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "        <td>Country:</td>\n" +
                "        <td>" + req.getParameter("country") + "</td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "        <td>Shipping Instruction:</td>\n" +
                "        <td>\n");
        String[] instructions = req.getParameterValues("instruction");
        if (instructions != null) {
            for (String instruction:instructions) {
                writer.println(instruction + "<br/>");
            }
        }
        writer.println(
                "        </td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "        <td>Delivery Method:</td>\n" +
                "        <td>" + req.getParameter("deliveryMethod") + "</td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "        <td>Catalog Request:</td>\n" +
                "        <td>\n");
        if (req.getParameter("catalogRequest") == null) {
            writer.println("No");
        } else {
            writer.println("Yes");
        }
        writer.println(
                "        </td>\n" +
                "    </tr>\n" +
                "</table>\n" +
                "<div style='border: 1px solid #ddd; margin-top: 40px; font-size: 90%'>\n" +
                "    Debug Info<br/>");
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            writer.println(paramName + ": ");
            String[] paramValues = req.getParameterValues(paramName);
            for (String paramValue : paramValues) {
                writer.println(paramValue + "<br/>");
            }
        }
        writer.println("</div>\n" +
                "</body>\n" +
                "</html>");
    }
}
