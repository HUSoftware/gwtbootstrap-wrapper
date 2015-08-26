package net.husoftware.client.mock;

import net.husoftware.client.model.ImageDisplay;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.Event;

public class MockImageDisplay implements ImageDisplay
{
  private boolean mShow;
  private boolean mSource;
  private ClickHandler mHandler;

  @Override
  public Widget asWidget()
  {
    return null;
  }

  @Override
  public HandlerRegistration addClickHandler(ClickHandler inHandler)
  {
    mHandler = inHandler;
    return new HandlerRegistration()
    {
      @Override
      public void removeHandler()
      {
        mHandler = null;
      }
    };
  }

  public void click()
  {
    mSource = true;
    mHandler.onClick(null);
    mSource = false;
  }

  @Override
  public boolean isSource(Event<?> inEvent)
  {
    return mSource;
  }

  public void setSource(boolean inSource)
  {
    mSource = inSource;
  }

  @Override
  public void setResource(ImageResource inResource)
  {
  }

  @Override
  public void setShow(boolean inShow)
  {
    mShow = inShow;
  }

  @Override
  public boolean isShowing()
  {
    return mShow;
  }
}