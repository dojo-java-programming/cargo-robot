# Tutorial Cargo Robot

<img  src="https://github.com/dojo-java-programming/cargo-robot/blob/master/src/documentation/image/cargo-bot-level-easy-00.png" />


## Background

A clone of the iPhone / iPad [cargo-bot](https://www.google.nl/search?q=cargo+bot&tbm=isch&tbo=u&source=univ&sa=X&ved=0ahUKEwjYwYWsg8PJAhVFgA8KHUvzD6QQsAQINg&biw=1342&bih=985) App.

To get an idea of the App see some of the [videos](https://www.google.nl/search?q=cargo+bot&biw=1342&bih=985&tbm=vid&source=lnms&sa=X&ved=0ahUKEwjVy-ytg8PJAhUGRQ8KHRLaAyYQ_AUICCgC&dpr=1)


## TestNG

This project uses [TestNG](http://testng.org) as Unit Testing library.


## Maven Modules

- `cargo-robot-computer`  
  The Computer must be programmed with the *Cargo Robot Language*  
  The Computer sends Cargo Robot Commands to the Cargo Robot Simulator
- `cargo-robot-core`  
  Core module containing the Cargo Robot Simulator
- `cargo-robot-cucumber`  
  Functional features in form of scenarios  
  For functional testing using [Behavior-Driven Development](https://en.wikipedia.org/wiki/Behavior-driven_development)
- `cargo-robot-language`  
  Cargo Robot Language written in [ANTLR](https://www.antlr.org/) v4  
  Should be used to program the Cargo Robot Computer