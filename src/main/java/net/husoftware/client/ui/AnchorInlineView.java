package net.husoftware.client.ui;

import net.husoftware.client.model.AnchorInlineDisplay;

import org.gwtbootstrap3.client.ui.Anchor;
import org.gwtbootstrap3.client.ui.Tooltip;
import org.gwtbootstrap3.client.ui.constants.IconType;
import org.gwtbootstrap3.client.ui.constants.Placement;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.DoubleClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.Event;

public class AnchorInlineView extends AbstractView implements AnchorInlineDisplay
{
  private static final Binder BINDER = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, AnchorInlineView>
  {
  }

  @UiField
  Tooltip mTip;

  @UiField
  Anchor mAnchor;

  public AnchorInlineView()
  {
    initWidget(BINDER.createAndBindUi(this));
  }

  public AnchorInlineView(IconType inType, String inText)
  {
    this();
    setIcon(inType);
    setText(inText);
  }

  public Anchor getAnchor()
  {
    return mAnchor;
  }

  public Tooltip getTip()
  {
    return mTip;
  }

  public AnchorInlineView(IconType inType, String inText, String inStyle)
  {
    this();
    setIcon(inType);
    setText(inText);
    addStyleName(inStyle);
  }

  public AnchorInlineView(Anchor inAnchor, Tooltip inTip)
  {
    mAnchor = inAnchor;
    mTip = inTip;
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
  public void setIcon(IconType inIconType)
  {
    mAnchor.setIcon(inIconType);
  }

  @Override
  public IconType getIcon()
  {
    return mAnchor.getIcon();
  }

  @Override
  public void addStyleName(String inStyle)
  {
    mAnchor.addStyleName(inStyle);
  }

  @Override
  public void setText(String inText)
  {
    mAnchor.setText(inText);
  }

  @Override
  public void setEnabled(boolean inEnable)
  {
    mAnchor.setEnabled(inEnable);
  }

  @Override
  public void setShow(boolean inShow)
  {
    mAnchor.setVisible(inShow);
  }

  @Override
  public HandlerRegistration addClickHandler(ClickHandler inHandler)
  {
    return addClickHandler(mAnchor, inHandler);
  }

  @Override
  public HandlerRegistration setClickHandler(ClickHandler inHandler)
  {
    return setClickHandler(mAnchor, inHandler);
  }

  @Override
  public HandlerRegistration addDoubleClickHandler(DoubleClickHandler inHandler)
  {
    return addDoubleClickHandler(mAnchor, inHandler);
  }

  @Override
  public HandlerRegistration setDoubleClickHandler(DoubleClickHandler inHandler)
  {
    return setDoubleClickHandler(mAnchor, inHandler);
  }

  @Override
  public boolean isSource(Event<?> inEvent)
  {
    return inEvent.getSource() == mAnchor;
  }

  @Override
  public boolean isShowing()
  {
    return mAnchor.isVisible();
  }

  @Override
  public boolean isEnabled()
  {
    return mAnchor.isEnabled();
  }

  @Override
  public void setIconTip(IconType inType, String inTip)
  {
    setIcon(inType);
    setTip(inTip);
  }

  @Override
  public String getText()
  {
    return mAnchor.getText();
  }

  @Override
  public void setIconSpin(boolean inSpin)
  {
    mAnchor.setIconSpin(inSpin);
  }
}