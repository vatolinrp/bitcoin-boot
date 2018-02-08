subprojects {
  tasks.withType( JavaCompile::class.java ).all {
    sourceCompatibility = JavaVersion.VERSION_1_8.majorVersion
    targetCompatibility = JavaVersion.VERSION_1_8.majorVersion
  }
}

allprojects {
  repositories {
    jcenter()
  }
}

task<Wrapper>( "wrapper" ) {
  gradleVersion = "4.5.1"
  distributionType = Wrapper.DistributionType.ALL
}
