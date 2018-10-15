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
	private static int userPick; // integer for the users pick 
    private static int computerPick; // integer for the computer pick

	private static ServerSocket serverSocket; 
	public static void main(String[] args) {
	
		System.out.println("Server started");
		while(true) {

		try {

			DataInputStream isFromServer = new DataInputStream(socket.getInputStream());
			 DataOutputStream osToServer = new DataOutputStream(socket.getOutputStream());
			 
			 
	     serverSocket = new ServerSocket(4005);
	     
	     Socket socket = serverSocket.accept();
	     
	     Scanner sc = new Scanner(socket.getInputStream());
	     int number = sc.nextInt();
	     int temp = number*2;
	     PrintStream p = new PrintStream(socket.getOutputStream());
	     p.println(temp);
	     
	     
	     System.out.println("Client connected");	 
		 n++;
	     System.out.println("Connected to a client " + n );
	   

	     //this creates the scanner object used to scan text. In the constructor is has System.in which is used to make the console able to retrieve data from the keyboard input
	     Scanner qScan = new Scanner(System.in); 
	     //creates the random object that is used to generate random numbers 
	     Random qRand = new Random();
	     
	     	//below is the main calculations of the game made through an if, else if and else statement
	     	
	     	//this first if statement checks if the userPick and computerPick int is set to the same value
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
	    
	    catch(IOException e) {
	      System.err.println(e);
	    }
	  }
	}

}
