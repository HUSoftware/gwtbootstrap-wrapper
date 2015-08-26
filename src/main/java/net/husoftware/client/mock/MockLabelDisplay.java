package net.husoftware.client.mock;

import net.husoftware.client.model.LabelDisplay;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Widget;

public class MockLabelDisplay extends MockDisplay implements LabelDisplay
{
  private String mValue;
  private boolean mShowing;
  private boolean mSource;
  private ClickHandler mHandler;

  @Override
  public void setValue(String inValue)
  {
    mValue = inValue;
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
  public void setTitle(String inText)
  {
  }

  @Override
  public HandlerRegistration addClickHandler(ClickHandler inHandler)
  {
    mHandler = inHandler;
    return new MockHandlerRegistration(mHandler);
  }

  public void click()
  {
    mSource = true;
    mHandler.onClick(null);
  }

  @Override
  public boolean isSource(ClickEvent inEvent)
  {
    return mSource;
  }

  public void setSource(boolean inSource)
  {
    mSource = inSource;
  }

  @Override
  public void setShow(boolean inShow)
  {
    mShowing = inShow;
  }

  public boolean isShowing()
  {
    return mShowing;
  }

  @Override
  public void setHTML(String inHtml)
  {
    setValue(inHtml);
  }
}