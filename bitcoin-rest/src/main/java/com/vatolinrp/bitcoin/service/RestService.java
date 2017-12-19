package com.vatolinrp.bitcoin.service;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Collections;

@SpringBootApplication
@ComponentScan( value = "com.vatolinrp.bitcoin" )
public class RestService
{
  private static final int port = 8081;
  private static final String basePath = "/*";

  @Autowired
  private Bus bus;

  @Autowired
  private BitcoinPriceService bitcoinPriceService;

  public static void main( String[] args )
  {
    System.getProperties().put( "server.port", port );
    SpringApplication.run( RestService.class, args );
  }

  @Bean
  public Server rsServer()
  {
    JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
    endpoint.setBus( bus );
    endpoint.setServiceBeans( Collections.singletonList( bitcoinPriceService ) );
    endpoint.setProvider( new JacksonJsonProvider() );
    return endpoint.create();
  }

  @Bean
  public ServletRegistrationBean cxfServletRegistrationBean()
  {
    return new ServletRegistrationBean( new CXFServlet(), basePath );
  }
}
