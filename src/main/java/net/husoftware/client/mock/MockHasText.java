package net.husoftware.client.mock;

import com.google.gwt.user.client.ui.HasText;

public class MockHasText implements HasText
{
  private String mText;

  @Override
  public String getText()
  {
    return mText;
  }

  @Override
  public void setText(String inText)
  {
    mText = inText;
  }
}