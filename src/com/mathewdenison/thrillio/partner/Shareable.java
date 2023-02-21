package com.mathewdenison.thrillio.partner;

/**
 * Interface that when interfaced allows for ability to share data to third party site. Only
 * accessible by Book and
 * Weblink classes.
 */
public interface Shareable {
  String getItemData();
}
