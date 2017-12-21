plugins {
  id( "java-library" )
}

val fasterxmlVersion by project
val swaggerVersion by project

dependencies {
  implementation( "com.fasterxml.jackson.core:jackson-databind:${fasterxmlVersion}" )
  implementation( "io.swagger:swagger-annotations:${swaggerVersion}" )
}
