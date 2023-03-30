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
 * TestCase_IOT_XFile_Val_Part1
 * <p/>
 * The results of running an assessment on this code will be a single input/output trace with main as the root when the
 * validate method is not specified (medium confidence/Type I).  When the validate method is marked as validating for
 * either input or output, no traces should be found and the vulnerability should be eliminated.
 * <p/>
 * Complexity: Moderate Hard
 */
public class TestCase_IOT_XFile_Val_Part1 {
    public static void main(String[] args) {
        try {
            TestCase_IOT_XFile_Val_Part1 testCase = new TestCase_IOT_XFile_Val_Part1();
            TestCase_IOT_XFile_Part2 testCase2 = new TestCase_IOT_XFile_Part2();
            testCase2.writeToVulnerableSink(testCase.validate(testCase.getVulnerableSource(args[0])));
        } catch (Exception e) {
        }
    }

    private String validate(String vulnerableSource) {
        return vulnerableSource;
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
