package com.netcracker.shared;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class Client_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.String getFirstName(com.netcracker.shared.Client instance) /*-{
    return instance.@com.netcracker.shared.Client::firstName;
  }-*/;
  
  private static native void setFirstName(com.netcracker.shared.Client instance, java.lang.String value) 
  /*-{
    instance.@com.netcracker.shared.Client::firstName = value;
  }-*/;
  
  private static native java.lang.String getLastName(com.netcracker.shared.Client instance) /*-{
    return instance.@com.netcracker.shared.Client::lastName;
  }-*/;
  
  private static native void setLastName(com.netcracker.shared.Client instance, java.lang.String value) 
  /*-{
    instance.@com.netcracker.shared.Client::lastName = value;
  }-*/;
  
  private static native java.lang.String getMiddleName(com.netcracker.shared.Client instance) /*-{
    return instance.@com.netcracker.shared.Client::middleName;
  }-*/;
  
  private static native void setMiddleName(com.netcracker.shared.Client instance, java.lang.String value) 
  /*-{
    instance.@com.netcracker.shared.Client::middleName = value;
  }-*/;
  
  private static native java.lang.String getNumber(com.netcracker.shared.Client instance) /*-{
    return instance.@com.netcracker.shared.Client::number;
  }-*/;
  
  private static native void setNumber(com.netcracker.shared.Client instance, java.lang.String value) 
  /*-{
    instance.@com.netcracker.shared.Client::number = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.netcracker.shared.Client instance) throws SerializationException {
    setFirstName(instance, streamReader.readString());
    setLastName(instance, streamReader.readString());
    setMiddleName(instance, streamReader.readString());
    setNumber(instance, streamReader.readString());
    
  }
  
  public static com.netcracker.shared.Client instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.netcracker.shared.Client();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.netcracker.shared.Client instance) throws SerializationException {
    streamWriter.writeString(getFirstName(instance));
    streamWriter.writeString(getLastName(instance));
    streamWriter.writeString(getMiddleName(instance));
    streamWriter.writeString(getNumber(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.netcracker.shared.Client_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.netcracker.shared.Client_FieldSerializer.deserialize(reader, (com.netcracker.shared.Client)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.netcracker.shared.Client_FieldSerializer.serialize(writer, (com.netcracker.shared.Client)object);
  }
  
}
