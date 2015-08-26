package net.husoftware.client.model;

import org.gwtbootstrap3.client.ui.constants.IconType;
import org.gwtbootstrap3.client.ui.constants.Placement;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.IsWidget;

public interface AnchorListItemDisplay extends ButtonGroupItem, IsWidget
{
  String getProperty();

  void setProperty(String inProperty);

  boolean isProperty(String inProperty);

  IsWidget getAnchor();

  boolean isSource(ClickEvent inEvent);

  void setTip(String inTip);

  void setPlacement(Placement inPlacement);

  void setIcon(IconType inType);
}