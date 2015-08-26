package net.husoftware.client.mock;

import com.google.gwt.user.client.ui.HasHTML;

public class MockHasHTML extends MockHasText implements HasHTML
{
  @Override
  public String getHTML()
  {
    return getText();
  }

  @Override
  public void setHTML(String inHtml)
  {
    setText(inHtml);
  }
}