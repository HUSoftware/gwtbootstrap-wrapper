package net.husoftware.client.mock;

import net.husoftware.client.model.TextAreaDisplay;

public class MockTextAreaDisplay extends MockTextBoxDisplay implements TextAreaDisplay
{
  private int mVisibleLines;
  private boolean mElastic;
  private Resize mResize;

  public MockTextAreaDisplay()
  {
    super();
  }

  public MockTextAreaDisplay(String inDefaultValue)
  {
    super(inDefaultValue);
  }

  @Override
  public void setVisibleLines(int inLines)
  {
    mVisibleLines = inLines;
  }

  public int getVisibleLines()
  {
    return mVisibleLines;
  }

  @Override
  public void elastic()
  {
    mElastic = true;
  }

  public boolean isElastic()
  {
    return mElastic;
  }

  @Override
  public void elastic(int inDelay)
  {
    mElastic = true;
  }

  @Override
  public void setResize(Resize inResize)
  {
    mResize = inResize;
  }

  public Resize getResize()
  {
    return mResize;
  }
}