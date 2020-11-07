package arnak;

import java.util.Scanner;

public class Controller
{

	
	public Controller()
	{

	    /**
	     * @param args the command line arguments
	     */
	    public static void main(String[] args) {
	        // TODO code application logic here
	    

	                int turn = -1;


					
			System.out.println("how many players will be playing?");
	                Scanner sc = new Scanner(System.in);
	                int players = sc.nextInt();
			
			//run player.java to set up players information
			boolean winner = false;
			
			//loops to get player turn
			
		while(winner != true)
		{
			
			turn++;
			int playerTurn = turn/players;
			//switch to run actions
			System.out.println("It is player "+ turn + "'s turn");
			
			System.out.println("1 move on main board");
			System.out.println("2 check in market");
			System.out.println("3 check research panel");
			System.out.println("4 check inventory");
			System.out.println("5 Pass");
	                
			int action = sc.nextInt();
			
				switch (action)
				{
				case 1:
					System.out.println("your current position is: ");
					System.out.println("where would you like to go");
	                                //move.location
					//make it so user can see locationa nd decide to move  or return to choose a different action
	                                break;
					
				case 2:
					
					// call market.java to run market purchase
					System.out.println("purchase from market");
	                                //market.check;
	                                // we will want to pull market info in the market file then give the user the option to buy or return to choose a different action
					break;
				case 3:
					// call reasearch.java to run research actions
					
					System.out.println("perform research");
	                                //research.check;
					break;
					//  or return to choose a different action
				case 4:
					System.out.println("check user inventory");
	                                //inventory.check;
					break;
					
				case 5:
					System.out.println("pass");
					break;
				}
	                        if(turn> 4)
	                            turn = turn -4;
			
			
			
	            }
		}
	}

