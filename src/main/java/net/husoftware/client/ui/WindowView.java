package net.husoftware.client.ui;

import net.husoftware.client.model.WindowDisplay;

import com.google.gwt.core.client.JavaScriptObject;

public class WindowView extends JavaScriptObject implements WindowDisplay
{
  protected WindowView()
  {
  }

  public static native WindowView open(String inTarget, String inOptions)
  /*-{
		var ret = $wnd.open("", inTarget, inOptions);
		ret.focus(inTarget);
		return ret;
  }-*/;

  @Override
  public final native void close()
  /*-{
		this.close();
  }-*/;

  @Override
  public final native void setUrl(String inUrl)
  /*-{
		if (this.location) {
			this.location = inUrl;
		}
  }-*/;
}