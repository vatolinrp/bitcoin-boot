plugins {
  id( "java-library" )
}

val springframeworkVersion by project
val fasterxmlVersion by project
val slf4jVersion by project
val testngVersion by project
val mockitoVersion by project
val commonsVersion by project

dependencies {
  implementation( project(":bitcoin-model") )
  implementation( "org.springframework:spring-web:${springframeworkVersion}" )
  implementation( "com.fasterxml.jackson.core:jackson-databind:${fasterxmlVersion}" )
  implementation( "org.slf4j:slf4j-api:${slf4jVersion}" )
  testImplementation( "org.testng:testng:${testngVersion}" )
  testImplementation( "org.mockito:mockito-all:${mockitoVersion}" )
  testImplementation( "org.springframework:spring-test:${springframeworkVersion}" )
  testImplementation( "commons-io:commons-io:${commonsVersion}" )
}
