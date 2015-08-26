package net.husoftware.client.ui;

import java.util.ArrayList;
import java.util.List;

import net.husoftware.client.model.AnchorListItemDisplay;
import net.husoftware.client.model.ButtonGroupDisplay;
import net.husoftware.client.model.ButtonGroupItem;

import org.gwtbootstrap3.client.ui.Anchor;
import org.gwtbootstrap3.client.ui.AnchorListItem;
import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.ButtonGroup;
import org.gwtbootstrap3.client.ui.Divider;
import org.gwtbootstrap3.client.ui.DropDownMenu;
import org.gwtbootstrap3.client.ui.Tooltip;
import org.gwtbootstrap3.client.ui.constants.ButtonSize;
import org.gwtbootstrap3.client.ui.constants.ButtonType;
import org.gwtbootstrap3.client.ui.constants.IconType;
import org.gwtbootstrap3.client.ui.constants.Placement;
import org.gwtbootstrap3.client.ui.constants.Toggle;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;

public class ButtonGroupView extends AbstractView implements ButtonGroupDisplay
{
  private static final Binder BINDER = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, ButtonGroupView>
  {
  }

  @UiField
  ButtonGroup mGroup;

  @UiField
  Button mButton, mDrop;

  @UiField
  DropDownMenu mMenu;

  @UiField
  Tooltip mTip;

  boolean mSplit, mNoDrop;

  String mProperty;

  HandlerRegistration mButtonHandlerRegistration;

  public ButtonGroupView()
  {
    initWidget(BINDER.createAndBindUi(this));
  }

  @Override
  public void addClickHandler(ClickHandler inHandler)
  {
    if (inHandler != null)
    {
      add(mButton.addClickHandler(inHandler));
    }
  }

  @Override
  public void setClickHandler(ClickHandler inHandler)
  {
    if (mButtonHandlerRegistration != null)
    {
      mButtonHandlerRegistration.removeHandler();
    }
    if (inHandler != null)
    {
      mButtonHandlerRegistration = add(mButton.addClickHandler(inHandler));
    }
  }

  @Override
  public void setWidth(String inWidth)
  {
    if (inWidth != null)
    {
      super.setWidth(inWidth);
      mButton.setWidth(inWidth);
    }
  }

  @Override
  public void setDataToggle(Toggle inToggle)
  {
    mButton.setDataToggle(inToggle);
  }

  @Override
  public void setTip(String inTip)
  {
    mTip.setTitle(inTip);
    mTip.reconfigure();
  }

  @Override
  public void setSplit(boolean inSplit)
  {
    mSplit = inSplit;
    mButton.setDataToggle(mSplit ? null : Toggle.DROPDOWN);
    mDrop.setVisible(mSplit);
  }

  @Override
  public void setNoDrop(boolean inNoDrop)
  {
    mNoDrop = inNoDrop;
    if (mNoDrop)
    {
      mButton.setDataToggle(null);
      mDrop.setVisible(false);
    }
    else
    {
      setSplit(mSplit);
    }
  }

  @Override
  public boolean isNoDrop()
  {
    return mNoDrop;
  }

  @Override
  public boolean isSource(ClickEvent inEvent)
  {
    return inEvent.getSource().equals(mButton);
  }

  @Override
  public void setProperty(String inProperty)
  {
    mProperty = inProperty;
  }

  @Override
  public String getProperty()
  {
    return mProperty;
  }

  @Override
  public boolean isProperty(String inProperty)
  {
    return mProperty != null && mProperty.equals(inProperty);
  }

  @Override
  public boolean isProperty(ClickEvent inEvent, String inProperty)
  {
    boolean ret = false;
    Widget source = ((Widget) inEvent.getSource()).getParent().getParent();
    if (source instanceof ButtonGroupView)
    {
      ret = ((ButtonGroupView) source).isProperty(inProperty);
    }
    return ret;
  }

  @Override
  public String getProperty(ClickEvent inEvent)
  {
    return getButtonProperty(inEvent);
  }

  public static String getButtonProperty(ClickEvent inEvent)
  {
    String ret = null;
    Widget source = ((Widget) inEvent.getSource()).getParent();
    if (source instanceof Item)
    {
      ret = ((Item) source).getProperty();
    }
    else
    {
      source = source.getParent();
      if (source instanceof ButtonGroupView)
      {
        ret = ((ButtonGroupView) source).getProperty();
      }
    }
    return ret;
  }

  @Override
  public void setPlacement(Placement inPlacement)
  {
    mTip.setPlacement(inPlacement);
    mTip.reconfigure();
  }

  @Override
  public void setEnabled(boolean inEnabled)
  {
    mButton.setEnabled(inEnabled);
  }

  @Override
  public boolean isEnabled()
  {
    return mButton.isEnabled();
  }

  @Override
  public String getText()
  {
    return mButton.getText();
  }

  @Override
  public void setText(String inText)
  {
    mButton.setText(inText);
  }

  @Override
  public AnchorListItemDisplay addItem(String inText, String inTip, ClickHandler inHander)
  {
    Item ret = new Item(inText);
    menuAdd(ret, inTip, inHander);
    return ret;
  }

  @Override
  public AnchorListItemDisplay addItem(String inText, String inTip, String inProperty,
      ClickHandler inHander)
  {
    Item ret = new Item(inText);
    ret.setProperty(inProperty);
    menuAdd(ret, inTip, inHander);
    return ret;
  }

  private void menuAdd(Item inItem, String inTip, ClickHandler inHander)
  {
    if (inHander != null)
    {
      add(inItem.addClickHandler(inHander));
    }
    mMenu.add(inItem.setUpTip(inTip));
  }

  @Override
  public List<ButtonGroupItem> getItems()
  {
    List<ButtonGroupItem> ret = new ArrayList<>();
    ret.add(this);
    for (int i = 0; i < mMenu.getWidgetCount(); i++)
    {
      Widget widget = mMenu.getWidget(i);
      if (widget instanceof AnchorListItemDisplay)
      {
        ret.add((AnchorListItemDisplay) widget);
      }
    }
    return ret;
  }

  @Override
  public void addDivider()
  {
    mMenu.add(new Divider());
  }

  public DropDownMenu getMenu()
  {
    return mMenu;
  }

  @Override
  public void setSize(ButtonSize inSize)
  {
    mButton.setSize(inSize);
    mDrop.setSize(inSize);
  }

  @Override
  public void setType(ButtonType inType)
  {
    mButton.setType(inType);
    mDrop.setType(inType);
  }

  @Override
  public void setIcon(IconType inIcon)
  {
    mButton.setIcon(inIcon);
  }

  @Override
  public void setDropup(boolean inDropup)
  {
    mGroup.setDropUp(inDropup);
  }

  @Override
  public boolean isItemProperty(ClickEvent inEvent, String inItemProperty)
  {
    boolean ret = false;
    Widget source = ((Widget) inEvent.getSource()).getParent();
    if (source instanceof Item)
    {
      ret = ((Item) source).isProperty(inItemProperty);
    }
    return ret;
  }

  private static class Item extends AnchorListItem implements AnchorListItemDisplay
  {
    private String mProperty;

    private Tooltip mTip;

    public Item(String inText)
    {
      super(inText);
    }

    public Widget setUpTip(String inTip)
    {
      mTip = new Tooltip(this);
      mTip.setTitle(inTip);
      return mTip.asWidget();
    }

    @Override
    public void setTip(String inTip)
    {
      mTip.setTitle(inTip);
      mTip.reconfigure();
    }

    @Override
    public void setPlacement(Placement inPlacement)
    {
      mTip.setPlacement(inPlacement);
      mTip.reconfigure();
    }

    @Override
    public Anchor getAnchor()
    {
      return (Anchor) getChildren().get(0);
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
    public boolean isSource(ClickEvent inEvent)
    {
      return inEvent.getSource().equals(getAnchor());
    }

    @Override
    public boolean isProperty(String inProperty)
    {
      return mProperty != null && mProperty.equals(inProperty);
    }

    @Override
    public String getProperty(ClickEvent inEvent)
    {
      return getButtonProperty(inEvent);
    }
  }
}