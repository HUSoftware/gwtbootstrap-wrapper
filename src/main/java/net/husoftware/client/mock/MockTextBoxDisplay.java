package net.husoftware.client.mock;

import net.husoftware.client.model.TextBoxDisplay;

import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.Event;

public class MockTextBoxDisplay implements TextBoxDisplay
{
  private String mValue;
  private boolean mEnabled;
  private ClickHandler mClickHandler;
  private ChangeHandler mChangeHandler;
  private KeyUpHandler mKeyUpHandler;
  private KeyDownHandler mKeyDownHandler;
  private KeyPressHandler mKeyPressHandler;
  private boolean mShowing;
  private boolean mSource;
  private boolean mFocus;
  private int mMaxLength;
  private String mPlaceholder;

  public MockTextBoxDisplay()
  {
  }

  public MockTextBoxDisplay(String inDefaultValue)
  {
    mValue = inDefaultValue;
  }

  @Override
  public void setValue(String inValue)
  {
    mValue = inValue == null ? "" : inValue;
  }

  @Override
  public String getValue()
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
  public HandlerRegistration addClickHandler(ClickHandler inHandler)
  {
    mClickHandler = inHandler;
    return new MockHandlerRegistration(mClickHandler);
  }

  public void click()
  {
    mSource = true;
    mClickHandler.onClick(null);
  }

  @Override
  public HandlerRegistration addChangeHandler(ChangeHandler inHandler)
  {
    mChangeHandler = inHandler;
    return new MockHandlerRegistration(mChangeHandler);
  }

  public void change()
  {
    mSource = true;
    mChangeHandler.onChange(null);
  }

  @Override
  public boolean isSource(Event<?> inEvent)
  {
    return mSource;
  }

  @Override
  public void setVisible(boolean inShow)
  {
    mShowing = inShow;
  }

  public boolean isShowing()
  {
    return mShowing;
  }

  @Override
  public void focus(boolean inAtEnd)
  {
    setFocus(true);
  }

  public boolean isFocus()
  {
    return mFocus;
  }

  public int getMaxLength()
  {
    return mMaxLength;
  }

  @Override
  public void setMaxLength(int inLength)
  {
    mMaxLength = inLength;
  }

  @Override
  public HandlerRegistration addKeyUpHandler(KeyUpHandler inHandler)
  {
    mKeyUpHandler = inHandler;
    return new MockHandlerRegistration(mKeyUpHandler);
  }

  @Override
  public HandlerRegistration addKeyDownHandler(KeyDownHandler inHandler)
  {
    mKeyDownHandler = inHandler;
    return new MockHandlerRegistration(mKeyDownHandler);
  }

  @Override
  public HandlerRegistration addKeyPressHandler(KeyPressHandler inHandler)
  {
    mKeyPressHandler = inHandler;
    return new MockHandlerRegistration(mKeyPressHandler);
  }

  @Override
  public void setPlaceholder(String inPlaceHolder)
  {
    mPlaceholder = inPlaceHolder;
  }

  public String getPlaceholder()
  {
    return mPlaceholder;
  }

  @Override
  public void focus(Integer inDelay, boolean inAtEnd)
  {
    setFocus(true);
  }

  @Override
  public HandlerRegistration addFocusHandler(FocusHandler inHandler)
  {
    return new MockHandlerRegistration(inHandler);
  }

  @Override
  public HandlerRegistration addBlurHandler(BlurHandler inHandler)
  {
    return new MockHandlerRegistration(inHandler);
  }

  @Override
  public void setFocus(boolean inFocus)
  {
    mFocus = inFocus;
  }
}