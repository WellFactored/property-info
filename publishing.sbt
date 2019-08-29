publishMavenStyle in ThisBuild := true

pgpPublicRing := file("/Users/dec/Documents/.sonatype/pubring.gpg")
pgpSecretRing := file("/Users/dec/Documents/.sonatype/secring.gpg")

publishTo in ThisBuild := sonatypePublishTo.value

pomIncludeRepository in ThisBuild := { _ => false }

licenses in ThisBuild := Seq("MIT" -> url("https://opensource.org/licenses/MIT"))

homepage in ThisBuild := Some(url(s"https://github.com/wellfactored/${name.value}"))

scmInfo in ThisBuild := Some(ScmInfo(url(s"http://github.com/wellfactored/${name.value}"), s"scm:git@github.com:wellfactored/${name.value}.git"))

pomExtra in ThisBuild :=
  <developers>
    <developer>
      <id>dclinton</id>
      <name>Doug Clinton</name>
    </developer>
  </developers>
