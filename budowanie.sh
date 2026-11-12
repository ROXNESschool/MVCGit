mkdir -p out lib
javac -encoding UTF-8 -cp "lib/*" -d out $(find src -name "*.java")
jar cfm Pracownicy.jar MANIFEST.MF -C out .
java -jar Pracownicy.jar
