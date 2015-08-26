package net.husoftware.client.resource;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

public interface Resource extends ClientBundle
{
  @CssResource.NotStrict
  @Source("Site.css")
  SiteCss css();
}