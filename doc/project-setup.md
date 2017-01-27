# Let's install scala!

1. JDK
  - do java -version, you should expect to see something like:
    java version "1.8.0_102" 
  
2. SBT -> Scala Build Tool (dependencies, compile tasks)
  - mac => brew install sbt
  - linux => go to sbt website :)

3. Fork the project
  - Go to http://github.com/letgoapp/scala_course
  - Click on fork
  - Git clone your fork
  - `cd scala_course`
  - run `sbt`
  - once inside the sbt console => run 'test'

4. Install IntelliJ
  - mac & linux => https://www.jetbrains.com/idea/#chooseYourEdition
  - install scala plugin (go to preferences -> plugins -> search for "Scala")

5. Open repo in IntelliJ
  - go to `File` -> `Open… -> click on build.sbt in the folder
  - click OK on everything
  - try to run tests from inside intellij
    - right click on 
      src/test/scala/tv/codely/scala_bootstrap/CodelyberTest
    - run it as test

6. When you are able to run the tests, feel free to go ;)



# Troubleshooting
* If you have problems about unresolved dependencies while installing sbt:
    - Add this into file ~/.sbt/repositories
```
[repositories]
  local
  sbt-releases-repo: http://repo.typesafe.com/typesafe/ivy-releases/, [organization]/[module]/(scala_[scalaVersion]/)(sbt_[sbtVersion]/)[revision]/[type]s/[artifact](-[classifier]).[ext]
  sbt-plugins-repo: http://repo.scala-sbt.org/scalasbt/sbt-plugin-releases/, [organization]/[module]/(scala_[scalaVersion]/)(sbt_[sbtVersion]/)[revision]/[type]s/[artifact](-[classifier]).[ext]
  maven-central: http://repo1.maven.org/maven2/
```
  
  
