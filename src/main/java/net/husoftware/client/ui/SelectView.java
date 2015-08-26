package net.husoftware.client.ui;

import org.gwtbootstrap3.extras.select.client.ui.Select;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;

public class SelectView extends AbstractView
{
  private static final Binder BINDER = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, SelectView>
  {
  }

  @UiField
  Select mSelect;

  public SelectView()
  {
    initWidget(BINDER.createAndBindUi(this));

    mSelect.addChangeHandler(new ChangeHandler()
    {
      @Override
      public void onChange(ChangeEvent inEvent)
      {
        // Element e = getElement();

        int count = mSelect.getWidgetCount();
        for (int i = 0; i < count; i++)
        {
          Widget wid = mSelect.getWidget(i);
          System.out.println(wid.getClass().getSimpleName());
        }
      }
    });

    // mSelect.render();
    // setElementId(mButton.getElement());
  }

}