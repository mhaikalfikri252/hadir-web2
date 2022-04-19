Feature: Admin Access to Report Karyawan Page

  Scenario: Testing Report Karyawan Page
    Given Admin access url hadir 2
    When Admin access login url
    And Admin access report karyawan
    And Admin manage report karyawan
    And Admin access view detail report
    Then Admin success export data report karyawan
