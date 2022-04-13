Feature: Customer Login to Astro

  Scenario: Testing Login Customer Valid
    Given Customer mengakses url
    When Customer klik login button
    Then Customer berhasil login

  Scenario: Testing Login Customer Invalid
    When Customer klik login button
    Then Customer berhasil login
