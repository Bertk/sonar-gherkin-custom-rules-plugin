# Noncompliant [[sc=1;ec=9]] {{The value "123" does not match reg-ex.}} 
@uid:123 
Feature: My feature allowed tags custom...
  Blabla...

  # Noncompliant [[sc=3;ec=10]] {{The value "abc" does not match reg-ex.}}
  @tc:abc 
  Scenario: Scenario 1 allowed tags custom
    Given Blabla given...
    When Blabla when...
    Then Blabla then...

  @tc:1234 @us:1234 @bug:1234 @uid:MySpecialNameforUIDxxxxxxxXXXXXXXXXXXXXX @tfs:https://specsyncdemo.visualstudio.com/MyCalculator
  Scenario: Scenario 2 allowed tags custom
    Given Blabla given...
    When Blabla when...
    Then Blabla then...
