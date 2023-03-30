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
 * TestCase_IOT_OverlapTrace
 * <p/>
 * Tne result of running this testcase is to find two stack traces, one that has main as the root,
 * and the other that has writeToSinkCheck as the root.  What makes this testcase special is that
 * the two stack traces overlap each other.
 * <p/>
 * Complexity: Moderate Hard
 */
public class TestCase_IOT_OverlapTrace {
    public static void main(String[] args) {
        try {
            TestCase_IOT_OverlapTrace testCase = new TestCase_IOT_OverlapTrace();
            final String file = args[0];
            String str = testCase.readFromVulnerableSource(file);
            testCase.writeToSinkCheck(file, str);
        } catch (Exception ex) {
        }
    }

    private String readFromVulnerableSource(String file) throws Exception {
        FileInputStream fis = new FileInputStream(file);
        byte[] buf = new byte[100];
        fis.read(buf);
        String ret = new String(buf);
        fis.close();

        return ret;
    }

    private void writeToSinkCheck(String file, String str) throws Exception {
        if (str == null) {
            str = readFromVulnerableSource(file);
        }
        writeToVulnerableSink(str);
    }

    private void writeToVulnerableSink(String str) throws Exception {
        FileOutputStream fos = new FileOutputStream(str);
        PrintWriter writer = new PrintWriter(fos);
        writer.println(str);
    }
}
