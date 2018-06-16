# Fernflower Decompiler for Java

View [the video on YouTube](https://www.youtube.com/watch?v=YiaglbXbTbQ)

The first thing you will need is the Fernflower project, which is a component within the [IntelliJ Community project](https://github.com/JetBrains/intellij-community).  You can see the subproject for [Fernflower engine](https://github.com/JetBrains/intellij-community/tree/master/plugins/java-decompiler/engine) on GitHub, but you will need to clone the parent project in order to get it:
```bash
git clone https://github.com/JetBrains/intellij-community
```
Then you will need to build the jar:
```bash
cd intellij-community/plugins/java-decompiler/engine/
gradle build
```
or if you don't want to install Gradle, the Gradle Wrapper can be run instead:
```bash
./gradlew build
```
You will then find your .jar in the **build/libs** folder.  I suggest moving it somewhere convenient, like the home folder:
```bash
mv build/libs/fernflower.jar ~
```
Now you can change directories to a folder containing a jar you want to decompile and run **fernflower.jar** against it.  Make a directory for your results and run the jar command:
```bash
mkdir commons_collections_DECOMPILED/
java -jar ~/fernflower.jar commons-collections4-4.1.jar  commons_collections_DECOMPILED/
```
|java| -jar | ~/fernflower.jar | commons-collections4-4.1.jar | commons_collections_DECOMPILED/
|--|--|--|--|--|
||telling java to run a jar|run fernflower|the jar to decompile| the destination for the output

Change directories into the destination folder and unzip the transformed jar:
```bash
cd commons_collections_DECOMPILED/
unzip commons-collections4-4.1.jar
```
From there, you can load the source into your favorite IDE.
