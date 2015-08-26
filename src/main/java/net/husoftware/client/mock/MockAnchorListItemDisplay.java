package net.husoftware.client.mock;

import net.husoftware.client.model.AnchorListItemDisplay;

import org.gwtbootstrap3.client.ui.constants.IconType;
import org.gwtbootstrap3.client.ui.constants.Placement;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.IsWidget;

public class MockAnchorListItemDisplay extends MockDisplay implements AnchorListItemDisplay
{
  private String mProperty;
  private ClickHandler mHandler;
  private String mText;
  private String mTip;
  private Placement mPlacement;
  private IconType mType;
  private boolean mSource;

  public MockAnchorListItemDisplay(String inText, ClickHandler inHandler)
  {
    mText = inText;
    mHandler = inHandler;
  }

  public MockAnchorListItemDisplay(String inText, String inTip, String inProperty,
      ClickHandler inHandler)
  {
    mText = inText;
    mTip = inTip;
    mProperty = inProperty;
    mHandler = inHandler;
  }

  public MockAnchorListItemDisplay(String inText, String inTip, ClickHandler inHandler)
  {
    mText = inText;
    mTip = inTip;
    mHandler = inHandler;
  }

  @Override
  public String getText()
  {
    return mText;
  }

  public String getTip()
  {
    return mTip;
  }

  @Override
  public void setText(String inText)
  {
    mText = inText;
  }

  public ClickHandler getHandler()
  {
    return mHandler;
  }

  public void click()
  {
    mHandler.onClick(null);
  }

  @Override
  public String getProperty()
  {
    return mProperty;
  }

  @Override
  public void setProperty(String inProperty)
  {
    mProperty = inProperty;
  }

  @Override
  public boolean isProperty(String inProperty)
  {
    return mProperty != null && mProperty.equals(inProperty);
  }

  @Override
  public IsWidget getAnchor()
  {
    return null;
  }

  @Override
  public boolean isSource(ClickEvent inEvent)
  {
    return mSource;
  }

  public void setSource(boolean inSource)
  {
    mSource = inSource;
  }

  @Override
  public void setTip(String inTip)
  {
    mTip = inTip;
  }

  @Override
  public void setPlacement(Placement inPlacement)
  {
    mPlacement = inPlacement;
  }

  public Placement getPlacement()
  {
    return mPlacement;
  }

  @Override
  public void setIcon(IconType inType)
  {
    mType = inType;
  }

  public IconType getType()
  {
    return mType;
  }

  @Override
  public String getProperty(ClickEvent inEvent)
  {
    return mProperty;
  }
}