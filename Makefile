all: build run
build:
	javac -d target -s src src/main/java/org/example/*.java
run:
	java -cp target org.example.Main
