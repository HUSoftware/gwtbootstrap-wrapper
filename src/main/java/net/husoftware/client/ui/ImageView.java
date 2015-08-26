package net.husoftware.client.ui;

import net.husoftware.client.model.ImageDisplay;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.Event;

public class ImageView extends Composite implements ImageDisplay
{
  private static final Binder BINDER = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, ImageView>
  {
  }

  @UiField
  Image mImage;

  HandlerRegistration mHandlerRegistration;

  public ImageView()
  {
    initWidget(BINDER.createAndBindUi(this));
  }

  public ImageView(ImageResource inResource)
  {
    this();
    setResource(inResource);
  }

  public Image getImage()
  {
    return mImage;
  }

  @Override
  public void setShow(boolean inShow)
  {
    setVisible(inShow);
    mImage.setVisible(inShow);
  }

  @Override
  public void setResource(ImageResource inResource)
  {
    mImage.setResource(inResource);
  }

  @Override
  protected void onUnload()
  {
    super.onUnload();
    if (mHandlerRegistration != null)
    {
      mHandlerRegistration.removeHandler();
    }
  }

  @Override
  public boolean isSource(Event<?> inEvent)
  {
    return mImage.equals(inEvent.getSource());
  }

  @Override
  public HandlerRegistration addClickHandler(ClickHandler inHandler)
  {
    return mImage.addClickHandler(inHandler);
  }

  public boolean isShowing()
  {
    return mImage.isVisible();
  }
}