plugins {
  id( "java-library" )
}

val testngVersion by project
val wiremockVersion by project
val springBootVersion by project
val springframeworkVersion by project
val commonsVersion by project

dependencies {
  testImplementation( project( ":bitcoin-model" ) )
  testImplementation( project( ":bitcoin-dao" ) )
  testImplementation( project( ":bitcoin-rest" ) )
  testImplementation( "org.testng:testng:${testngVersion}" )
  testImplementation ("commons-io:commons-io:${commonsVersion}")
  testImplementation( "com.github.tomakehurst:wiremock:${wiremockVersion}" )
  testImplementation( "org.springframework.boot:spring-boot-test:${springBootVersion}")
  testImplementation( "org.springframework:spring-test:${springframeworkVersion}")
}
