package org.omg.CORBA;


/**
* org/omg/CORBA/WStringSeqHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from c:/re/workspace/8-2-build-windows-amd64-cygwin/jdk8u91/7017/corba/src/share/classes/org/omg/PortableInterceptor/CORBAX.idl
* Friday, May 20, 2016 5:44:10 PM PDT
*/


/** An array of WStrings */
public final class WStringSeqHolder implements org.omg.CORBA.portable.Streamable
{
  public String value[] = null;

  public WStringSeqHolder ()
  {
  }

  public WStringSeqHolder (String[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = WStringSeqHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    WStringSeqHelper.write (o, value);
  }

  public TypeCode _type ()
  {
    return WStringSeqHelper.type ();
  }

}
