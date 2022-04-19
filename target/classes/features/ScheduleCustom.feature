Feature: Admin Access Halaman Schedule Custom Astro

  Scenario: Testing Schedule Custom Page
    Given Admin mengakses url web astro
    When Admin login ke web astro
    And Admin mengakses menu schedule custom
    And Admin menambah data absen user
    Then Data berhasil terupdate
