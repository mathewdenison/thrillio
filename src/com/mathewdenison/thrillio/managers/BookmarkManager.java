package com.mathewdenison.thrillio.managers;

import com.mathewdenison.thrillio.dao.BookmarkDao;
import com.mathewdenison.thrillio.entities.*;

/**
 * Class to enable methods of BookmarkManager such as creation of books, weblinks, movies,
 * pulling data from storage
 * (via the controller class), setting kidFriendlyStatus, and sharing the bookmark to third party
 * sites.
 */
public class BookmarkManager {
  private static final BookmarkManager instance = new BookmarkManager();
  private static final BookmarkDao dao = new BookmarkDao();

  private BookmarkManager() {
  }

  public static BookmarkManager getInstance() {
    return instance;
  }

  /**
   * Method to create a weblink via passed variables.
   *
   * @param id The id of the weblink
   * @param title The title of the weblink
   * @param url The URL of the weblink
   * @param host The host id of the weblink
   * @return The passed weblink object
   */
  public WebLink createWebLink(long id, String title, String url, String host) {
    WebLink webLink = new WebLink();
    webLink.setId(id);
    webLink.setTitle(title);
    webLink.setUrl(url);
    webLink.setHost(host);

    return webLink;
  }

  /**
   * Method to create a book from the manager class with the passed values.
   *
   * @param id The ID of the book
   * @param title The title of the book
   * @param publicationYear The publication year of the book
   * @param publisher The publisher company's name
   * @param authors The names of the authors in a String list
   * @param genre The genre of the book from the constants bookgenre class
   * @param amazonRating The rating of the book on Amazon's site
   * @return The book object that was created
   */
  public Book createBook(long id, String title, int publicationYear, String publisher,
                         String[] authors,
                         String genre, double amazonRating) {
    Book book = new Book();
    book.setId(id);
    book.setTitle(title);
    book.setPublicationYear(publicationYear);
    book.setPublisher(publisher);
    book.setAuthors(authors);
    book.setGenre(genre);
    book.setAmazonRating(amazonRating);

    return book;
  }

  /**
   * Method to create a movie object from the manager class from the passed values.
   *
   * @param id The internal stored ID of the movie
   * @param title The title of the movie
   * @param profileUrl The url of the movie
   * @param releaseYear The year the movie was released
   * @param cast The cast of the movie stored in a String list
   * @param directors The list of directors of the movie stored in a String list
   * @param genre The genre of the movie from the MovieGenre class
   * @param imdbRating The rating given by IMDB
   * @return The created movie object
   */
  public Movie createMovie(long id, String title, int releaseYear, String[] cast,
                           String[] directors, String genre, double imdbRating) {
    Movie movie = new Movie();
    movie.setId(id);
    movie.setTitle(title);
    movie.setReleaseYear(releaseYear);
    movie.setCast(cast);
    movie.setDirectors(directors);
    movie.setGenre(genre);
    movie.setImdbRating(imdbRating);

    return movie;
  }

  public Bookmark[][] getBookmarks() {
    return dao.getBookmarks();
  }

  /**
   * Method to save the bookmark to the user's account.
   *
   * @param user The user who bookmarked the object
   * @param bookmark The bookmarked object
   */
  public void saveUserBookmark(User user, Bookmark bookmark) {
    UserBookmark userBookmark = new UserBookmark();
    userBookmark.setUser(user);
    userBookmark.setBookmark(bookmark);

    dao.saveUserBookmark(userBookmark);
  }

  /**
   * Method to enable Editor or Chief Editors to set the kid friendly status of a bookmark.
   *
   * @param user The passed user object
   * @param kidFriendlyStatus Status of whether the movie was set as kid friendly
   * @param bookmark The passed bookmark object
   */
  public void setKidFriendlyStatus(User user, String kidFriendlyStatus, Bookmark bookmark) {
    bookmark.setKidFriendlyStatus(kidFriendlyStatus);
    bookmark.setKidFriendlyMarkedBy(user);

    System.out.println(
        "Kid-friendly status: "
            + kidFriendlyStatus
            + ", Marked by: "
            + user.getEmail()
            + ", "
            + bookmark);
  }

  /**
   * Method to enable sharing of a book or weblink object. If it is an instance of either book
   * or weblink then it can be shared to third party site.
   *
   * @param user The user objected passed in
   * @param bookmark The bookmark object passed in
   */
  public void share(User user, Bookmark bookmark) {
    bookmark.setSharedBy(user);

    System.out.println("Data to be shared: ");
    if (bookmark instanceof Book) {
      System.out.println(((Book) bookmark).getItemData());
    } else if (bookmark instanceof WebLink) {
      System.out.println(((WebLink) bookmark).getItemData());
    }
  }
}
