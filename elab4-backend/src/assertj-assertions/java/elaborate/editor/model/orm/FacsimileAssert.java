package elaborate.editor.model.orm;

import org.assertj.core.api.AbstractAssert;
// Assertions is needed if an assertion for Iterable is generated
import org.assertj.core.api.Assertions;
import java.util.Date;


/**
 * {@link Facsimile} specific assertions - Generated by CustomAssertionGenerator.
 */
public class FacsimileAssert extends AbstractAssert<FacsimileAssert, Facsimile> {

  /**
   * Creates a new </code>{@link FacsimileAssert}</code> to make assertions on actual Facsimile.
   * @param actual the Facsimile we want to make assertions on.
   */
  public FacsimileAssert(Facsimile actual) {
    super(actual, FacsimileAssert.class);
  }

  /**
   * An entry point for FacsimileAssert to follow AssertJ standard <code>assertThat()</code> statements.<br>
   * With a static import, one's can write directly : <code>assertThat(myFacsimile)</code> and get specific assertion with code completion.
   * @param actual the Facsimile we want to make assertions on.
   * @return a new </code>{@link FacsimileAssert}</code>
   */
  public static FacsimileAssert assertThat(Facsimile actual) {
    return new FacsimileAssert(actual);
  }

  /**
   * Verifies that the actual Facsimile's createdOn is equal to the given one.
   * @param createdOn the given createdOn to compare the actual Facsimile's createdOn to.
   * @return this assertion object.
   * @throws AssertionError - if the actual Facsimile's createdOn is not equal to the given one.
   */
  public FacsimileAssert hasCreatedOn(Date createdOn) {
    // check that actual Facsimile we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpected createdOn of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    Date actualCreatedOn = actual.getCreatedOn();
    if (!org.assertj.core.util.Objects.areEqual(actualCreatedOn, createdOn)) {
      failWithMessage(assertjErrorMessage, actual, createdOn, actualCreatedOn);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual Facsimile's creator is equal to the given one.
   * @param creator the given creator to compare the actual Facsimile's creator to.
   * @return this assertion object.
   * @throws AssertionError - if the actual Facsimile's creator is not equal to the given one.
   */
  public FacsimileAssert hasCreator(User creator) {
    // check that actual Facsimile we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpected creator of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    User actualCreator = actual.getCreator();
    if (!org.assertj.core.util.Objects.areEqual(actualCreator, creator)) {
      failWithMessage(assertjErrorMessage, actual, creator, actualCreator);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual Facsimile's filename is equal to the given one.
   * @param filename the given filename to compare the actual Facsimile's filename to.
   * @return this assertion object.
   * @throws AssertionError - if the actual Facsimile's filename is not equal to the given one.
   */
  public FacsimileAssert hasFilename(String filename) {
    // check that actual Facsimile we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpected filename of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    String actualFilename = actual.getFilename();
    if (!org.assertj.core.util.Objects.areEqual(actualFilename, filename)) {
      failWithMessage(assertjErrorMessage, actual, filename, actualFilename);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual Facsimile's id is equal to the given one.
   * @param id the given id to compare the actual Facsimile's id to.
   * @return this assertion object.
   * @throws AssertionError - if the actual Facsimile's id is not equal to the given one.
   */
  public FacsimileAssert hasId(long id) {
    // check that actual Facsimile we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpected id of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // check
    long actualId = actual.getId();
    if (actualId != id) {
      failWithMessage(assertjErrorMessage, actual, id, actualId);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual Facsimile's modifiedOn is equal to the given one.
   * @param modifiedOn the given modifiedOn to compare the actual Facsimile's modifiedOn to.
   * @return this assertion object.
   * @throws AssertionError - if the actual Facsimile's modifiedOn is not equal to the given one.
   */
  public FacsimileAssert hasModifiedOn(Date modifiedOn) {
    // check that actual Facsimile we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpected modifiedOn of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    Date actualModifiedOn = actual.getModifiedOn();
    if (!org.assertj.core.util.Objects.areEqual(actualModifiedOn, modifiedOn)) {
      failWithMessage(assertjErrorMessage, actual, modifiedOn, actualModifiedOn);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual Facsimile's modifier is equal to the given one.
   * @param modifier the given modifier to compare the actual Facsimile's modifier to.
   * @return this assertion object.
   * @throws AssertionError - if the actual Facsimile's modifier is not equal to the given one.
   */
  public FacsimileAssert hasModifier(User modifier) {
    // check that actual Facsimile we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpected modifier of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    User actualModifier = actual.getModifier();
    if (!org.assertj.core.util.Objects.areEqual(actualModifier, modifier)) {
      failWithMessage(assertjErrorMessage, actual, modifier, actualModifier);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual Facsimile's name is equal to the given one.
   * @param name the given name to compare the actual Facsimile's name to.
   * @return this assertion object.
   * @throws AssertionError - if the actual Facsimile's name is not equal to the given one.
   */
  public FacsimileAssert hasName(String name) {
    // check that actual Facsimile we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpected name of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    String actualName = actual.getName();
    if (!org.assertj.core.util.Objects.areEqual(actualName, name)) {
      failWithMessage(assertjErrorMessage, actual, name, actualName);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual Facsimile's projectEntry is equal to the given one.
   * @param projectEntry the given projectEntry to compare the actual Facsimile's projectEntry to.
   * @return this assertion object.
   * @throws AssertionError - if the actual Facsimile's projectEntry is not equal to the given one.
   */
  public FacsimileAssert hasProjectEntry(ProjectEntry projectEntry) {
    // check that actual Facsimile we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpected projectEntry of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    ProjectEntry actualProjectEntry = actual.getProjectEntry();
    if (!org.assertj.core.util.Objects.areEqual(actualProjectEntry, projectEntry)) {
      failWithMessage(assertjErrorMessage, actual, projectEntry, actualProjectEntry);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual Facsimile's rev is equal to the given one.
   * @param rev the given rev to compare the actual Facsimile's rev to.
   * @return this assertion object.
   * @throws AssertionError - if the actual Facsimile's rev is not equal to the given one.
   */
  public FacsimileAssert hasRev(long rev) {
    // check that actual Facsimile we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpected rev of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // check
    long actualRev = actual.getRev();
    if (actualRev != rev) {
      failWithMessage(assertjErrorMessage, actual, rev, actualRev);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual Facsimile's thumbnailUrl is equal to the given one.
   * @param thumbnailUrl the given thumbnailUrl to compare the actual Facsimile's thumbnailUrl to.
   * @return this assertion object.
   * @throws AssertionError - if the actual Facsimile's thumbnailUrl is not equal to the given one.
   */
  public FacsimileAssert hasThumbnailUrl(String thumbnailUrl) {
    // check that actual Facsimile we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpected thumbnailUrl of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    String actualThumbnailUrl = actual.getThumbnailUrl();
    if (!org.assertj.core.util.Objects.areEqual(actualThumbnailUrl, thumbnailUrl)) {
      failWithMessage(assertjErrorMessage, actual, thumbnailUrl, actualThumbnailUrl);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual Facsimile's title is equal to the given one.
   * @param title the given title to compare the actual Facsimile's title to.
   * @return this assertion object.
   * @throws AssertionError - if the actual Facsimile's title is not equal to the given one.
   */
  public FacsimileAssert hasTitle(String title) {
    // check that actual Facsimile we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpected title of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    String actualTitle = actual.getTitle();
    if (!org.assertj.core.util.Objects.areEqual(actualTitle, title)) {
      failWithMessage(assertjErrorMessage, actual, title, actualTitle);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual Facsimile's zoomableUrl is equal to the given one.
   * @param zoomableUrl the given zoomableUrl to compare the actual Facsimile's zoomableUrl to.
   * @return this assertion object.
   * @throws AssertionError - if the actual Facsimile's zoomableUrl is not equal to the given one.
   */
  public FacsimileAssert hasZoomableUrl(String zoomableUrl) {
    // check that actual Facsimile we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpected zoomableUrl of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    String actualZoomableUrl = actual.getZoomableUrl();
    if (!org.assertj.core.util.Objects.areEqual(actualZoomableUrl, zoomableUrl)) {
      failWithMessage(assertjErrorMessage, actual, zoomableUrl, actualZoomableUrl);
    }

    // return the current assertion for method chaining
    return this;
  }

}
