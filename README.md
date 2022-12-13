# lotr-sdk

### Purpose
This Java SDK makes it easier to access the Lord of the Rings (LOTR) API from the https://the-one-api.dev site.  Under the covers, it uses the Java HttpClient sendAsync method to access the API and returns simple Plain Old Java Objects (POJOs).

The SDK library is availble on MavenCentral at https://search.maven.org/search?q=g:io.github.stasoko:
- group id:  io.github.stasoko
- artifact id:  lotr-sdk
- version: 1.0.0

To access using maven, add the following to the dependencies section of your pom.xml:
~~~
<dependency>
  <groupId>io.github.stasoko</groupId>
  <artifactId>lotr-sdk</artifactId>
  <version>1.0.0</version>
</dependency>
~~~

To access using gradle, add the following to your build.gradle file:
~~~
implementation("io.github.stasoko:lotr-sdk:1.0.0")
~~~

Please contact stacey.sokoloff@gmail.com with any questions.