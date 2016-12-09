
organization := "com.wellfactored"

crossScalaVersions := Seq("2.10.6", "2.11.8", "2.12.1")

scalaVersion := "2.11.8"

tutSettings

lazy val `property-info` =
  (project in file("."))
    .enablePlugins(GitVersioning)
    .enablePlugins(GitBranchPrompt)

git.useGitDescribe in ThisBuild := true

libraryDependencies ++= Seq(
  "com.chuusai" %% "shapeless" % "2.3.2",
  compilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full),

  "org.scalatest" %% "scalatest" % "3.0.0" % "test"
)