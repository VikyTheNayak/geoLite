package com.example.geoIp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {

  private String country;
  private String city;
  private String ipAddress;
  private String locale;
  private String timeZone;
  private String postalCode;

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getIpAddress() {
    return ipAddress;
  }

  public void setIpAddress(String ipAddress) {
    this.ipAddress = ipAddress;
  }

  public String getLocale() {
    return locale;
  }

  public void setLocale(String locale) {
    this.locale = locale;
  }

  public String getTimeZone() {
    return timeZone;
  }

  public void setTimeZone(String timeZone) {
    this.timeZone = timeZone;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  @Override
  public String toString() {
    return "Response{" +
            "country='" + country + '\'' +
            ", city='" + city + '\'' +
            ", ipAddress='" + ipAddress + '\'' +
            ", locale='" + locale + '\'' +
            ", timeZone='" + timeZone + '\'' +
            ", postalCode='" + postalCode + '\'' +
            '}';
  }
}
