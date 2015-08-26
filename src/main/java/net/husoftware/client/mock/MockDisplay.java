package net.husoftware.client.mock;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.husoftware.client.model.Display;

import com.google.gwt.event.dom.client.HumanInputEvent;
import com.google.gwt.event.dom.client.KeyCodeEvent;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

public class MockDisplay implements Display, IsWidget
{
  private String mAlertMessage;
  private String mConfirmMessage;
  private boolean mConfirm;
  private boolean mVisible;
  private boolean mEnabled;

  @Override
  public Widget asWidget()
  {
    return null;
  }

  @Override
  public void alert(String inMessage)
  {
    mAlertMessage = inMessage;
  }

  public String getAlertMessage()
  {
    return mAlertMessage;
  }

  @Override
  public boolean confirm(String inMessage)
  {
    mConfirmMessage = inMessage;
    return mConfirm;
  }

  public String getConfirmMessage()
  {
    return mConfirmMessage;
  }

  public void setConfirm(boolean inConfirm)
  {
    mConfirm = inConfirm;
  }

  public boolean isConfirm()
  {
    return mConfirm;
  }

  @Override
  public String format(String inPattern, Date inDate)
  {
    if (inDate == null)
    {
      return "";
    }
    return new SimpleDateFormat(inPattern).format(inDate);
  }

  @Override
  public MockModalDisplay newPop()
  {
    return new MockModalDisplay();
  }

  @Override
  public Date parse(String inPattern, String inDate)
  {
    if (inDate == null)
    {
      return null;
    }
    try
    {
      return new SimpleDateFormat(inPattern).parse(inDate);
    }
    catch (ParseException e)
    {
      // do nothing
    }
    return null;
  }

  @Override
  public boolean isShiftKeyDown(HumanInputEvent<?> inEvent)
  {
    return false;
  }

  @Override
  public boolean isAltKeyDown(HumanInputEvent<?> inEvent)
  {
    return false;
  }

  @Override
  public boolean isKeyEnter(KeyCodeEvent<?> inEvent)
  {
    return false;
  }

  @Override
  public boolean isKeyTab(KeyCodeEvent<?> inEvent)
  {
    return false;
  }

  @Override
  public boolean isShiftKeyDown(KeyCodeEvent<?> inEvent)
  {
    return false;
  }

  @Override
  public boolean isKeyDelete(KeyCodeEvent<?> inEvent)
  {
    return false;
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

  public boolean isEnabled()
  {
    return mEnabled;
  }

  public void setEnabled(boolean inEnabled)
  {
    mEnabled = inEnabled;
  }
}