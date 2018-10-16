import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.Random; 

public class mainserverCode{

	private static int n = 0;  
    	  
	private static int rock = 0; //integer for the variable rock 
	private static int paper = 1; //integer for the variable paper 
	private static int scissor = 2; //integer for the variable scissor 


	//the user and computer pick don't have fixed values
	//since the user should be able to pick his own number
	//and the computer will pick from a random number (explained later)
		
	private static ServerSocket serverSocket; 
	private static int gameResult;
	
	
	
	public static void main(String[] args) {
	
	
		while(true) {

		try {
			
		 DataOutputStream toClient = null;
		 DataInputStream fromClient = null;
		
	     ServerSocket serverSocket = new ServerSocket(2015);
	     
	     Socket socket = serverSocket.accept();
	 	 System.out.println("Client Connected");
	 	 
	 	 Scanner sc = new Scanner(socket.getInputStream());
	 	 String username = sc.nextLine();
	 	 
	 	 
	 	
	 	
	 	 fromClient = new DataInputStream(socket.getInputStream());
	 	 toClient = new DataOutputStream(socket.getOutputStream());
	 	
	 	//String username = fromClient.readLine();
	     
	 	System.out.println(username);
	     String player1_username = username + "fucking sany man";
	     String player2_username = username + "idk";
	     String player3_username = username + "oke";
	     
	     PrintStream p = new PrintStream(socket.getOutputStream());
	 	 p.println(player1_username);
	     
	     // toClient.writeUTF(player1_username);
	     // toClient.writeUTF(player2_username);
	     // toClient.writeUTF(player3_username);
	 	 
	 	 int tool = fromClient.readInt();
	     
	     int player1_tool = tool + 0;
	     int player2_tool = tool + 1;
	     int player3_tool = tool +2;
	     
	   
	     
	     toClient.write(player1_tool);
	     toClient.write(player2_tool);
	     toClient.write(player3_tool);
	     
	    
	     
	     
	     

	     //this creates the scanner object used to scan text. In the constructor is has System.in which is used to make the console able to retrieve data from the keyboard input
	     
	     
	     	//below is the main calculations of the game made through an if, else if and else statement
	     	
	     /*	//this first if statement checks if the userPick and computerPick int is set to the same value
	     	if ( userPick==computerPick ) 
	     	{
	     	  //if they are equal to the same number the console will print "Draw Game"
	     	  System.out.println("Draw Game"); 
	     		}
	     	
	     	//the else if statement is used to check the three outcomes where the user would win
	     	//this is done through &&/and commands, checking if the user has e.g rock and the computer got scissor 
	     	//the user will then set to have won following the basic principles of rock, paper, scissors.	
	     	else if ( (userPick==rock && computerPick==scissor) || (userPick==scissor && computerPick==paper) 
	     			|| (userPick==paper && computerPick== rock) )
	     		{
	     			System.out.println("You Win"); //simple console print that lets the user know he/she won
	     		}	
	     			//else statement that is called if the none of the above statements are the case,
	     			//the only option left is that the computer has won
	     			else
	     			{
	     			//console print showing the user that the computer won
	     			System.out.println("The Computer Wins"); 
	     					}  	 
	       }
	       
	       */
	     
	    //int player3_tool = 0;
		//int player2_tool = 0;
		//int player1_tool = 0;
		//TIE FOR ALL
	     if((player1_tool == 0 && player2_tool == 0 && player3_tool == 0) ||
	    	(player1_tool == 0 && player2_tool == 2 && player3_tool == 1) ||
	    	(player1_tool == 0 && player2_tool == 1 && player3_tool == 2) ||
	        (player1_tool == 1 && player2_tool == 1 && player3_tool == 1) ||
	        (player1_tool == 1 && player2_tool == 0 && player3_tool == 2) ||
	        (player1_tool == 1 && player2_tool == 2 && player3_tool == 0) ||
	        (player1_tool == 2 && player2_tool == 2 && player3_tool == 2) ||
	        (player1_tool == 2 && player2_tool == 1 && player3_tool == 0) ||
	        (player1_tool == 2 && player2_tool == 0 && player3_tool == 1) ) {
	    	 gameResult = 0;
	    	 
	     }
	     
	     //PLAYER 1 WIN
	     if((player1_tool == 0 && player2_tool == 2 && player3_tool == 2) ||
	    	(player1_tool == 1 && player2_tool == 0 && player3_tool == 0) ||
	    	(player1_tool == 2 && player2_tool == 1 && player3_tool == 1) ) {
	    	 gameResult = 1;
	    	 
	     }
	     
	     //PLAYER 2 WIN
	     if((player1_tool == 0 && player2_tool == 1 && player3_tool == 0) ||
	    	(player1_tool == 1 && player2_tool == 2 && player3_tool == 1) ||
	    	(player1_tool == 2 && player2_tool == 0 && player3_tool == 2) ) {
	    	 gameResult = 2;
	    	
	     }
	     
	     //PLAYER 3 WIN
	     if((player1_tool == 0 && player2_tool == 0 && player3_tool == 1) ||
	 	    (player1_tool == 1 && player2_tool == 1 && player3_tool == 2) ||
	 	    (player1_tool == 2 && player2_tool == 2 && player3_tool == 0) ) {
	 	    	 gameResult = 3;
	 	    	
	 	 }
	 	     
	     //PLAYER 2 & PLAYER 3 TIE
	     if((player1_tool == 0 && player2_tool == 1 && player3_tool == 1) ||
	 	 	(player1_tool == 1 && player2_tool == 2 && player3_tool == 2) ||
	 	 	(player1_tool == 2 && player2_tool == 0 && player3_tool == 0) ) {
	 	 	    	 gameResult = 4;
	 	 	    	
	 	 	 }
	     
	     //PLAYER 1 & PLAYER 2 TIE
	     if((player1_tool == 0 && player2_tool == 0 && player3_tool == 2) ||
	 	 	(player1_tool == 1 && player2_tool == 1 && player3_tool == 0) ||
	 	 	(player1_tool == 2 && player2_tool == 2 && player3_tool == 1) ) {
	 	 	    	 gameResult = 5;
	 	 	    	
	 	 	 }
	     
	     //PLAYER 1 & PLAYER 3 TIE
	     if((player1_tool == 0 && player2_tool == 2 && player3_tool == 0) ||
	 	 	(player1_tool == 1 && player2_tool == 0 && player3_tool == 1) ||
	 	 	(player1_tool == 2 && player2_tool == 1 && player3_tool == 2) ) {
	 	 	    	 gameResult = 6;
	 	 	    	
	 	 	 }
		}
	    
	    catch(IOException e) {
	      System.err.println(e);
	    }
	  
		
}
		
	}
}