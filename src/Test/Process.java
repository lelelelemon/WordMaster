package Test;

import Model.*;

// the logical relationship
public class Process {
	public void main(String args[]) {
		int number = 26; // denote the number of
		String filename = "";
		User user = new User(number, filename);
		System.out.println('1');
		// user choice query/recite/set
		if (true /* query */) {
			// TO DO
			// if first use no record cannot query, give info and rechoose else show informations 3 forms

		} else if (true/* recite */) {
			// TO DO
			/*
			 * 1. user choose wordList A-Z, setCurWordlist
			 * 2.user choose where to start
			 *  if default, then from last time
			 *  else if user input start{
			 *  a). word doesn't exist, start from last time
			 *  b).right from the chosen word
			 * }
			 * 3. user choose the number 
			 *   if number is legal, start
			 *   else deal with it 
			 * 4.start recite
			 * 	 right info => next
			 * 	 false info => next
			 * 	 end
			 * 5.record result to corresponding file
			 */

		} else if (true/* set */) {

		}
	}

}
