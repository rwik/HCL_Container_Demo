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
 * TestCase_IOT_Instance
 * <p/>
 * The results of assessing this file should be a input output stack trace
 * leading from getVulnerableSource to writeToVulnerableSink.  Unlike the TestCase_IOT_Static
 * class, all methods in this class are not static.  We do not use temporaries to store the
 * result of getVulnerableSource().
 * <p/>
 * Complexity: Easy
 */
public class TestCase_IOT_Instance {
    public static void main(String[] args) {
        try {
            TestCase_IOT_Instance testCase = new TestCase_IOT_Instance();
            testCase.writeToVulnerableSink(testCase.getVulnerableSource(args[0]));
        } catch (Exception e) {
        }
    }

    public String getVulnerableSource(String file)
        throws IOException, FileNotFoundException {
        FileInputStream fis = new FileInputStream(file);
        byte[] buf = new byte[100];
        fis.read(buf);
        String ret = new String(buf);
        fis.close();
        return ret;
    }

    public void writeToVulnerableSink(String str)
        throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream(str);
        PrintWriter writer = new PrintWriter(fos);
        writer.write(str);
    }
}
