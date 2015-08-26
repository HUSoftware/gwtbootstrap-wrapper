package net.husoftware.client.mock;

import net.husoftware.client.model.NavTabDisplay;
import net.husoftware.client.model.TabDisplay;

import com.google.gwt.user.client.ui.Widget;

public class MockNavTabDisplay implements NavTabDisplay
{
  private String mStyle;
  private final MockTabDisplay mTab1;
  private final TabDisplay mTab2;
  private final TabDisplay mTab3;
  private final TabDisplay mTab4;
  private final TabDisplay mTab5;
  private final MockHasWidgets mLeft;
  private final MockHasWidgets mRight;
  private boolean mNavVisible;

  public MockNavTabDisplay()
  {
    mTab1 = new MockTabDisplay();
    mTab2 = new MockTabDisplay();
    mTab3 = new MockTabDisplay();
    mTab4 = new MockTabDisplay();
    mTab5 = new MockTabDisplay();
    mLeft = new MockHasWidgets();
    mRight = new MockHasWidgets();
  }

  @Override
  public Widget asWidget()
  {
    return null;
  }

  @Override
  public void setStyle(String inStyle)
  {
    mStyle = inStyle;
  }

  public String getStyle()
  {
    return mStyle;
  }

  @Override
  public MockTabDisplay getTab1()
  {
    return mTab1;
  }

  @Override
  public TabDisplay getTab2()
  {
    return mTab2;
  }

  @Override
  public TabDisplay getTab3()
  {
    return mTab3;
  }

  @Override
  public TabDisplay getTab4()
  {
    return mTab4;
  }

  @Override
  public TabDisplay getTab5()
  {
    return mTab5;
  }

  @Override
  public MockHasWidgets getLeft()
  {
    return mLeft;
  }

  @Override
  public MockHasWidgets getRight()
  {
    return mRight;
  }

  @Override
  public void addStyleName(String inStyle)
  {
    mStyle += " " + inStyle;
  }

  @Override
  public void setNavVisible(boolean inVisible)
  {
    mNavVisible = inVisible;
  }

  public boolean isNavVisible()
  {
    return mNavVisible;
  }
}