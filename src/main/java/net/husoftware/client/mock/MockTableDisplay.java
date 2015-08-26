package net.husoftware.client.mock;

import net.husoftware.client.model.CallBack;
import net.husoftware.client.model.TableDisplay;

import com.google.gwt.user.client.ui.HTMLTable.RowFormatter;
import com.google.gwt.user.client.ui.IsWidget;

public class MockTableDisplay extends MockDisplay implements TableDisplay
{
  private boolean mSortable;
  private CallBack<Void> mSortedCallBack;
  private int mCalledSortable;

  @Override
  public void addColHead(String inLabel, String inStyle)
  {
  }

  @Override
  public void addColHead(String inLabel)
  {
  }

  @Override
  public void setRowSpan(int inRow, int inCol, int inRowSpan)
  {
  }

  @Override
  public void setColSpan(int inRow, int inCol, int inColSpan)
  {
  }

  @Override
  public RowFormatter getRowFormatter()
  {
    return null;
  }

  @Override
  public void setWidget(IsWidget inWidget)
  {
  }

  @Override
  public void setWidget(int inCol, IsWidget inWidget)
  {
  }

  @Override
  public void setWidget(int inRow, int inCol, IsWidget inWidget)
  {
  }

  @Override
  public void setStyle(String inStyle)
  {
  }

  @Override
  public int getRowCount()
  {
    return 0;
  }

  @Override
  public int getCellCount(int inRow)
  {
    return 0;
  }

  @Override
  public void removeCell(int inRow, int inCol)
  {
  }

  @Override
  public void removeRow(int inRow)
  {
  }

  @Override
  public void remove(IsWidget inWidget)
  {
  }

  @Override
  public void remove(IsWidget inWidget, boolean inRemoveRow)
  {
  }

  @Override
  public int[] index(IsWidget inWidget)
  {
    return null;
  }

  @Override
  public void add(IsWidget inWidget)
  {
  }

  @Override
  public void clear()
  {
  }

  @Override
  public void setColHeadStyle(String inStyle, int inCol)
  {
  }

  @Override
  public void setColHead(String inLabel, int inCol)
  {
  }

  @Override
  public void setSortedCallBack(CallBack<Void> inCallBack)
  {
    mSortedCallBack = inCallBack;
  }

  public CallBack<Void> getSortedCallBack()
  {
    return mSortedCallBack;
  }

  @Override
  public void setSortable(boolean inSortable)
  {
    mCalledSortable++;
    mSortable = inSortable;
  }

  public int getCalledSortable()
  {
    return mCalledSortable;
  }

  @Override
  public boolean isSortable()
  {
    return mSortable;
  }
}