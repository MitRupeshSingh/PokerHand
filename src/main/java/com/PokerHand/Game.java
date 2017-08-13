package com.PokerHand;

import java.util.Scanner;


public class Game {

	/**
	 * @param args
	 */
      private static String WinnerHand=""; // saves the winner hand after comparison
	
      public static void main(String[] args) {
		
		  // TODO Auto-generated method stub
	      int PlayerNumber=0;

	      Scanner input = new Scanner(System.in);
	      System.out.println("Enter the number of players:");//input number of players
	      Integer numPlay = input.nextInt();
	      input.nextLine();

	      System.out.println("Enter value and suit of each card seperated by space:");//input cards suites and values
	      System.out.println("Example: 8H 9S JD KC AD");
	      String[] Players = new String[numPlay];
	      while(numPlay!=PlayerNumber){
		  Players[PlayerNumber]=input.nextLine();
		  PlayerNumber++;
	      }
	      winnerHand(Players);
	      input.close();
	      System.out.println(WinnerHand);
        }
	
	
	public static void winnerHand(String[] players){
		
		  int PlayerNumber=0;
		  String[] car = new String[5]; // takes the string and separates and save the value in array 
		  Card[] cards1 = new Card[5]; // saves the card for two hand
		  Card[] cards2 = new Card[5];
		  Hand h1=new Hand();// initiate with two hand
		  Hand h2=new Hand(); // saves the hand value after comparison
		  String hand1="",hand2=""; //saves hand value
		  for(int i=1;i<=players.length;i++){ // loop through every players
		    	  car=players[i-1].split(" ");
			  if(car.length!=5) System.out.println("Cards size should be 5");
		    	  if(i==1){
			    	  cards2=Card.compare(car);  
			    	  h2 = new Hand(cards2);
			    	  hand2= h2.display();
			    	  PlayerNumber=i;
		    	  }else{
			    	  cards1=Card.compare(car);  
			    	  h1 = new Hand(cards1);
			    	  hand1= h1.display();
		    	  }
		    	  if(i>1){// if player is greater than 1 then compare the hand
		        	  if(h1.compareTo(h2)==1){
		        		  WinnerHand="Player "+i+" wins: "+hand1;
		        		  h2=new Hand(cards2);
		        		  PlayerNumber=i;
		        	  }else if(h1.compareTo(h2)==-1){
		        		  WinnerHand="Player "+PlayerNumber+" wins: "+hand2;		        		  
		        	  }else{
		        		  WinnerHand="Player ties between "+i+" and "+PlayerNumber;
		        	  }
		    	  }
		   }
		    	   
	}
	
	

}

