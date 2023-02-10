package com.mathewdenison.thrillio.controllers;

import com.mathewdenison.thrillio.entities.Bookmark;
import com.mathewdenison.thrillio.entities.User;
import com.mathewdenison.thrillio.managers.BookmarkManager;

public class BookmarkController {
    private static BookmarkController instance = new BookmarkController();
    private BookmarkController() {}
    public static BookmarkController getInstance() {
        return instance;
    }

    public void saveUserBookmark(User user, Bookmark bookmark) {
        BookmarkManager.getInstance().saveUserBookmark(user, bookmark);
    }
}
