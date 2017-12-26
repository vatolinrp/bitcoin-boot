package com.vatolinrp.bitcoin.service;

import com.vatolinrp.bitcoin.model.BitcoinPriceValues;
import com.vatolinrp.bitcoin.model.Ping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BitcoinPriceServiceIntTest extends AbstractTestNGSpringContextTests {

  @Autowired
  private TestRestTemplate testRestTemplate;

  @Test
  public void checkPing() {
    final ResponseEntity<Ping> response = this.testRestTemplate.getForEntity( "/ping", Ping.class );
    Assert.assertNotNull( response );
    Assert.assertEquals( response.getStatusCode(), HttpStatus.OK );
    Assert.assertNotNull( response.getBody() );
    Assert.assertNotNull( response.getBody().getStatus() );
    Assert.assertEquals( response.getBody().getStatus(), "Active" );
  }

  @Test
  public void checkBitcoinGetRequest() {
    final ResponseEntity<BitcoinPriceValues> response = this.testRestTemplate
      .getForEntity( "/bitcoin", BitcoinPriceValues.class );
    Assert.assertNotNull( response );
    Assert.assertEquals( response.getStatusCode(), HttpStatus.OK );
    Assert.assertNotNull( response.getBody() );
    Assert.assertNotNull( response.getBody().getPrices() );
    Assert.assertEquals( response.getBody().getPrices().size(), 3 );
    Assert.assertNotNull( response.getBody().getPrices().get( "USD" ) );
    Assert.assertNotNull( response.getBody().getPrices().get( "CNY" ) );
    Assert.assertNotNull( response.getBody().getPrices().get( "EUR" ) );
  }
}
