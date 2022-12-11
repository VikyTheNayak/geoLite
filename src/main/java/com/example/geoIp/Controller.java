package com.example.geoIp;

import com.maxmind.geoip2.record.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/geoip/")
public class Controller {

  private final GeoService geoService;

  @Autowired
  public Controller(GeoService geoService) {
    this.geoService = geoService;
  }

  @GetMapping(path = "{ip}")
  public Response getIpDetails(@PathVariable String ip) {
    Response rs = null;
    try {
      rs = geoService.getIpDetails(ip);
    } catch (Exception e){
      System.out.println(e);
    }
    return rs;
  }

  @GetMapping(path = "getCountry/{ip}")
  public Country getCountry(@PathVariable String ip) {
    Country rs = null;
    try {
      rs = geoService.getCountry(ip);
    } catch (Exception e){
      System.out.println(e);
    }
    return rs;
  }

  @GetMapping(path = "Country/getIsoCode/{ip}")
  public String getIsoCode(@PathVariable String ip) {
    String rs = null;
    try {
      rs = geoService.getCountry(ip).getIsoCode();
    } catch (Exception e){
      System.out.println(e);
    }
    return rs;
  }

  @GetMapping(path = "getCity/{ip}")
  public City getCity(@PathVariable String ip) {
    City rs = null;
    try {
      rs = geoService.getCity(ip);
    } catch (Exception e){
      System.out.println(e);
    }
    return rs;
  }

  @GetMapping(path = "getLocation/{ip}")
  public Location getLocation(@PathVariable String ip) {
    Location rs = null;
    try {
      rs = geoService.getLocation(ip);
    } catch (Exception e){
      System.out.println(e);
    }
    return rs;
  }

  @GetMapping(path = "getPostalCode/{ip}")
  public Postal getPostalCode(@PathVariable String ip) {
    Postal rs = null;
    try {
      rs = geoService.getPostalCode(ip);
    } catch (Exception e){
      System.out.println(e);
    }
    return rs;
  }

  @GetMapping(path = "getContinent/{ip}")
  public Continent getContinent(@PathVariable String ip) {
    Continent rs = null;
    try {
      rs = geoService.getContinent(ip);
    } catch (Exception e){
      System.out.println(e);
    }
    return rs;
  }
}
