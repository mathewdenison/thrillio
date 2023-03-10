package com.mathewdenison.thrillio.entities;

import com.mathewdenison.thrillio.partner.Shareable;

/**
 * Class to enable methods of Weblink to then get passed to storage as well as pass data to
 * third party site through use of Shareable interface.
 */

public class WebLink extends Bookmark implements Shareable {
  private String url;
  private String host;

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }

  @Override
  public String toString() {
    return "WebLink{"
        + "url='"
        + url
        + '\''
        + ", host='"
        + host
        + '\''
        + '}';
  }

  @Override
  public String getItemData() {
    StringBuilder builder = new StringBuilder();
    builder.append("<item>");
    builder.append("<type>WebLink</type");
    builder.append("<title>").append(getTitle()).append("</title>");
    builder.append("<url>").append(url).append("</url>");
    builder.append("<host>").append(host).append("</host>");
    builder.append("</item>");
    return builder.toString();
  }

  @Override
  public boolean isKidFriendlyEligible() {
    return (!(url.contains("porn") || getTitle().contains("porn")
        || host.contains("adult")));
  }
}
