package com.mathewdenison.thrillio;

import com.mathewdenison.thrillio.constants.KidFriendlyStatus;
import com.mathewdenison.thrillio.constants.UserType;
import com.mathewdenison.thrillio.controllers.BookmarkController;
import com.mathewdenison.thrillio.entities.Bookmark;
import com.mathewdenison.thrillio.entities.User;
import com.mathewdenison.thrillio.partner.Shareable;

/**
 * Temporary class to mimic interaction of the application by a user.
 */
public class View {

  /**
   * Method to simulate the browsing of bookmarks on a site from randomization.
   *
   * @param user The passed user object
   * @param bookmarks The passed bookmarks
   */
  public static void browse(User user, Bookmark[][] bookmarks) {
    System.out.println("\n" + user.getEmail() + " is browsing items...");
    int bookmarkCount = 0;

    for (Bookmark[] bookmarkList : bookmarks) {
      for (Bookmark bookmark : bookmarkList) {
        // Bookmarking
        if (bookmarkCount < DataStore.USER_BOOKMARK_LIMIT) {
          boolean isBookmarked = getBookmarkDecision(bookmark);
          if (isBookmarked) {
            bookmarkCount++;

            BookmarkController.getInstance().saveUserBookmark(user, bookmark);

            System.out.println("New Item Bookmarked -- " + bookmark);
          }
        }

        //Marking kid friendly
        if (user.getUserType().equals(UserType.EDITOR)
            || user.getUserType().equals(UserType.CHIEFEDITOR)) {

          //Mark as kid-friendly
          if (bookmark.isKidFriendlyEligible()
              && bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.UNKNOWN)) {
            String kidFriendlyStatus = getKidFriendlyStatusDecision(bookmark);
            if (!kidFriendlyStatus.equals(KidFriendlyStatus.UNKNOWN)) {
              BookmarkController.getInstance()
                  .setKidFriendlyStatus(user, kidFriendlyStatus, bookmark);
            }
          }

          // Sharing
          if (bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.APPROVED)
              && bookmark instanceof Shareable) {
            boolean isShared = getShareDecision();
            if (isShared) {
              BookmarkController.getInstance().share(user, bookmark);
            }
          }
        }
      }
    }
  }

  //TODO: Below methods simulate user input. After IO, we take input via console.
  private static boolean getShareDecision() {
    return (Math.random() >= 0.5);
  }

  private static String getKidFriendlyStatusDecision(Bookmark bookmark) {
    double randomVal = Math.random();

    return randomVal < 0.4 ? KidFriendlyStatus.APPROVED :
        (randomVal >= 0.5 && randomVal < 0.8) ? KidFriendlyStatus.REJECTED
            : KidFriendlyStatus.UNKNOWN;
  }

  private static boolean getBookmarkDecision(Bookmark bookmark) {
    return (Math.random() >= 0.5);
  }

  /*public static void bookmark(User user, Bookmark[][] bookmarks) {
      System.out.println("\n" + user.getEmail() + " is bookmarking");
      for(int i = 0; i < DataStore.USER_BOOKMARK_LIMIT; i++) {
          int typeOffset = (int) (Math.random() * DataStore.BOOKMARK_TYPES_COUNT);
          int bookmarkOffset = (int) (Math.random() * DataStore.BOOKMARK_COUNT_PER_TYPE);

          Bookmark bookmark = bookmarks[typeOffset][bookmarkOffset];

          BookmarkController.getInstance().saveUserBookmark(user, bookmark);

          System.out.println(bookmark);
      }
  }*/
}
