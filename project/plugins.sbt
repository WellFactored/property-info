
resolvers += "Typesafe Repository" at "https://repo.typesafe.com/typesafe/releases/"

addSbtPlugin("com.typesafe.sbt" % "sbt-git" % "1.0.0")
addSbtPlugin("com.jsuereth" % "sbt-pgp" % "1.1.2")
addSbtPlugin("org.xerial.sbt" % "sbt-sonatype" % "2.5")
addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.5.1")
addSbtPlugin("com.codacy" % "sbt-codacy-coverage" % "2.112")
addSbtPlugin("org.tpolecat" % "tut-plugin" % "0.6.12")
addSbtPlugin("io.get-coursier" % "sbt-coursier" % "2.0.0-RC2-1")
addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.9.2")
addSbtPlugin("de.heikoseeberger" % "sbt-header" % "5.2.0")
addSbtPlugin("org.wartremover" % "sbt-wartremover" % "2.4.2")
addSbtPlugin("com.geirsson" % "sbt-scalafmt" % "1.5.1")
