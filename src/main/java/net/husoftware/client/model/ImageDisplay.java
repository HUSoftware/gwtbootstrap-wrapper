package net.husoftware.client.model;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.web.bindery.event.shared.Event;

public interface ImageDisplay extends IsWidget
{
  HandlerRegistration addClickHandler(ClickHandler inHandler);

  boolean isSource(Event<?> inEvent);

  void setResource(ImageResource inResource);

  void setShow(boolean inShow);

  boolean isShowing();
}