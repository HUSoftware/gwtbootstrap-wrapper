package net.husoftware.client.mock;

import java.util.ArrayList;
import java.util.List;

import net.husoftware.client.model.ButtonGroupDisplay;
import net.husoftware.client.model.ButtonGroupItem;

import org.gwtbootstrap3.client.ui.constants.ButtonSize;
import org.gwtbootstrap3.client.ui.constants.ButtonType;
import org.gwtbootstrap3.client.ui.constants.IconType;
import org.gwtbootstrap3.client.ui.constants.Placement;
import org.gwtbootstrap3.client.ui.constants.Toggle;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

public class MockButtonGroupDisplay extends MockDisplay implements ButtonGroupDisplay
{
  private String mText;
  private ButtonSize mSize;
  private ButtonType mType;
  private String mTitle;
  private boolean mDropup;
  private ClickHandler mHandler;
  private boolean mNoDrop;
  private boolean mSplit;
  private Toggle mDataToggle;
  private Placement mPlacement;
  private String mProperty;
  private IconType mIcon;
  private List<ButtonGroupItem> mItems;
  private boolean mSource;

  public MockButtonGroupDisplay()
  {
    mItems = new ArrayList<ButtonGroupItem>();
  }

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

  @Override
  public void setSize(ButtonSize inSize)
  {
    mSize = inSize;
  }

  public ButtonSize getSize()
  {
    return mSize;
  }

  @Override
  public void setType(ButtonType inType)
  {
    mType = inType;
  }

  public ButtonType getType()
  {
    return mType;
  }

  @Override
  public void setTip(String inTitle)
  {
    mTitle = inTitle;
  }

  public String getTip()
  {
    return mTitle;
  }

  @Override
  public void setDropup(boolean inDropup)
  {
    mDropup = inDropup;
  }

  public boolean isDropup()
  {
    return mDropup;
  }

  @Override
  public void addClickHandler(ClickHandler inHandler)
  {
    mHandler = inHandler;
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
  public MockAnchorListItemDisplay addItem(String inText, String inTip, ClickHandler inHandler)
  {
    MockAnchorListItemDisplay ret = new MockAnchorListItemDisplay(inText, inTip, inHandler);
    mItems.add(ret);
    return ret;
  }

  @Override
  public MockAnchorListItemDisplay addItem(String inText, String inTip, String inProperty,
      ClickHandler inHandler)
  {
    MockAnchorListItemDisplay ret =
        new MockAnchorListItemDisplay(inText, inTip, inProperty, inHandler);
    mItems.add(ret);
    return ret;
  }

  @Override
  public void setPlacement(Placement inPlacement)
  {
    mPlacement = inPlacement;
  }

  @Override
  public void setDataToggle(Toggle inToggle)
  {
    mDataToggle = inToggle;
  }

  @Override
  public boolean isItemProperty(ClickEvent inEvent, String inProperty)
  {
    return mProperty != null && mProperty.equals(inProperty);
  }

  @Override
  public List<ButtonGroupItem> getItems()
  {
    mItems.add(this);
    return mItems;
  }

  @Override
  public void setSplit(boolean inSplit)
  {
    mSplit = inSplit;
  }

  public boolean isSplit()
  {
    return mSplit;
  }

  public Toggle getDataToggle()
  {
    return mDataToggle;
  }

  public Placement getPlacement()
  {
    return mPlacement;
  }

  @Override
  public void setNoDrop(boolean inNoDrop)
  {
    mNoDrop = inNoDrop;
  }

  @Override
  public boolean isNoDrop()
  {
    return mNoDrop;
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
  public void setClickHandler(ClickHandler inHandler)
  {
    mHandler = inHandler;
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
  public boolean isProperty(ClickEvent inEvent, String inProperty)
  {
    return isProperty(inProperty);
  }

  @Override
  public String getProperty(ClickEvent inEvent)
  {
    return mProperty;
  }

  @Override
  public void setIcon(IconType inIcon)
  {
    mIcon = inIcon;
  }

  public IconType getIcon()
  {
    return mIcon;
  }

  @Override
  public void addDivider()
  {
  }

  @Override
  public String getProperty()
  {
    return mProperty;
  }
}