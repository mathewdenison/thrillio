package com.mathewdenison.thrillio.dao;

import com.mathewdenison.thrillio.DataStore;
import com.mathewdenison.thrillio.entities.Bookmark;
import com.mathewdenison.thrillio.entities.UserBookmark;

/**
 * Dao class to add bookmarks to database.
 */
public class BookmarkDao {
  public Bookmark[][] getBookmarks() {
    return DataStore.getBookmarks();
  }

  public void saveUserBookmark(UserBookmark userBookmark) {
    DataStore.add(userBookmark);
  }
}
