all: build run
build:
	javac -d target -s src src/main/java/org/example/*.java
run:
	java -cp target org.example.Main
test: build
	java -cp target org.example.Main -grammar ./src/main/resources/grammar.txt ./src/main/resources/lang
test-usage: build
	java -cp target org.example.Main -h
test-grammar: build
	java -cp target org.example.Main -grammar ./src/main/resources/grammar.txt
test-grammar-empty: build
	java -cp target org.example.Main -grammar
