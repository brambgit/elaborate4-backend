package elaborate.editor.model;

import org.assertj.core.api.AbstractAssert;
// Assertions is needed if an assertion for Iterable is generated
import org.assertj.core.api.Assertions;
import elaborate.editor.model.orm.ProjectEntry;
import elaborate.editor.model.orm.User;
import java.util.Date;


/**
 * {@link AbstractIndexableProjectElement} specific assertions - Generated by CustomAssertionGenerator.
 */
public class AbstractIndexableProjectElementAssert extends AbstractAssert<AbstractIndexableProjectElementAssert, AbstractIndexableProjectElement> {

  /**
   * Creates a new </code>{@link AbstractIndexableProjectElementAssert}</code> to make assertions on actual AbstractIndexableProjectElement.
   * @param actual the AbstractIndexableProjectElement we want to make assertions on.
   */
  public AbstractIndexableProjectElementAssert(AbstractIndexableProjectElement actual) {
    super(actual, AbstractIndexableProjectElementAssert.class);
  }

  /**
   * An entry point for AbstractIndexableProjectElementAssert to follow AssertJ standard <code>assertThat()</code> statements.<br>
   * With a static import, one's can write directly : <code>assertThat(myAbstractIndexableProjectElement)</code> and get specific assertion with code completion.
   * @param actual the AbstractIndexableProjectElement we want to make assertions on.
   * @return a new </code>{@link AbstractIndexableProjectElementAssert}</code>
   */
  public static AbstractIndexableProjectElementAssert assertThat(AbstractIndexableProjectElement actual) {
    return new AbstractIndexableProjectElementAssert(actual);
  }

  /**
   * Verifies that the actual AbstractIndexableProjectElement's body is equal to the given one.
   * @param body the given body to compare the actual AbstractIndexableProjectElement's body to.
   * @return this assertion object.
   * @throws AssertionError - if the actual AbstractIndexableProjectElement's body is not equal to the given one.
   */
  public AbstractIndexableProjectElementAssert hasBody(String body) {
    // check that actual AbstractIndexableProjectElement we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String errorMessage = "\nExpected body of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    String actualBody = actual.getBody();
    if (!org.assertj.core.util.Objects.areEqual(actualBody, body)) {
      failWithMessage(errorMessage, actual, body, actualBody);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual AbstractIndexableProjectElement's createdOn is equal to the given one.
   * @param createdOn the given createdOn to compare the actual AbstractIndexableProjectElement's createdOn to.
   * @return this assertion object.
   * @throws AssertionError - if the actual AbstractIndexableProjectElement's createdOn is not equal to the given one.
   */
  public AbstractIndexableProjectElementAssert hasCreatedOn(Date createdOn) {
    // check that actual AbstractIndexableProjectElement we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String errorMessage = "\nExpected createdOn of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    Date actualCreatedOn = actual.getCreatedOn();
    if (!org.assertj.core.util.Objects.areEqual(actualCreatedOn, createdOn)) {
      failWithMessage(errorMessage, actual, createdOn, actualCreatedOn);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual AbstractIndexableProjectElement's creator is equal to the given one.
   * @param creator the given creator to compare the actual AbstractIndexableProjectElement's creator to.
   * @return this assertion object.
   * @throws AssertionError - if the actual AbstractIndexableProjectElement's creator is not equal to the given one.
   */
  public AbstractIndexableProjectElementAssert hasCreator(User creator) {
    // check that actual AbstractIndexableProjectElement we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String errorMessage = "\nExpected creator of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    User actualCreator = actual.getCreator();
    if (!org.assertj.core.util.Objects.areEqual(actualCreator, creator)) {
      failWithMessage(errorMessage, actual, creator, actualCreator);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual AbstractIndexableProjectElement's id is equal to the given one.
   * @param id the given id to compare the actual AbstractIndexableProjectElement's id to.
   * @return this assertion object.
   * @throws AssertionError - if the actual AbstractIndexableProjectElement's id is not equal to the given one.
   */
  public AbstractIndexableProjectElementAssert hasId(long id) {
    // check that actual AbstractIndexableProjectElement we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String errorMessage = "\nExpected id of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // check
    long actualId = actual.getId();
    if (actualId != id) {
      failWithMessage(errorMessage, actual, id, actualId);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual AbstractIndexableProjectElement's modifiedOn is equal to the given one.
   * @param modifiedOn the given modifiedOn to compare the actual AbstractIndexableProjectElement's modifiedOn to.
   * @return this assertion object.
   * @throws AssertionError - if the actual AbstractIndexableProjectElement's modifiedOn is not equal to the given one.
   */
  public AbstractIndexableProjectElementAssert hasModifiedOn(Date modifiedOn) {
    // check that actual AbstractIndexableProjectElement we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String errorMessage = "\nExpected modifiedOn of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    Date actualModifiedOn = actual.getModifiedOn();
    if (!org.assertj.core.util.Objects.areEqual(actualModifiedOn, modifiedOn)) {
      failWithMessage(errorMessage, actual, modifiedOn, actualModifiedOn);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual AbstractIndexableProjectElement's modifier is equal to the given one.
   * @param modifier the given modifier to compare the actual AbstractIndexableProjectElement's modifier to.
   * @return this assertion object.
   * @throws AssertionError - if the actual AbstractIndexableProjectElement's modifier is not equal to the given one.
   */
  public AbstractIndexableProjectElementAssert hasModifier(User modifier) {
    // check that actual AbstractIndexableProjectElement we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String errorMessage = "\nExpected modifier of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    User actualModifier = actual.getModifier();
    if (!org.assertj.core.util.Objects.areEqual(actualModifier, modifier)) {
      failWithMessage(errorMessage, actual, modifier, actualModifier);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual AbstractIndexableProjectElement's projectEntry is equal to the given one.
   * @param projectEntry the given projectEntry to compare the actual AbstractIndexableProjectElement's projectEntry to.
   * @return this assertion object.
   * @throws AssertionError - if the actual AbstractIndexableProjectElement's projectEntry is not equal to the given one.
   */
  public AbstractIndexableProjectElementAssert hasProjectEntry(ProjectEntry projectEntry) {
    // check that actual AbstractIndexableProjectElement we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String errorMessage = "\nExpected projectEntry of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    ProjectEntry actualProjectEntry = actual.getProjectEntry();
    if (!org.assertj.core.util.Objects.areEqual(actualProjectEntry, projectEntry)) {
      failWithMessage(errorMessage, actual, projectEntry, actualProjectEntry);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual AbstractIndexableProjectElement's rev is equal to the given one.
   * @param rev the given rev to compare the actual AbstractIndexableProjectElement's rev to.
   * @return this assertion object.
   * @throws AssertionError - if the actual AbstractIndexableProjectElement's rev is not equal to the given one.
   */
  public AbstractIndexableProjectElementAssert hasRev(long rev) {
    // check that actual AbstractIndexableProjectElement we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String errorMessage = "\nExpected rev of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // check
    long actualRev = actual.getRev();
    if (actualRev != rev) {
      failWithMessage(errorMessage, actual, rev, actualRev);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual AbstractIndexableProjectElement's solrId is equal to the given one.
   * @param solrId the given solrId to compare the actual AbstractIndexableProjectElement's solrId to.
   * @return this assertion object.
   * @throws AssertionError - if the actual AbstractIndexableProjectElement's solrId is not equal to the given one.
   */
  public AbstractIndexableProjectElementAssert hasSolrId(String solrId) {
    // check that actual AbstractIndexableProjectElement we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String errorMessage = "\nExpected solrId of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    String actualSolrId = actual.getSolrId();
    if (!org.assertj.core.util.Objects.areEqual(actualSolrId, solrId)) {
      failWithMessage(errorMessage, actual, solrId, actualSolrId);
    }

    // return the current assertion for method chaining
    return this;
  }

}