package net.husoftware.client.mock;

import java.util.ArrayList;
import java.util.List;

import net.husoftware.client.model.TabDisplay;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.IsWidget;

public class MockTabDisplay implements TabDisplay
{
  private boolean mShowing;
  private IsWidget mWidget;
  private String mLabel;
  private final List<ClickHandler> mClickHandlers;

  public MockTabDisplay()
  {
    mClickHandlers = new ArrayList<ClickHandler>();
  }

  @Override
  public void setWidget(IsWidget inWidget)
  {
    mWidget = inWidget;
  }

  @Override
  public void addClickHandler(ClickHandler inHandler)
  {
    mClickHandlers.add(inHandler);
  }

  public List<ClickHandler> getClickHandlers()
  {
    return mClickHandlers;
  }

  public void click()
  {
    click(0);
  }

  public void click(int inPos)
  {
    mClickHandlers.get(inPos).onClick(null);
  }

  @Override
  public void setLabel(String inLabel)
  {
    mLabel = inLabel;
  }

  @Override
  public void set(String inLabel, IsWidget inWidget)
  {
    mLabel = inLabel;
    mWidget = inWidget;
  }

  public String getLabel()
  {
    return mLabel;
  }

  public IsWidget getWidget()
  {
    return mWidget;
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
  public void active()
  {
    setShow(true);
  }
}