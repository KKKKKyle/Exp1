/*
@description This abstract class is the base for the majority of 
test cases that are not Servlet or class based issue and have both
a "bad" and "good" function.

*/

package support;

public abstract class AbstractTestCase extends AbstractTestCaseBase 
{
    public abstract void bad() throws Throwable;

    public abstract void good() throws Throwable;
    
    public void runTest(String className) 
    {
        System.out.println("Starting tests for Class " + className);

        try 
        {
            good();
   
            System.out.println("Completed good() for Class " + className);  
        } 
        catch (Throwable throwableException) 
        {
            System.out.println("Caught a throwable from good() for Class " + className);

            System.out.println("Throwable's message = " + throwableException.getMessage());
            
            StackTraceElement stackTraceElements[] = throwableException.getStackTrace();

            System.out.println("Stack trace below");

            for (StackTraceElement stackTraceElement : stackTraceElements) 
            {
                System.out.println(stackTraceElement.toString());
            } 
        } 

        try 
        {
            bad();
            
            System.out.println("Completed bad() for Class " + className);
        } 
        catch (Throwable throwableException) 
        {
            System.out.println("Caught a throwable from bad() for Class " + className);

            System.out.println("Throwable's message = " + throwableException.getMessage());
            
            StackTraceElement stackTraceElements[] = throwableException.getStackTrace();

            System.out.println("Stack trace below");

            for (StackTraceElement stackTraceElement : stackTraceElements) 
            {
                System.out.println(stackTraceElement.toString());
            } 
        } 
    } /* runTest */
}
