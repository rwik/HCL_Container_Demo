/**
   * Licensed Materials - Property of IBM
   *
   * Restricted Materials of IBM
   * 
   * This sample program is provided AS IS and may be used, executed, copied
   * and modified without 
   * royalty payment by customer (a) for its own instruction and study, (b)
   * in order to develop 
   * applications designed to run with an IBM WebSphere product, either for
   * customer's own internal use
   * or for redistribution by customer, as part of such an application, in
   * customer's own products.
   * 
   * IBM Security AppScan Source for Analysis
   *
   * (c) Copyright IBM Corp. 2008,2009.  All Rights Reserved.
   *
   * U.S. Government Users Restricted Rights:  Use, duplication or
   * disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
*/
import java.io.*;

/**
 * TestCase_IOT_Simple_Validation
 * <p/>
 * The results of assessing this file should be no vulnerability. 
 * The validate() method must be tied as a validation rouine
 * to the fis.read call in getCoveredVulnerableSource().
 * <p/>
 * Complexity: Medium
 */
public class TestCase_IOT_Simple_Validation {
    public static void main(String[] args) {
        try {
            testSinkValidated( args );
        } catch (Exception e) {
        }
    }
    
    /**
     *  In this case, external data goes through a validation routine before
     *  reaching a sink.
     *  <p/>
     *  There should be no vulnerability derived from this call, when
     *  the validate() method is specified as a validation routine.
     *
     */
    private static void testSinkValidated( String[] args)
    {
        try {
            TestCase_IOT_Simple_Validation testCase = new TestCase_IOT_Simple_Validation();
            String file = args[0];
            String source = testCase.getCoveredVulnerableSource(file);
            source = testCase.validate(source);
            testCase.writeToVulnerableSink(file, source);
        } catch (Exception e) {
        }
    }

    /**
     * This is used as a source of input for which the input call
     * has an associated validation routine. For the test to get expected
     * results, the validate() method should be associated with the specific read()
     * call inside this method.
     */
    public String getCoveredVulnerableSource(String file) throws Exception {
        FileInputStream fis = new FileInputStream(file);
        byte[] buf = new byte[100];
        fis.read(buf); // Tie validate() to this read() call
        fis.close();

        String ret = new String(buf);
        return ret;
    }

    public void writeToVulnerableSink(String file, String str) throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream(file);
        PrintWriter writer = new PrintWriter(fos);
        writer.print(str);
    }

    private String validate(String source) throws Exception {
        if (source.length() > 100) {
            throw new Exception("Length too long: " + source.length());
        }
		return source;
    }

} // class TestCase_IOT_Simple_Validation
