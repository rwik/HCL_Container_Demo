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
 * TestCase_IOT_Instance_Val_Encode
 * <p/>
 * The results of assessing this file should be a input output stack trace leading from getVulnerableSource to
 * writeToVulnerableSink the first time.  After adding validate or encode, the stack trace should be gone and
 * the vulnerabilities cleared.
 * <p/>
 * Complexity: Medium
 */
public class TestCase_IOT_Instance_Val_Encode {
    public static void main(String[] args) {
        try {
            TestCase_IOT_Instance_Val_Encode testCase = new TestCase_IOT_Instance_Val_Encode();
            String file = args[0];
            String source = testCase.getVulnerableSource(file);
            source = testCase.validate(source);
            String encodedStr = testCase.encode(source);
            testCase.writeToVulnerableSink(file, encodedStr);
        } catch (Exception e) {
        }
    }

    public String getVulnerableSource(String file) throws Exception {
        FileInputStream fis = new FileInputStream(file);
        byte[] buf = new byte[100];
        fis.read(buf);
        fis.close();

        String ret = new String(buf);
        return ret;
    }

    public void writeToVulnerableSink(String file, String str) throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream(file);
        PrintWriter writer = new PrintWriter(fos);
        writer.write(str);
    }

    private String validate(String source) throws Exception {
        if (source.length() > 100) {
            throw new Exception("Length too long: " + source.length());
        }
		return source;
    }

    private String encode(String source) {
        return source.trim();
    }
}
