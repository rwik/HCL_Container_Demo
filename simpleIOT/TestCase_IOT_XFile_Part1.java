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
 * TestCase_IOT_XFile_Part1
 * <p/>
 * The results of assessing this file should be a single input/output stack traces with main as the root.  The file
 * relies on TestCase_IOT_XFile_Part2 since we are trying to do a cross file analysis.
 * <p/>
 * Complexity: Moderate
 */
public class TestCase_IOT_XFile_Part1 {
    public static void main(String[] args) {
        try {
            TestCase_IOT_XFile_Part1 testCase = new TestCase_IOT_XFile_Part1();
            TestCase_IOT_XFile_Part2 testCase2 = new TestCase_IOT_XFile_Part2();
            testCase2.writeToVulnerableSink(testCase.getVulnerableSource(args[0]));
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
}
