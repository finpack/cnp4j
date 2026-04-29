
ThisBuild / organization := "com.vrachieru"
ThisBuild / version      := "1.1.1"

val nexusHost         = sys.env.getOrElse("NEXUS_HOST", "nexus.k8s01v1.mngmt.lendi.cloud")
val nexusReleasesUrl  = s"https://$nexusHost/repository/maven-releases/"
val nexusSnapshotsUrl = s"https://$nexusHost/repository/maven-snapshots/"
val nexusRealm        = "Sonatype Nexus Repository Manager"
val nexus = Seq(
  "Lendi Nexus Releases".at(nexusReleasesUrl),
  "Lendi Nexus Snapshots".at(nexusSnapshotsUrl)
)

lazy val root = (project in file("."))
  .settings(
    name        := "cnp4j",
    description := "Library for generation and validation of romanian Personal Numeric Codes.",

    crossPaths       := false,
    autoScalaLibrary := false,

//    javacOptions ++= Seq("-source", "11", "-target", "11"),

    libraryDependencies ++= Seq(
      "org.apache.commons" %  "commons-lang3" % "3.0",
      "junit"              %  "junit"         % "4.11" % Test,
      "com.novocode"       %  "junit-interface" % "0.11" % Test exclude("junit", "junit-dep")
    ),

    publishMavenStyle := true,
    publishTo := {
      if (isSnapshot.value) {
        Some("snapshots".at(nexusSnapshotsUrl))
      } else Some("releases".at(nexusReleasesUrl))
    },
    credentials ++= {
      (sys.env.get("NEXUS_USERNAME"), sys.env.get("NEXUS_PASSWORD")) match {
        case (Some(user), Some(pass)) if user.nonEmpty && pass.nonEmpty =>
          Seq(Credentials(nexusRealm, nexusHost, user, pass))
        case _ =>
          Seq.empty
      }

    }
  )