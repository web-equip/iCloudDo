package org.omg.IOP;


/**
* org/omg/IOP/IOR.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from c:/re/workspace/8-2-build-windows-amd64-cygwin/jdk8u91/7017/corba/src/share/classes/org/omg/PortableInterceptor/IOP.idl
* Friday, May 20, 2016 5:44:10 PM PDT
*/

public final class IOR implements org.omg.CORBA.portable.IDLEntity
{

  /** The type id, represented as a String. */
  public String type_id = null;

  /** 
	 * An array of tagged profiles associated with this 
	 * object reference. 
	 */
  public TaggedProfile profiles[] = null;

  public IOR ()
  {
  } // ctor

  public IOR (String _type_id, TaggedProfile[] _profiles)
  {
    type_id = _type_id;
    profiles = _profiles;
  } // ctor

} // class IOR
