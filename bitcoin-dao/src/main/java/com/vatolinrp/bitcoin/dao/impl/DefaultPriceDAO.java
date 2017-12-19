package com.vatolinrp.bitcoin.dao.impl;

import com.vatolinrp.bitcoin.dao.PriceDAO;
import com.vatolinrp.bitcoin.model.CurrencyCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

@Repository
@PropertySource( "classpath:conf/base.properties" )
public class DefaultPriceDAO implements PriceDAO
{
  private static final Logger logger = LoggerFactory.getLogger( DefaultPriceDAO.class );
  private static final String LAST_PRICE_FIELD = "last";

  @Value("${bitcoin.price.get.request.url}")
  private String bitcoinPriceURL;

  private RestTemplate restTemplate;

  public DefaultPriceDAO()
  {
    restTemplate = new RestTemplate();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Map<CurrencyCodeEnum, Double> getPrice()
  {
    return parseResponse( getResponseFromExternal() );
  }

  private Map<CurrencyCodeEnum, Double> parseResponse( final Map responseMap )
  {
    final Map<CurrencyCodeEnum, Double> resultMap = new EnumMap<>( CurrencyCodeEnum.class );
    if( responseMap == null ) {
      logger.error( "Cannot parse response because it is null" );
      return resultMap;
    }
    try {
      Arrays.asList( CurrencyCodeEnum.values() )
        .forEach( currencyCode -> {
          if( responseMap.containsKey( currencyCode.name() ) ) {
            final Double bitcoinValue = (Double) ( (Map) responseMap.get( currencyCode.name() ) ).get( LAST_PRICE_FIELD );
             resultMap.put( currencyCode, bitcoinValue );
          }
        } );
      return resultMap;
    } catch ( final ClassCastException e ) {
      logger.error( "An exception has occurred while working with response", e );
    }
    return resultMap;
  }

  private Map getResponseFromExternal()
  {
    try {
      return restTemplate.getForObject( bitcoinPriceURL, Map.class );
    } catch ( final RestClientException e ) {
      logger.error( "An exception has occurred while requesting prices", e );
    }
    return new HashMap();
  }
}
