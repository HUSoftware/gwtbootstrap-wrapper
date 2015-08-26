package net.husoftware.client.mock;

import java.util.Date;

import net.husoftware.client.model.DateSelectDisplay;

import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.Event;

public class MockDateSelectDisplay<H extends EventHandler> implements DateSelectDisplay<H>
{
  private Date mValue;
  private boolean mReadOnly;
  private boolean mVisible;
  private boolean mEnabled;

  @Override
  public void setValue(Date inValue)
  {
    mValue = inValue;
  }

  @Override
  public Date getValue()
  {
    return mValue;
  }

  @Override
  public Widget asWidget()
  {
    return null;
  }

  @Override
  public void setEnabled(boolean inEnable)
  {
    mEnabled = inEnable;
  }

  public boolean isEnabled()
  {
    return mEnabled;
  }

  @Override
  public HandlerRegistration addValueChangeHandler(ValueChangeHandler<Date> inHandler)
  {
    return null;
  }

  @Override
  public boolean isSource(Event<?> inEvent)
  {
    return false;
  }

  @Override
  public void setShow(boolean inShow)
  {
    mVisible = inShow;
  }

  public boolean isVisible()
  {
    return mVisible;
  }

  @Override
  public void fireEvent(GwtEvent<?> inEvent)
  {
  }

  @Override
  public IsWidget getDate()
  {
    return null;
  }

  @Override
  public void setReadOnly(boolean inReadOnly)
  {
    mReadOnly = inReadOnly;
  }

  public boolean isReadOnly()
  {
    return mReadOnly;
  }

  @Override
  public void show()
  {
  }

  @Override
  public void hide()
  {
  }

  @Override
  public HandlerRegistration addChangeDateHandler(H inHandler)
  {
    return null;
  }
}