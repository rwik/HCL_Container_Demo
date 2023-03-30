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
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;

public class TestCase_IOT_UserValidation {
    ResultSet resultSet;
    FileInputStream fileInputStream;
    PrintWriter printWriter;
    byte[] buffer;

    public static void main(String[] args) throws Exception {
        TestCase_IOT_UserValidation testCase = new TestCase_IOT_UserValidation();
        testCase.trace1();

        TestCase_IOT_UserValidation testCase2 = new TestCase_IOT_UserValidation();
        testCase2.trace2();

        TestCase_IOT_UserValidation testCase3 = new TestCase_IOT_UserValidation();
        testCase3.trace3();
    }

    private void trace1() throws Exception {
        String source = getVulnerableSource1();
        source = validate(source);
        writeToVulnerableSink(source);
    }

    private void trace2() throws Exception {
        String source = getVulnerableSource2();
        source = validate(source);
        writeToVulnerableSink(source);
    }

    private void trace3() throws Exception {
        String source = getVulnerableSource3();
        source = validate(source);
        writeToVulnerableSink(source);
    }

    public String getVulnerableSource1() throws Exception {
        fileInputStream.read(buffer);
        return new String(buffer);
    }

    public String getVulnerableSource2() throws Exception {
        fileInputStream.read(buffer);
        return new String(buffer);
    }

    public String getVulnerableSource3() throws Exception {
        return resultSet.getString("x");
    }

    public void writeToVulnerableSink(String str) throws Exception {
        printWriter.write(str);
    }

    private String validate(String source) throws Exception {
        // validate
		return source;
    }
}
