package elaborate.editor.model;

import org.assertj.core.api.AbstractAssert;
// Assertions is needed if an assertion for Iterable is generated
import org.assertj.core.api.Assertions;


/**
 * {@link ElaborateRoles} specific assertions - Generated by CustomAssertionGenerator.
 */
public class ElaborateRolesAssert extends AbstractAssert<ElaborateRolesAssert, ElaborateRoles> {

  /**
   * Creates a new </code>{@link ElaborateRolesAssert}</code> to make assertions on actual ElaborateRoles.
   * @param actual the ElaborateRoles we want to make assertions on.
   */
  public ElaborateRolesAssert(ElaborateRoles actual) {
    super(actual, ElaborateRolesAssert.class);
  }

  /**
   * An entry point for ElaborateRolesAssert to follow AssertJ standard <code>assertThat()</code> statements.<br>
   * With a static import, one's can write directly : <code>assertThat(myElaborateRoles)</code> and get specific assertion with code completion.
   * @param actual the ElaborateRoles we want to make assertions on.
   * @return a new </code>{@link ElaborateRolesAssert}</code>
   */
  public static ElaborateRolesAssert assertThat(ElaborateRoles actual) {
    return new ElaborateRolesAssert(actual);
  }

}