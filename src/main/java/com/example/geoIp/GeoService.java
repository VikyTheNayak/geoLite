package com.example.geoIp;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.model.CountryResponse;
import com.maxmind.geoip2.record.*;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

@Service
public class GeoService {
  public Response getIpDetails(String ipAddr) throws GeoIp2Exception, IOException {
    DatabaseReader reader = getReader();
    InetAddress ipAddress = InetAddress.getByName(ipAddr);
    CountryResponse countryResp =  reader.country(ipAddress);
    CityResponse cityResponse = reader.city(ipAddress);
    Country country = countryResp.getCountry();
    String isoCode = country.getIsoCode();
    Response st = new Response();
    st.setIpAddress(ipAddr);
    st.setCountry(isoCode);
    st.setCity(cityResponse.getCity().getName());
    return st;
  }

  public Country getCountry(String ip) throws GeoIp2Exception, IOException {
    DatabaseReader reader = getReader();
    InetAddress ipAddress = InetAddress.getByName(ip);
    CountryResponse countryResp =  reader.country(ipAddress);
    Country country = countryResp.getCountry();
    return country;
  }

  public City getCity(String ip) throws GeoIp2Exception, IOException {
    DatabaseReader reader = getReader();
    InetAddress ipAddress = InetAddress.getByName(ip);
    CityResponse cityResponse = reader.city(ipAddress);
    City city = cityResponse.getCity();
    return city;
  }

  public Location getLocation(String ip) throws GeoIp2Exception, IOException {
    DatabaseReader reader = getReader();
    InetAddress ipAddress = InetAddress.getByName(ip);
    CityResponse cityResponse = reader.city(ipAddress);
    Location location = cityResponse.getLocation();
    return location;
  }

  public Postal getPostalCode(String ip) throws GeoIp2Exception, IOException {
    DatabaseReader reader = getReader();
    InetAddress ipAddress = InetAddress.getByName(ip);
    CityResponse cityResponse = reader.city(ipAddress);
    Postal postal = cityResponse.getPostal();
    return postal;
  }

  public Continent getContinent(String ip) throws GeoIp2Exception, IOException {
    DatabaseReader reader = getReader();
    InetAddress ipAddress = InetAddress.getByName(ip);
    CityResponse cityResponse = reader.city(ipAddress);
    Continent continent = cityResponse.getContinent();
    return continent;
  }
  
  protected DatabaseReader getReader() throws IOException{
	String dbFile = "C:/geoLite/GeoLite2-City.mmdb";
    File ipDb = new File(dbFile);
    DatabaseReader reader = new DatabaseReader.Builder(ipDb).build();
    return reader;
  }
}
