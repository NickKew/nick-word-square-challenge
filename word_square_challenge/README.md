The word_square_challenge solution is a way of producing a word square for a provided square size and the letters encompassed in the square.

A word square is a square of valid English language words where it is read the same from left to right, as it is from top to bottom.

A word square example is as follows: 

Grid size - 4
Letters to fill into the square - eeeeddoonnnsssrv

Valid Word Square: 

r o s e
o v e n
s e n d 
e n d s

Running the application: 

The application will need to be compiled into a local jar. The steps to do this are:
1) Copy the repository to your local machine.
2) Change directory to the src level of the application. 
3) Run the following: javac main/java/runner/WordSquareRunner.java

The application takes arguments to run, but it can take either: 
1) A square size argument, and a set of letters to fill the square.
2) The location for a txt file of word squares to solve, where each line is a square size argument and a set of letters to fill the square.

Some examples to run the app are: 

1) To solve the example stated above, use: 
	java main/java/runner/WordSquareRunner 4 eeeeddoonnnsssrv
	
2) There is a txt file in the src/main/resources folder for the repository. To run the app on this file, use:
	java main/java/runner/WordSquareRunner /main/resources/example.txt

	
Note: 

The algorithm is designed to find all of the possible word squares for the provided square parameters.
This can be tweaked, such that if you only wanted to find a single square that is possible. 

It will drastically reduce the runtime, but for completeness I wanted an algorithm that found them all. 