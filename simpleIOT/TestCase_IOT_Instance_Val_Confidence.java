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
 * TestCase_IOT_Instance_Val_Confidence
 * <p/>
 * This file has several tests to make sure we get confidence level correct in the
 * face of 6 different scenarios in a matrix encompassing 2 axes.
 * One axis is whether the trace goes to a sink, or is 'lost' (reaches a non-sink
 * that is a leaf in the call graph.
 * The other axis has 3 choices:
 *    - a validation routine exists and the trace goes through it
 *    - a validation routine exists and the trace does not go through i.
 *    - there is no validation routine
 * <p/>
 * For call trees rooted at the test routines listed here, 
 * the results of assessing this file should be:
 *  - testSinkValidated: no vulnerability
 *  - testSinkValidationNotUsed: high confidence (Vulnerability)
 *  - testSinkNoValidationAvailable: medium confidence (Type I)
 *  - testLostValidated: no vulnerability
 *  - testLostValidationNotUsed: medium confidence (Type I)
 *  - testLostNoValidationAvailable: low confidence (Type II)
 * <p/>
 * For this test to work correctly, this class' 'validate()' method
 * must be tied to the specific fis.read(..) call in the method
 * 'getCoveredVulnerableSource()'.
 * <p/>
 * Complexity: Medium
 */
public class TestCase_IOT_Instance_Val_Confidence {
    public static void main(String[] args) {
        try {
            testSinkValidated( args );
            testSinkValidationNotUsed( args );
            testSinkNoValidationAvailable( args );

            testLostValidated( args );
            testLostValidationNotUsed( args );
            testLostNoValidationAvailable( args );
        } catch (Exception e) {
        }
    }
    
    /**
     *  In this case, external data goes through a validation routine before
     *  reaching a sink.
     *  <p/>
     *  There should be no vulnerability derived from this call.
     *
     */
    private static void testSinkValidated( String[] args)
    {
        try {
            TestCase_IOT_Instance_Val_Confidence testCase = new TestCase_IOT_Instance_Val_Confidence();
            String file = args[0];
            String source = testCase.getCoveredVulnerableSource(file);
            source = testCase.validate(source);
            testCase.writeToVulnerableSink(file, source);
        } catch (Exception e) {
        }
    }

    /**
     *  In this case, external data reaches a sink, and a validation routine
     *  is available, but is not used.
     *  <p/>
     *  There should be a high confidence vulnerability derived from this call.
     *
     */
    private static void testSinkValidationNotUsed( String[] args)
    {
        try {
            TestCase_IOT_Instance_Val_Confidence testCase = new TestCase_IOT_Instance_Val_Confidence();
            String file = args[0];
            String source = testCase.getCoveredVulnerableSource(file);
            testCase.writeToVulnerableSink(file, source);
        } catch (Exception e) {
        }
    }

    /**
     *  In this case, external data reaches a sink, but there is no validation
     *  routine available.  
     *  <p/>
     *  There should be a medium confidence vulnerability derived from this call.
     *
     */
    private static void testSinkNoValidationAvailable( String[] args)
    {
        try {
            TestCase_IOT_Instance_Val_Confidence testCase = new TestCase_IOT_Instance_Val_Confidence();
            String file = args[0];
            String source = testCase.getUnCoveredVulnerableSource(file);
            testCase.writeToVulnerableSink(file, source);
        } catch (Exception e) {
        }
    }

    /**
     *  In this case, external data goes through a validation routine before
     *  getting lost.
     *  <p/>
     *  There should be no vulnerability derived from this call.
     *
     */
    private static void testLostValidated( String[] args)
    {
        try {
            TestCase_IOT_Instance_Val_Confidence testCase = new TestCase_IOT_Instance_Val_Confidence();
            String file = args[0];
            String source = testCase.getCoveredVulnerableSource(file);
            source = testCase.validate(source);
            testCase.writeToUnknownSink(file, source);
        } catch (Exception e) {
        }
    }

    /**
     *  In this case, external data gets lost, and a validation routine
     *  is available, but is not used.
     *  <p/>
     *  There should be a medium confidence vulnerability derived from this call.
     *
     */
    private static void testLostValidationNotUsed( String[] args)
    {
        try {
            TestCase_IOT_Instance_Val_Confidence testCase = new TestCase_IOT_Instance_Val_Confidence();
            String file = args[0];
            String source = testCase.getCoveredVulnerableSource(file);
            testCase.writeToUnknownSink(file, source);
        } catch (Exception e) {
        }
    }

    /**
     *  In this case, external data gets lost, but there is no validation
     *  routine available.  
     *  <p/>
     *  There should be a low confidence vulnerability derived from this call.
     *
     */
    private static void testLostNoValidationAvailable( String[] args)
    {
        try {
            TestCase_IOT_Instance_Val_Confidence testCase = new TestCase_IOT_Instance_Val_Confidence();
            String file = args[0];
            String source = testCase.getUnCoveredVulnerableSource(file);
            testCase.writeToUnknownSink(file, source);
        } catch (Exception e) {
        }
    }

    /**
     * This is used as a source of input for which the input call
     * has an associated validation routine. For the test to get expected
     * results, the validate() method should be associated with the specific read()
     * call inside this method.
     */
    public String getCoveredVulnerableSource(String file) throws Exception {
        FileInputStream fis = new FileInputStream(file);
        byte[] buf = new byte[100];
        fis.read(buf); // Tie validate() to this read() call
        fis.close();

        String ret = new String(buf);
        return ret;
    }

    /**
     * This is used as a source of input for which the input call
     * has *no* associated validation routine. For the test to get expected
     * results, no validation routine should be associated with the read()
     * call inside this method.
     */
    public String getUnCoveredVulnerableSource(String file) throws Exception {
        FileInputStream fis = new FileInputStream(file);
        byte[] buf = new byte[100];
        fis.read(buf); // Tie validate() to this read() call
        fis.close();

        String ret = new String(buf);
        return ret;
    }

    public void writeToVulnerableSink(String file, String str) throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream(file);
        PrintWriter writer = new PrintWriter(fos);
        writer.print(str);
    }

    public void writeToUnknownSink(String key, String str) 
    {
        native_sink(key, str);
    }

    private String validate(String source) throws Exception 
    {
        if (source.length() > 100) 
        {
            throw new Exception("Length too long: " + source.length());
        }
		return source;
    }

    private native void native_sink( String s1, String s2 );


} // class TestCase_IOT_Instance_Val_Confidence
