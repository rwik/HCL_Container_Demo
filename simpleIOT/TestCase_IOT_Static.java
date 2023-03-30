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
 * TestCase_IOT_Static
 * <p/>
 * The results of assessing this file should be a input output stack trace leading from getVulnerableSource to
 * writeToVulnerableSink.  All methods in this class are static.  We do not use a temporary to store the source.
 * <p/>
 * Complexity: Easiest
 */
public class TestCase_IOT_Static {
    public static void main(String[] args) {
        try {
            writeToVulnerableSink(getVulnerableSource(args[0]));
        } catch (Exception e) {
        }
    }

    public static String getVulnerableSource(String file)
        throws java.io.IOException, java.io.FileNotFoundException {
        FileInputStream fis = new FileInputStream(file);
        byte[] buf = new byte[100];
        fis.read(buf);
        String ret = new String(buf);
        fis.close();
        return ret;
    }

    public static void writeToVulnerableSink(String str)
        throws java.io.FileNotFoundException {
        FileOutputStream fos = new FileOutputStream(str);
        PrintWriter writer = new PrintWriter(fos);
        writer.write(str);
    }
}
