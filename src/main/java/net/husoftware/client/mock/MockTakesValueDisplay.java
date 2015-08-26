package net.husoftware.client.mock;

import net.husoftware.client.model.TakesValueDisplay;

import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;

public class MockTakesValueDisplay<V> implements TakesValueDisplay<V>
{
  private boolean mVisible;
  private V mValue;

  public MockTakesValueDisplay(V inValue)
  {
    setValue(inValue);
  }

  @Override
  public boolean isVisible()
  {
    return mVisible;
  }

  @Override
  public void setVisible(boolean inVisible)
  {
    mVisible = inVisible;
  }

  @Override
  public void setValue(V inValue)
  {
    mValue = inValue;
  }

  @Override
  public V getValue()
  {
    return mValue;
  }

  @Override
  public HandlerRegistration addValueChangeHandler(ValueChangeHandler<V> inHandler)
  {
    return null;
  }
}