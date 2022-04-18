Feature: Admin Access to Reimbursement Page

  Scenario: Testing Reimbursement Page
    Given Admin access url hadir2
    When Admin access login page
    And Admin access reimbursement
    And Admin access payment
    And Admin manage payment
    And Admin access report
    And Admin manage report
    Then Admin success export data report
