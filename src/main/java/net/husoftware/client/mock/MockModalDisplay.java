package net.husoftware.client.mock;

import java.util.ArrayList;
import java.util.List;

import net.husoftware.client.model.ModalDisplay;

import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

public class MockModalDisplay implements ModalDisplay
{
  private boolean mShowing;
  private String mHeight;
  private String mWidth;
  private final List<IsWidget> mFooter;
  private final List<IsWidget> mBody;
  private boolean mCloseVisible;
  private final MockButtonDisplay mClose;
  private final MockButtonDisplay mSave;
  private final MockHasText mHeader;

  public MockModalDisplay()
  {
    mFooter = new ArrayList<IsWidget>();
    mBody = new ArrayList<IsWidget>();
    mSave = new MockButtonDisplay();
    mClose = new MockButtonDisplay();
    mHeader = new MockHasText();
  }

  @Override
  public Widget asWidget()
  {
    return null;
  }

  @Override
  public boolean isShowing()
  {
    return mShowing;
  }

  @Override
  public void setShow(boolean inShow)
  {
    mShowing = inShow;
  }

  @Override
  public HasText getHeader()
  {
    return mHeader;
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
  public void setHeight(String inHeight)
  {
    mHeight = inHeight;
  }

  public String getHeight()
  {
    return mHeight;
  }

  @Override
  public void addBody(IsWidget inWidget)
  {
    mBody.add(inWidget);
  }

  public List<IsWidget> getBody()
  {
    return mBody;
  }

  @Override
  public void addFooter(IsWidget inWidget)
  {
    mFooter.add(inWidget);
  }

  public List<IsWidget> getFooter()
  {
    return mFooter;
  }

  @Override
  public void setCloseVisible(boolean inShow)
  {
    mCloseVisible = inShow;
  }

  public boolean isCloseVisible()
  {
    return mCloseVisible;
  }

  @Override
  public MockButtonDisplay getClose()
  {
    return mClose;
  }

  @Override
  public MockButtonDisplay getSave()
  {
    return mSave;
  }

  @Override
  public void addStyleName(String inStyleName)
  {
  }
}