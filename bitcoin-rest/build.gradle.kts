plugins {
  id( "org.springframework.boot" ) version( "1.5.9.RELEASE" )
  id( "java-library" )
}

val swaggerVersion by project
val fasterxmlVersion by project
val mockitoVersion by project
val springframeworkVersion by project
val testngVersion by project

dependencies {
  compile( project( ":bitcoin-model" ) )
  compile( project( ":bitcoin-dao" ) )
  compile( "org.apache.cxf:cxf-spring-boot-starter-jaxrs:3.2.1")
  compile( "com.fasterxml.jackson.jaxrs:jackson-jaxrs-json-provider:${fasterxmlVersion}")
  implementation( "io.swagger:swagger-annotations:${swaggerVersion}")
  testImplementation( "org.mockito:mockito-all:${mockitoVersion}")
  testImplementation( "org.springframework:spring-test:${springframeworkVersion}")
  testImplementation( "org.testng:testng:${testngVersion}")
}
