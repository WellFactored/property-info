
organization := "com.wellfactored"

crossScalaVersions := Seq("2.11.12", "2.12.7")

scalaVersion := "2.12.7"

lazy val `property-info` =
  (project in file("."))
    .enablePlugins(GitVersioning)
    .enablePlugins(GitBranchPrompt)

git.useGitDescribe in ThisBuild := true

wartremoverErrors ++= Warts.unsafe
wartremoverErrors -= Wart.Any

libraryDependencies ++= Seq(
  "com.chuusai" %% "shapeless" % "2.3.3",
  compilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full),

  "org.scalatest" %% "scalatest" % "3.0.0" % "test"
)