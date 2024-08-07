# Scala Bootstrap (base / project skeleton)

> [!IMPORTANT]  
> Project deprecated in favor of [Codely Scala Basic Skeleton (powered by Giter 8)](https://github.com/CodelyTV/scala-basic-skeleton.g8)

[![Software License][ico-license]][link-license]
[![Build Status][ico-travis]][link-travis]
 
## Introduction 

This is a repository intended to serve as a starting point if you want to bootstrap a project in Scala.
 
It could be useful if you want to start from scratch a kata or a little exercise or project. The idea is that you don't have to worry about the boilerplate, just clone this repo and there you go:
* Latest versions of Scala, SBT and ScalaTest in order to practice with them
* Best practices applied:
  * [`README.md`][link-readme] (badges included)
  * [`LICENSE`][link-license]
  * [`build.sbt`][link-build-sbt]
  * [`scalastyle-config.xml`][link-scalastyle-config]
  * [`.scalafmt.conf`][link-scalafmt-config]
  * [`.gitignore`][link-gitignore]
  * [`.editorconfig`][link-editorconfig]
  * [`.travis.yml`][link-travis-yml]

## How To Start

[Video screencast](http://codely.tv/screencasts/entorno-scala/) (in Spanish) 

1. Clone this repository `git clone https://github.com/CodelyTV/scala_bootstrap`.
2. Run [SBT](http://www.scala-sbt.org/) on the project directory `sbt`.
3. Run the [scalatests](http://www.scalatest.org/) with `t`.
4. Check the [scalastyle](http://www.scalastyle.org/) in the production code with `s` and use the `ts` command to check the test code style.
5. Check the [scalaFmt](http://scalafmt.org) with `tf` command to check the code style and apply guidelines with `f`.
6. Start your project!

## Pre-push Git hook

There's one Git hook included. It's inside the `doc/hooks` folder and it will run the `prep` SBT task before pushing to any remote.

This `prep` task is intended to run all the checks you consider before pushing. At this very moment, it try to compile and check the code style rules with ScalaStyle and ScalaFmt.
 
You can define what this task does just modifying the `prep` task in the `build.sbt` file. We like the approach of just running 1 single SBT task as the hook instead of multiple tasks because it's more efficient (the hook doesn't has to run SBT multiple times), and also because this way we can control the pre push tasks just with the SBT alias defined at the `build.sbt` without altering the hooks.
 
If you want to install this hook, just `cd doc/hooks` and run `./install-hooks.sh`.

## Other programming languages

* [Scala g8 template](https://github.com/CodelyTV/scala-bootstrap-template.g8) Useful to bootstrap your project with the `sbt new` command!
* [PHP](https://github.com/CodelyTV/php-bootstrap)
* [Scala](https://github.com/CodelyTV/scala_bootstrap)

## About

This hopefully helpful utility has been developed by [CodelyTV][link-author] and [contributors][link-contributors].

We'll try to maintain this project as simple as possible, but Pull Requests are welcomed!

## License

The MIT License (MIT). Please see [License File][link-license] for more information.

[ico-license]: https://img.shields.io/badge/license-MIT-brightgreen.svg?style=flat-square
[ico-travis]: https://img.shields.io/travis/CodelyTV/scala_bootstrap/master.svg?style=flat-square

[link-license]: LICENSE
[link-travis]: https://travis-ci.org/CodelyTV/scala_bootstrap
[link-readme]: README.md
[link-build-sbt]: build.sbt
[link-scalastyle-config]: scalastyle-config.xml
[link-scalafmt-config]: .scalafmt.conf
[link-gitignore]: .gitignore
[link-editorconfig]: .editorconfig    
[link-travis-yml]: .travis.yml           
[link-author]: https://github.com/CodelyTV
[link-contributors]: ../../contributors
