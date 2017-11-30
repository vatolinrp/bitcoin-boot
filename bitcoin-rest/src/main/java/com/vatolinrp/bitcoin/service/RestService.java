package com.vatolinrp.bitcoin.service;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan( value = "com.vatolinrp.bitcoin" )
public class RestService extends ResourceConfig
{
  public RestService()
  {
    register( BitcoinPriceService.class );
  }

  public static void main( String[] args )
  {
    System.getProperties().put( "server.port", 8081 );
    SpringApplication.run( RestService.class, args );
  }
}
