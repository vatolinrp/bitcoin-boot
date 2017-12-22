plugins {
  id( "java-library" )
}

dependencies {
  testImplementation( project( ":bitcoin-model" ) )
  testImplementation( project( ":bitcoin-dao" ) )
  testImplementation( project( ":bitcoin-rest" ) )
}
