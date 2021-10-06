# SwEng: in-class exercises on testing

Clone this repo with:

```
git clone https://github.com/sweng-epfl/testing-lecture-exercises
cd testing-lecture-exercises
```

Then, run it on the command-line using the Gradle build tool. No need to download anything, as you will use the Gradle "wrapper" that downloads the right version of Gradle for you:

```
# === Windows ===
# compile + run tests + get code coverage
gradlew.bat build
# compile + run the main method
gradlew.bat run

# === Linux / macOS (incl. Windows Subsystem for Linux) ===
# same comments as above
./gradlew build
./gradlew run
```

You can (and should) use your favorite development environment to do these exercises, for instance:
- In IntelliJ (and Android Studio), select "Open" and pick this folder
- In Eclipse, use the File menu >> Import >> Gradle >> Existing Gradle Project, and pick this folder

No need to edit any code before the class; just make sure you can build and run the project.
If you cannot, tell us on the course forum and we'll help you.

See you in class!
