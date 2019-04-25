package com.netcracker.shared;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class Order_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native com.netcracker.shared.Client getClient(com.netcracker.shared.Order instance) /*-{
    return instance.@com.netcracker.shared.Order::client;
  }-*/;
  
  private static native void setClient(com.netcracker.shared.Order instance, com.netcracker.shared.Client value) 
  /*-{
    instance.@com.netcracker.shared.Order::client = value;
  }-*/;
  
  private static native int getId(com.netcracker.shared.Order instance) /*-{
    return instance.@com.netcracker.shared.Order::id;
  }-*/;
  
  private static native void setId(com.netcracker.shared.Order instance, int value) 
  /*-{
    instance.@com.netcracker.shared.Order::id = value;
  }-*/;
  
  private static native com.netcracker.shared.Place getPlace(com.netcracker.shared.Order instance) /*-{
    return instance.@com.netcracker.shared.Order::place;
  }-*/;
  
  private static native void setPlace(com.netcracker.shared.Order instance, com.netcracker.shared.Place value) 
  /*-{
    instance.@com.netcracker.shared.Order::place = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.netcracker.shared.Order instance) throws SerializationException {
    setClient(instance, (com.netcracker.shared.Client) streamReader.readObject());
    setId(instance, streamReader.readInt());
    setPlace(instance, (com.netcracker.shared.Place) streamReader.readObject());
    
  }
  
  public static com.netcracker.shared.Order instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.netcracker.shared.Order();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.netcracker.shared.Order instance) throws SerializationException {
    streamWriter.writeObject(getClient(instance));
    streamWriter.writeInt(getId(instance));
    streamWriter.writeObject(getPlace(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.netcracker.shared.Order_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.netcracker.shared.Order_FieldSerializer.deserialize(reader, (com.netcracker.shared.Order)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.netcracker.shared.Order_FieldSerializer.serialize(writer, (com.netcracker.shared.Order)object);
  }
  
}
