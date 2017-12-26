package com.vatolinrp.bitcoin.service;

import com.github.tomakehurst.wiremock.client.WireMock;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class BlockChainStubs {
  private String successfulExternalResponse;

  public BlockChainStubs() throws IOException {
    final InputStream inputStream = this.getClass().getResourceAsStream( "/successfulBodyFromBlockChainCall.json" );
    successfulExternalResponse = IOUtils.toString( inputStream, "UTF-8" );
  }

  public void stubExternalForServerError() {
    WireMock.stubFor( WireMock.get( WireMock.urlEqualTo( "/ticker" ) )
      .willReturn( WireMock.aResponse().withStatus( 500 ) ) );
  }

  public void stubExternalForClientError() {
    WireMock.stubFor( WireMock.get( WireMock.urlEqualTo( "/ticker" ) )
      .willReturn( WireMock.aResponse().withStatus( 400 ) ) );
  }

  public void stubExternalForSuccessResponse() {
    WireMock.stubFor( WireMock.get( WireMock.urlEqualTo( "/ticker" ) )
      .willReturn( WireMock.aResponse().withStatus( 200 ).withHeader( "Content-Type", "application/json" )
      .withBody( successfulExternalResponse ) ) );
  }
}
