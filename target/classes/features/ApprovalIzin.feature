Feature: User Access to Approval Izin Page

  Scenario: Testing Approval Izin Page
    Given Admin access url
    When Admin akses login
    And Admin akses approval izin
    And Admin search data izin
    And Admin view photo izin
    And Admin reject izin
    And Admin approve izin
    Then Admin Success reject, approve, and view photo izin
