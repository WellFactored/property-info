
organization := "com.wellfactored"

scalaVersion := "2.11.8"

tutSettings

lazy val `property-info` =
  (project in file("."))
    .enablePlugins(GitVersioning)
    .enablePlugins(GitBranchPrompt)

git.useGitDescribe in ThisBuild := true

libraryDependencies ++= Seq(
  "com.chuusai" %% "shapeless" % "2.3.2",

  "org.scalatest" %% "scalatest" % "3.0.0" % "test"
)