package com.mathewdenison.thrillio.entities;

import com.mathewdenison.thrillio.constants.MovieGenre;
import com.mathewdenison.thrillio.managers.BookmarkManager;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;


public class MovieTest {

  @Test
  public void isKidFriendlyEligible() {
    //Test 1
    Movie movie = BookmarkManager.getInstance()
        .createMovie(3000, "Citizen Kane", "", 1941, new String[] {"Orson Welles", "Joseph Cotten"},
            new String[] {"Orson Welles"}, MovieGenre.HORROR, 8.5);

    boolean isKidFriendlyEligible = movie.isKidFriendlyEligible();

    assertFalse(isKidFriendlyEligible,
        "For Horror Genre - isKidFriendlyEligible should return false");

    //Test 2
    movie = BookmarkManager.getInstance()
        .createMovie(3000, "Citizen Kane", "", 1941, new String[] {"Orson Welles", "Joseph Cotten"},
            new String[] {"Orson Welles"}, MovieGenre.THRILLERS, 8.5);

    isKidFriendlyEligible = movie.isKidFriendlyEligible();

    assertFalse(isKidFriendlyEligible,
        "For Thrillers Genre - isKidFriendlyEligible should return false");
  }
}