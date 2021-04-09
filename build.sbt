organization := "com.wellfactored"

crossScalaVersions := Seq("2.11.12", "2.12.13", "2.13.5")

scalaVersion := "2.13.5"

lazy val `property-info` =
  (project in file("."))
    .enablePlugins(GitVersioning)
    .enablePlugins(GitBranchPrompt)

git.useGitDescribe in ThisBuild := true

wartremoverErrors ++= Warts.unsafe
wartremoverErrors -= Wart.Any

libraryDependencies ++= Seq(
  "com.chuusai" %% "shapeless" % "2.3.4",
  "org.scalatest" %% "scalatest" % "3.2.7" % "test"
)
