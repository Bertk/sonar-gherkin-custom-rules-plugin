# Noncompliant [[sc=1;ec=7]] {{The tag "mytag" is not in the tag whitelist.}}
@mytag
Feature: My feature allowed tags default...
  Blabla...

  # Noncompliant [[sc=3;ec=23]] {{The tag "non-regression-test" is not in the tag whitelist.}}
  @non-regression-test
  Scenario: Scenario 1 allowed tags default
    Given Blabla given...
    When Blabla when...
    Then Blabla then...

  @NonRegressionTest @SmokeTest
  Scenario: Scenario 2 allowed tags default
    Given Blabla given...
    When Blabla when...
    Then Blabla then...