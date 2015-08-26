package net.husoftware.client.mock;

import com.google.gwt.user.client.ui.HasVisibility;

public class MockHasVisibility implements HasVisibility
{
  private boolean mVisible;

  @Override
  public boolean isVisible()
  {
    return mVisible;
  }

  @Override
  public void setVisible(boolean inVisible)
  {
    mVisible = inVisible;
  }
}