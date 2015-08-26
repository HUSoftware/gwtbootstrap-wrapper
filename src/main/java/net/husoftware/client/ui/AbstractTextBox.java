package net.husoftware.client.ui;

import java.util.ArrayList;
import java.util.List;

import org.gwtbootstrap3.client.ui.base.TextBoxBase;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.RepeatingCommand;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.web.bindery.event.shared.Event;

abstract class AbstractTextBox extends AbstractView
{
  protected TextBoxBase mTextBox;

  List<HandlerRegistration> mRegistrations = new ArrayList<HandlerRegistration>();

  public void setTextBox(TextBoxBase inTextBox)
  {
    mTextBox = inTextBox;
  }

  @Override
  protected void onUnload()
  {
    super.onUnload();
    for (HandlerRegistration value : mRegistrations)
    {
      value.removeHandler();
    }
    mRegistrations.clear();
  }

  public void setPlaceholder(String inPlaceHolder)
  {
    mTextBox.setPlaceholder(inPlaceHolder);
  }

  public void setMaxLength(int inLength)
  {
    mTextBox.setMaxLength(inLength);
  }

  @Override
  public void setWidth(String inWidth)
  {
    mTextBox.setWidth(inWidth);
  }

  @Override
  public void setHeight(String inHeight)
  {
    mTextBox.setHeight(inHeight);
  }

  private HandlerRegistration register(HandlerRegistration inRegistration)
  {
    mRegistrations.add(inRegistration);
    return inRegistration;
  }

  public boolean isSource(Event<?> inEvent)
  {
    return mTextBox.equals(inEvent.getSource());
  }

  public String getValue()
  {
    return mTextBox.getValue();
  }

  public void setValue(String inValue)
  {
    mTextBox.setValue(inValue);
  }

  public void setText(String inText)
  {
    mTextBox.setText(inText);
  }

  public void setEnabled(boolean inEnable)
  {
    mTextBox.setEnabled(inEnable);
  }

  public void setFocus(boolean inFocus)
  {
    mTextBox.setFocus(inFocus);
  }

  public void focus(final boolean inAtEnd)
  {
    Scheduler.get().scheduleDeferred(new ScheduledCommand()
    {
      @Override
      public void execute()
      {
        setFocus(true);
        if (inAtEnd)
        {
          mTextBox.setCursorPos(mTextBox.getValue().length());
        }
      }
    });
  }

  public void focus(Integer inDelay, final boolean inAtEnd)
  {
    if (inDelay != null)
    {
      Scheduler.get().scheduleFixedDelay(new RepeatingCommand()
      {
        @Override
        public boolean execute()
        {
          setFocus(true);
          if (inAtEnd)
          {
            mTextBox.setCursorPos(mTextBox.getValue().length());
          }
          return false;
        }
      }, inDelay);
    }
    else
    {
      Scheduler.get().scheduleDeferred(new ScheduledCommand()
      {
        @Override
        public void execute()
        {
          setFocus(true);
        }
      });
    }
  }

  public HandlerRegistration addClickHandler(ClickHandler inHandler)
  {
    return register(mTextBox.addClickHandler(inHandler));
  }

  public HandlerRegistration addChangeHandler(ChangeHandler inHandler)
  {
    return register(mTextBox.addChangeHandler(inHandler));
  }

  public HandlerRegistration addKeyUpHandler(KeyUpHandler inHandler)
  {
    return register(mTextBox.addKeyUpHandler(inHandler));
  }

  public HandlerRegistration addKeyDownHandler(KeyDownHandler inHandler)
  {
    return register(mTextBox.addKeyDownHandler(inHandler));
  }

  public HandlerRegistration addKeyPressHandler(KeyPressHandler inHandler)
  {
    return register(mTextBox.addKeyPressHandler(inHandler));
  }

  public HandlerRegistration addFocusHandler(FocusHandler inHandler)
  {
    return register(mTextBox.addFocusHandler(inHandler));
  }

  public HandlerRegistration addBlurHandler(BlurHandler inHandler)
  {
    return register(mTextBox.addBlurHandler(inHandler));
  }
}