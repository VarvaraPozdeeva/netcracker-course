package com.netcracker.shared;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class Place_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.Integer getCoutDays(com.netcracker.shared.Place instance) /*-{
    return instance.@com.netcracker.shared.Place::coutDays;
  }-*/;
  
  private static native void setCoutDays(com.netcracker.shared.Place instance, java.lang.Integer value) 
  /*-{
    instance.@com.netcracker.shared.Place::coutDays = value;
  }-*/;
  
  private static native java.lang.String getDate(com.netcracker.shared.Place instance) /*-{
    return instance.@com.netcracker.shared.Place::date;
  }-*/;
  
  private static native void setDate(com.netcracker.shared.Place instance, java.lang.String value) 
  /*-{
    instance.@com.netcracker.shared.Place::date = value;
  }-*/;
  
  private static native java.lang.String getDestination(com.netcracker.shared.Place instance) /*-{
    return instance.@com.netcracker.shared.Place::destination;
  }-*/;
  
  private static native void setDestination(com.netcracker.shared.Place instance, java.lang.String value) 
  /*-{
    instance.@com.netcracker.shared.Place::destination = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.netcracker.shared.Place instance) throws SerializationException {
    setCoutDays(instance, (java.lang.Integer) streamReader.readObject());
    setDate(instance, streamReader.readString());
    setDestination(instance, streamReader.readString());
    
  }
  
  public static com.netcracker.shared.Place instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.netcracker.shared.Place();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.netcracker.shared.Place instance) throws SerializationException {
    streamWriter.writeObject(getCoutDays(instance));
    streamWriter.writeString(getDate(instance));
    streamWriter.writeString(getDestination(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.netcracker.shared.Place_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.netcracker.shared.Place_FieldSerializer.deserialize(reader, (com.netcracker.shared.Place)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.netcracker.shared.Place_FieldSerializer.serialize(writer, (com.netcracker.shared.Place)object);
  }
  
}
