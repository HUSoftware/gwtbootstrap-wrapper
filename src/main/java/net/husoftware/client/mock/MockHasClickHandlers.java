package net.husoftware.client.mock;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;

public class MockHasClickHandlers implements HasClickHandlers
{
  private final List<ClickHandler> mClickHandlers = new ArrayList<ClickHandler>();

  @Override
  public void fireEvent(GwtEvent<?> inEvent)
  {
  }

  @Override
  public HandlerRegistration addClickHandler(final ClickHandler inHandler)
  {
    mClickHandlers.add(inHandler);
    return new HandlerRegistration()
    {
      @Override
      public void removeHandler()
      {
        mClickHandlers.remove(inHandler);
      }
    };
  }

}
