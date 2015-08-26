package net.husoftware.client.ui;

import net.husoftware.client.model.TextBoxDisplay;

import org.gwtbootstrap3.client.ui.TextBox;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;

public class TextBoxView extends AbstractTextBox implements TextBoxDisplay
{
  private static final Binder BINDER = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, TextBoxView>
  {
  }

  @UiField
  TextBox mTextBox;

  public TextBoxView()
  {
    initWidget(BINDER.createAndBindUi(this));
    setTextBox(mTextBox);
  }

  public TextBox getTextBox()
  {
    return mTextBox;
  }
}