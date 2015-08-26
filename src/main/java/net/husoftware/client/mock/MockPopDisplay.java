package net.husoftware.client.mock;

import net.husoftware.client.model.PopDisplay;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

public class MockPopDisplay implements PopDisplay
{
  private boolean mShowing;
  private String mWidth;
  private String mHeight;
  private final MockButtonDisplay mSave;
  private final MockButtonDisplay mClose;
  private final MockHasText mHeader;
  private final MockHasWidgets mBody;

  public MockPopDisplay()
  {
    mSave = new MockButtonDisplay();
    mClose = new MockButtonDisplay();
    mHeader = new MockHasText();
    mBody = new MockHasWidgets();
  }

  @Override
  public Widget asWidget()
  {
    return null;
  }

  @Override
  public MockHasText getHeader()
  {
    return mHeader;
  }

  @Override
  public void addBody(IsWidget inIsWidget)
  {
    mBody.add(inIsWidget);

  }

  @Override
  public void setShow(boolean inShow)
  {
    mShowing = inShow;
  }

  @Override
  public boolean isShowing()
  {
    return mShowing;
  }

  @Override
  public MockButtonDisplay getSave()
  {
    return mSave;
  }

  @Override
  public MockButtonDisplay getClose()
  {
    return mClose;
  }

  @Override
  public void setHeight(String inHeight)
  {
    mHeight = inHeight;
  }

  public String getHeight()
  {
    return mHeight;
  }

  @Override
  public void setWidth(String inWidth)
  {
    mWidth = inWidth;
  }

  public String getWidth()
  {
    return mWidth;
  }

  @Override
  public void addStyleName(String inStyleName)
  {
  }
}