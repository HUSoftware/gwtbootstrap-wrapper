package net.husoftware.client.model;

import com.google.web.bindery.event.shared.Event;

public interface HasSource
{
  boolean isSource(Event<?> inEvent);

  Object getSource(Event<?> inEvent);
}