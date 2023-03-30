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
import java.io.PrintWriter;
import java.sql.ResultSet;

/**
 * TestCase_IOT_UserValidation2
 * <p/>
 * The results of assessing this file the first time should be an input output trace with the root in
 * the trace1 method.  After adding the validate method, the vulnerability and trace should go away.
 * <p/>
 * Complexity: Moderate
 */
public class TestCase_IOT_UserValidation2 {
    ResultSet resultSet;
    PrintWriter printWriter;
    FileInputStream fileInputStream;
    byte[] buffer;

    public static void main(String[] args) throws Exception {
        TestCase_IOT_UserValidation2 testCase = new TestCase_IOT_UserValidation2();
        testCase.trace1();
    }

    private void trace1() throws Exception {
        String source = getVulnerableSource();
        callValidateEventually(source);

        FileOutputStream fileOutputStream = new FileOutputStream("c:\\foo");
	    printWriter = new PrintWriter(fileOutputStream);
        writeToVulnerableSink(source);
    }

    public String getVulnerableSource() throws Exception {
        fileInputStream.read(buffer);
        return new String(buffer);
    }

    public void writeToVulnerableSink(String str) throws Exception {
        printWriter.write(str);
    }

    private void callValidateEventually(String source) throws Exception {
        callValidateAlmostThere(source);
    }

    private void callValidateAlmostThere(String source) throws Exception {
        callValidate(source);
    }

    private void callValidate(String source) throws Exception {
        source = validate(source);
    }

    private String validate(String source) throws Exception {
        if (source.length() > 100) {
            throw new Exception("Out of bounds");
        }
		return source;
    }
}
