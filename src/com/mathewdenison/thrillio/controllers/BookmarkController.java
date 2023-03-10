package com.mathewdenison.thrillio.controllers;

import com.mathewdenison.thrillio.entities.Bookmark;
import com.mathewdenison.thrillio.entities.User;
import com.mathewdenison.thrillio.managers.BookmarkManager;

/**
 * Controller class to pass bookmarks to manager class.
 */
public class BookmarkController {
  private static final BookmarkController instance = new BookmarkController();

  private BookmarkController() {}

  public static BookmarkController getInstance() {
    return instance;
  }

  public void saveUserBookmark(User user, Bookmark bookmark) {
    BookmarkManager.getInstance().saveUserBookmark(user, bookmark);
  }

  public void setKidFriendlyStatus(User user, String kidFriendlyStatus, Bookmark bookmark) {
    BookmarkManager.getInstance().setKidFriendlyStatus(user, kidFriendlyStatus, bookmark);
  }

  public void share(User user, Bookmark bookmark) {
    BookmarkManager.getInstance().share(user, bookmark);
  }
}
