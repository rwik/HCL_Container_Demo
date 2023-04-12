
package com.ecyrd.jspwiki;

import junit.framework.*;
import java.io.*;
import java.util.*;
import org.apache.log4j.*;

/**
 *  Tests the UserProfile class.
 *  @author Janne Jalkanen
 */
public class UserProfileTest extends TestCase
{
    public UserProfileTest( String s )
    {
        super( s );
        Properties props = new Properties();
        try
        {
            props.load( TestEngine.findTestProperties() );
            PropertyConfigurator.configure(props);
        }
        catch( IOException e ) {}
    }

    public void setUp()
        throws Exception
    {
    }

    public void tearDown()
    {
    }

    public void testStringRepresentation()
        throws Exception
    {
        UserProfile p = new UserProfile("username=JanneJalkanen");

        assertEquals( "name", "JanneJalkanen",p.getName() );
    }

    /**
     *  Sometimes not all servlet containers offer you correctly
     *  decoded cookies.  Reported by KalleKivimaa.
     */
    public void testBrokenStringRepresentation()
        throws Exception
    {
        UserProfile p = new UserProfile("username%3DJanneJalkanen");

        assertEquals( "name", "JanneJalkanen",p.getName() );
    }

    public void testUTFStringRepresentation()
        throws Exception
    {
        UserProfile p = new UserProfile();

        p.setName("M��m��");
        String s = p.getStringRepresentation();

        UserProfile p2 = new UserProfile( s );
        assertEquals( "name", "M��m��", p2.getName() );
    }

    public void testUTFURLStringRepresentation()
        throws Exception
    {
        UserProfile p = new UserProfile("username="+TextUtil.urlEncodeUTF8("M��m��"));

        assertEquals( "name", "M��m��",p.getName() );
    }


    public static Test suite()
    {
        return new TestSuite( UserProfileTest.class );
    }
}
