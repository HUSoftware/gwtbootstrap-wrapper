package net.husoftware.client.mock;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

public class MockHasWidgets implements HasWidgets.ForIsWidget
{
  List<Widget> mHasWidgets = new ArrayList<Widget>();

  @Override
  public void add(Widget inW)
  {
    mHasWidgets.add(inW);
  }

  @Override
  public void clear()
  {
    mHasWidgets.clear();
  }

  @Override
  public Iterator<Widget> iterator()
  {
    return mHasWidgets.iterator();
  }

  @Override
  public boolean remove(Widget inW)
  {
    return mHasWidgets.remove(inW);
  }

  @Override
  public void add(IsWidget inW)
  {
    // mHasWidgets.add(inW);
  }

  @Override
  public boolean remove(IsWidget inW)
  {
    return true; // mHasWidgets.remove(inW.asWidget());
  }
}