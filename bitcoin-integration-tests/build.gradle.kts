plugins {
  id( "java-library" )
}

val springBootVersion by project
val testngVersion by project
val springframeworkVersion by project

dependencies {
  testImplementation( project( ":bitcoin-model" ) )
  testImplementation( project( ":bitcoin-dao" ) )
  testImplementation( project( ":bitcoin-rest" ) )
  testImplementation( "org.springframework.boot:spring-boot-test:${springBootVersion}")
  testImplementation( "org.springframework:spring-test:${springframeworkVersion}")
  testImplementation( "org.testng:testng:${testngVersion}" )
}
