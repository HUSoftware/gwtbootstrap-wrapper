package net.husoftware.client.mock;

import net.husoftware.client.model.ButtonDisplay;

import org.gwtbootstrap3.client.ui.constants.ButtonSize;
import org.gwtbootstrap3.client.ui.constants.ButtonType;

public class MockButtonDisplay extends MockIconDisplay implements ButtonDisplay
{
  private String mLoadingText;
  private ButtonSize mSize;
  private ButtonType mType;
  // private BlurHandler mBlurHandler;
  // private FocusHandler mFocusHandler;
  private boolean mBlock;
  private boolean mToggle;
  private boolean mToggled;

  @Override
  public void setLoadingText(String inLoadingText)
  {
    mLoadingText = inLoadingText;
  }

  public String getLoadingText()
  {
    return mLoadingText;
  }

  @Override
  public ButtonSize getSize()
  {
    return mSize;
  }

  @Override
  public void setSize(ButtonSize inSize)
  {
    mSize = inSize;
  }

  @Override
  public ButtonType getType()
  {
    return mType;
  }

  @Override
  public void setType(ButtonType inType)
  {
    mType = inType;
  }

  // @Override
  // public HandlerRegistration addFocusHandler(FocusHandler inHandler)
  // {
  // mFocusHandler = inHandler;
  // return new MockHandlerRegistration(mFocusHandler);
  // }
  //
  // @Override
  // public HandlerRegistration addBlurHandler(BlurHandler inHandler)
  // {
  // mBlurHandler = inHandler;
  // return new MockHandlerRegistration(mBlurHandler);
  // }

  @Override
  public void setBlock(boolean inBlock)
  {
    mBlock = inBlock;
  }

  public boolean isBlock()
  {
    return mBlock;
  }

  @Override
  public void setToggle(boolean inToggle)
  {
    mToggle = inToggle;
  }

  public boolean isToggle()
  {
    return mToggle;
  }

  @Override
  public boolean isToggled()
  {
    return mToggled;
  }

  public void setToggled(boolean inToggled)
  {
    mToggled = inToggled;
  }

  @Override
  public void initElementId()
  {
  }
}