
resolvers += "Typesafe Repository" at "https://repo.typesafe.com/typesafe/releases/"

addSbtPlugin("com.typesafe.sbt" % "sbt-git" % "1.0.0")
addSbtPlugin("com.jsuereth" % "sbt-pgp" % "1.1.2")
addSbtPlugin("org.xerial.sbt" % "sbt-sonatype" % "2.3")
addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.5.1")
addSbtPlugin("com.codacy" % "sbt-codacy-coverage" % "1.3.15")
addSbtPlugin("org.tpolecat" % "tut-plugin" % "0.6.11")
addSbtPlugin("io.get-coursier" % "sbt-coursier" % "1.1.0-M7")
addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.9.2")
addSbtPlugin("de.heikoseeberger" % "sbt-header" % "5.2.0")
addSbtPlugin("org.wartremover" % "sbt-wartremover" % "2.4.1")
addSbtPlugin("com.geirsson" % "sbt-scalafmt" % "1.5.1")
