build:
	javac src/main/java/org/example/Main.java -d target
run:
	java -cp target org.example.Main
all: build run
