package net.husoftware.client.mock;

import com.google.gwt.event.shared.HandlerRegistration;

public class MockHandlerRegistration implements HandlerRegistration
{
  private Object mObject;

  public MockHandlerRegistration(Object inObject)
  {
    mObject = inObject;
  }

  public Object getObject()
  {
    return mObject;
  }

  @Override
  public void removeHandler()
  {
  }
}