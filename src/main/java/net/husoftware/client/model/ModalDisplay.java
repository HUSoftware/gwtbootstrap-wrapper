package net.husoftware.client.model;

import com.google.gwt.user.client.ui.IsWidget;

public interface ModalDisplay extends PopDisplay
{
  void addFooter(IsWidget inWidget);

  // void addHideHandler(HideHandler inHandler);
  //
  // void addShowHandler(ShowHandler inHandler);

  void setCloseVisible(boolean inShow);
}