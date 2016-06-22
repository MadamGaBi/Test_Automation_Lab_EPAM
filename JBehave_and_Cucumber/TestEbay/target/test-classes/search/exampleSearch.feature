Feature: Demo example

#  Scenario: Running a Full Text Quick Search
#    Given I set search request "iPhone4s"
#    When I perform search
#    Then the tern query "iPhone 4S" should be the first in the Search Result grid

  Scenario Outline: Running a Full Text Quick Search _2
    Given I set search request "<request>"
    When I perform search
    Then the tern query "<request>" should be the first in the Search Result grid
    Examples:
      | request        |
      | iPhone 4S      |
      | Samsung Galaxy |