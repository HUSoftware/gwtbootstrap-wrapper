package net.husoftware.client.mock;

import net.husoftware.client.model.AnchorInlineDisplay;

import org.gwtbootstrap3.client.ui.constants.Placement;

public class MockAnchorInlineDisplay extends MockIconDisplay implements AnchorInlineDisplay
{
  private Placement mPlacement;

  @Override
  public void setPlacement(Placement inPlacement)
  {
    mPlacement = inPlacement;
  }

  public Placement getPlacement()
  {
    return mPlacement;
  }
}
