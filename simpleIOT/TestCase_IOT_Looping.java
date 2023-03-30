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
 * TestCase_IOT_Looping
 * <p/>
 * The results of assessing this file should be two input/output stack traces with main as the root.
 * The program passes taint in a for loop and while loop
 * <p/>
 * Complexity: Moderate
 */
public class TestCase_IOT_Looping {
    public static void main(String[] args) {
        try {
            TestCase_IOT_Looping testCase = new TestCase_IOT_Looping();

            String source2;
            for (int x = 0; x < args.length; ++x) {
                if (x < 2) {
                    source2 = testCase.getVulnerableSource(args[x]);
                } else {
                    source2 = "Safe";
                }
                testCase.writeToVulnerableSink(source2);
            }

            String source1 = "";
            int x = 0;
            while (x < args.length) {
                source1 = source1 + testCase.getVulnerableSource(args[x]);
            }
            testCase.writeToVulnerableSink2(source1);
        } catch (Exception e) {
        }
    }

    public String getVulnerableSource(String file)
        throws IOException, FileNotFoundException {
        String ret = "";
        FileInputStream fis = new FileInputStream(file);
        byte[] buf = new byte[100];
        fis.read(buf);
        ret = new String(buf);
        fis.close();
        return ret;
    }

    public void writeToVulnerableSink(String str)
        throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream(str);
        PrintWriter writer = new PrintWriter(fos);
        writer.write(str);
    }

    public void writeToVulnerableSink2(String str)
        throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream(str);
        PrintWriter writer = new PrintWriter(fos);
        writer.write(str);
    }
}
