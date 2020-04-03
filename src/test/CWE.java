package test;
import java.net.PasswordAuthentication;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import support.AbstractTestCaseServlet;

public class CWE extends AbstractTestCaseServlet {
    // auto generated UID
    private static final long serialVersionUID = 1L;

    @Override
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable {

        String data;
        data = "";
        /* Read data from cookies */
        Cookie cookieSources[] = request.getCookies();
        if (cookieSources != null) {
            data = cookieSources[0].getValue();
        }
        if (data != null) {
            login();
        }
    }

    @Override
    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        // TODO Auto-generated method stub
    }

    /**
     * Login
     * 
     * @throws Throwable
     */
    public void login() throws Throwable {
        String data;
        data = "admin";
        PasswordAuthentication credentials = new PasswordAuthentication("user", data.toCharArray());
        System.out.println(credentials.toString());
    }
    
    /* Below is the main(). It is only used when building this testcase on
     * its own for testing or for building a binary to use in testing binary
     * analysis tools. It is not used when compiling all the testcases as one
     * application, which is how source code analysis tools are tested.
     */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }

}
