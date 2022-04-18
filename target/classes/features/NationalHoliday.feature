Feature: Admin Access to National Holiday Page

  Scenario: Testing National Holiday Page
    Given Admin akses url
    When Admin access login
    And Admin access National Holiday
    And Admin search data Holiday
    And Admin click maximize and minimize layout
    And Admin add national holiday
    And Admin Edit data national holiday
    And Admin delete data national holiday
    Then Admin Success add, edit, and delete national holiday
