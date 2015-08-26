package net.husoftware.client.model;

import java.util.Date;

import com.google.gwt.event.dom.client.HumanInputEvent;
import com.google.gwt.event.dom.client.KeyCodeEvent;
import com.google.gwt.user.client.ui.HasVisibility;
import com.google.gwt.user.client.ui.IsWidget;

public interface Display extends IsWidget, HasVisibility
{
  void alert(String inMessage);

  boolean confirm(String inMessage);

  String format(String inPattern, Date inDate);

  Date parse(String inPattern, String inDate);

  PopDisplay newPop();

  boolean isShiftKeyDown(HumanInputEvent<?> inEvent);

  boolean isAltKeyDown(HumanInputEvent<?> inEvent);

  boolean isKeyEnter(KeyCodeEvent<?> inEvent);

  boolean isKeyDelete(KeyCodeEvent<?> inEvent);

  boolean isKeyTab(KeyCodeEvent<?> inEvent);

  boolean isShiftKeyDown(KeyCodeEvent<?> inEvent);
}