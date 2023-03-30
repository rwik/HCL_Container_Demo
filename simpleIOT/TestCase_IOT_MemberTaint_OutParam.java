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
 * TestCase_IOT_MemberTaint
 * <p/>
 * The results of assessing this file should be two input/output stack traces with main as the root.  The first trace
 * uses a member variable of a class to transmit the taint directly. The test passes the taint though a set method and
 * gets it back using a get method.  These differ from the TestCase_IOT_MemberTaint in that they transmit the taint
 * through an output parameter.
 * <p/>
 * Complexity: Hard
 */
public class TestCase_IOT_MemberTaint_OutParam {
    public static class TaintedStruct {
        public String m_tainted = null;

        TaintedStruct() {
        }

        TaintedStruct(String tainted) {
            m_tainted = tainted;
        }

        public String getTainted() {
            return m_tainted;
        }

        public void setTainted(String tainted) {
            m_tainted = tainted;
        }
    }

    public static void main(String[] args) {
        try {
            // first case
            TestCase_IOT_MemberTaint_OutParam testCase = new TestCase_IOT_MemberTaint_OutParam();
            TaintedStruct struct = new TaintedStruct();
            testCase.getTaintedStructSource1(args[0], struct);
            testCase.writeToVulnerableSink1(args[0], struct);

            // second case
            TaintedStruct struct2 = new TaintedStruct();
            testCase.getTaintedStructSource2(args[0], struct2);
            testCase.writeToVulnerableSink2(args[0], struct2);
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

    public void getTaintedStructSource1(String file, TaintedStruct struct) throws IOException {
        struct.m_tainted = getVulnerableSource(file);
    }

    public void writeToVulnerableSink1(String file, TaintedStruct struct) throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream(file);
        PrintWriter writer = new PrintWriter(fos);
        writer.write(struct.m_tainted);
    }

    public void getTaintedStructSource2(String file, TaintedStruct struct) throws IOException {
        struct.setTainted(getVulnerableSource(file));
    }

    public void writeToVulnerableSink2(String file, TaintedStruct struct) throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream(file);
        PrintWriter writer = new PrintWriter(fos);
        writer.write(struct.getTainted());
    }
}
