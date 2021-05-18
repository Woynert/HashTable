#!/bin/bash
#compile clases and then run the main

#check main exists
if [ -f "main.class" ]
then
	rm main.class
fi

#compile packages
javac -d ./ ./src/*.java 

#run main
java main.java
