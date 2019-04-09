import java.io.*;
public class Snakes_and_Ladderss
{
    public static void main (String [] args) throws IOException
    {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        System.out.println ("\t\t\t\t\t\tWelcome To Snakes And Ladders\n\n");
        System.out.println ("\t\t\t\t\t\t\tInstructions:");
        System.out.println ("\t\t\t This program will simulate a regular snakes and ladders game, where you will be");
        System.out.println ("\t\t\t facing other players. You and the players start at square 1, and the first one to");
        System.out.println ("\t\t\t square 100 wins, however, there will be preset squares which will be the snakes or ladders.");
        System.out.println ("\t\t\t Once you land on top of a snake you go down a few squares, and move up if you land");
        System.out.println ("\t\t\t\t\t\t on the bottom of a ladder. Good Luck and Have FUN!!!");      
        int counter= 100,iteration=-1;
        System.out.println ("-----------------------------------------------------Game Board-----------------------------------------------------------------------------");
        while (counter > 0)
        {
            if (counter%10 == 0 && counter != 100)
            {
                if(iteration==-1)
                {
                    counter-=9;
                    iteration=1;
                }
                else
                {
                    System.out.print(counter+"\t");
                    counter-=10;
                    iteration=-1;
                }
                if(counter!=0)
                System.out.print("\n" + counter + "\t");
            }
            else
            System.out.print(counter + "\t"); 
            counter+=iteration;
        }
        System.out.println();
        System.out.println ("----------------------------------------------------------------------------------------------------------------------------------");                  
        String sGame = "y";
        System.out.print ("Do you want to start the game? Y or N     >  ");
        sGame = br.readLine ();
        System.out.print("How many players are there? ");
        int n= Integer.parseInt(br.readLine());
        System.out.println();
        if(n>4 || n<2)
        {    
            System.out.println("Enter number of players wisely (-_-)");
        }
        else
        {
            while (sGame.equals ("y") || sGame.equals ("Y"))
            {
                sGame = startGame(sGame,n);
            }
            System.out.println ("\n\n\t\t\t\t\t\tSEE YA!!");    
        }
    }
    public static String startGame (String start, int n) throws IOException
    {        
        BufferedReader myInput = new BufferedReader (new InputStreamReader (System.in));
        int[] userPosition = {1,1,1,1};
        int diceRoll = 0;
        int userRoll = 1;
        String playAgain = "y";
        int snakesLaddersArray [] = new int [15];
        snakesLaddersArray [0] = 99;
        snakesLaddersArray [1] = 76;
        snakesLaddersArray [2] = 89;
        snakesLaddersArray [3] = 66;
        snakesLaddersArray [4] = 43;
        snakesLaddersArray [5] = 40;   
        snakesLaddersArray [6] = 27;  
        snakesLaddersArray [7] = 54;  
        snakesLaddersArray [8] = 62;  
        snakesLaddersArray [9] = 74;  
        snakesLaddersArray [10] = 42;  
        snakesLaddersArray [11] = 50;  
        snakesLaddersArray [12] = 33;  
        snakesLaddersArray [13] = 13;  
        snakesLaddersArray [14] = 4; 
        int flag=0;
        while (playAgain.equals ("y") || playAgain.equals ("Y"))
        {
            for(int i=0;i<n;i++)
            {
                System.out.print (" Player #"+ (i+1)+ ", Do you want to roll? Y or N     >  ");
                playAgain = myInput.readLine (); 
                if(playAgain.equals ("y") || playAgain.equals ("Y"))
                    flag++;
                if (flag==0)
                    break;
                userRoll =  getDice(diceRoll);
                System.out.println("---------------------------------------------------------------------------------------------------------------------------");                
                System.out.println("\t\t\t\t\t Player #"+ (i+1)+ " Rolled a " + userRoll + "\t\t|");  
                System.out.println("---------------------------------------------------------------------------------------------------------------------------");
                userPosition[i] = userPosition[i] + userRoll;
                userPosition[i] = getP(userPosition[i], userRoll, i, snakesLaddersArray);  
                if (userPosition[i] == 100)
                {
                  for(int j=0;j<n;j++)
                    userPosition[i]=1;
                  System.out.print ("Do you want to play again? Y or N     >  ");
                  playAgain = myInput.readLine ();
                  System.out.print ("\n\n\n\n\n\n\n\n\n\n\n\n");
                }          
            }  
            System.out.println("\t\t\t*************************************************************************");
            for(int j=0;j<n;j++)
                System.out.println ("\t\t\t*\t\tPlayer #"+ (j+1)+ " is currently on square " + userPosition[j] + "\t\t\t*");
            System.out.println("\t\t\t*************************************************************************");
        }
        return playAgain; 
    }
   public static int getDice (int diceRoll)
    {
        diceRoll = (int)(Math.random()*6 )+1 ;
        return diceRoll;
    }
    public static int getP (int userPosition, int userRoll, int i, int snakesLaddersArray []) throws IOException
    {
        if(userPosition == snakesLaddersArray[0])
        {
            userPosition = 41;
            System.out.println ("\t\t\t\t~~~~~~~~~~~~~Player #"+ (i+1)+ " Got Bit By A Snake, GO DOWN!!!~~~~~~~~~~~~~");
        }
        else if (userPosition == snakesLaddersArray[1])
        {
            userPosition = 58;
            System.out.println ("\t\t\t\t~~~~~~~~~~~~~Player #"+ (i+1)+ " Got Bit By A Snake, GO DOWN!!!~~~~~~~~~~~~~");
            
        }
        else if (userPosition == snakesLaddersArray[2])
        {
            userPosition = 53;
            System.out.println ("\t\t\t\t~~~~~~~~~~~~~Player #"+ (i+1)+ " Got Bit By A Snake, GO DOWN!!!~~~~~~~~~~~~~");
        }
        else if (userPosition == snakesLaddersArray[3])
        {
            userPosition = 45;
            System.out.println ("\t\t\t\t~~~~~~~~~~~~~Player #"+ (i+1)+ " Got Bit By A Snake, GO DOWN!!!~~~~~~~~~~~~~");
        }
        else if (userPosition == snakesLaddersArray[4])
        {
            userPosition = 18;
            System.out.println ("\t\t\t\t~~~~~~~~~~~~~Player #"+ (i+1)+ " Got Bit By A Snake, GO DOWN!!!~~~~~~~~~~~~~");
        }
        else if (userPosition == snakesLaddersArray[5])
        {
            userPosition = 3;
            System.out.println ("\t\t\t\t~~~~~~~~~~~~~Player #"+ (i+1)+ " Got Bit By A Snake, GO DOWN!!!~~~~~~~~~~~~~");
        }
        else if (userPosition == snakesLaddersArray[6])
        {
            userPosition = 5;
            System.out.println ("\t\t\t\t~~~~~~~~~~~~~Player #"+ (i+1)+ " Got Bit By A Snake, GO DOWN!!!~~~~~~~~~~~~~");
        }
        else if (userPosition == snakesLaddersArray[7])
        {
            userPosition = 31;
            System.out.println ("\t\t\t\t~~~~~~~~~~~~~Player #"+ (i+1)+ " Got Bit By A Snake, GO DOWN!!!~~~~~~~~~~~~~");
        }
        else if (userPosition == snakesLaddersArray[8])
        {
            userPosition = 81;
            System.out.println ("\t\t\t\t~~~~~~~~~~~~~Player #"+ (i+1)+ " Got A Ladder!! GO UP!!!~~~~~~~~~~~~~");
            
        }
        else if (userPosition == snakesLaddersArray[9])
        {
            userPosition = 92;
            System.out.println ("\t\t\t\t~~~~~~~~~~~~~Player #"+ (i+1)+ " Got A Ladder!! GO UP!!!~~~~~~~~~~~~~");
            
        }
        else if (userPosition == snakesLaddersArray[10])
        {                        
            userPosition = 63;
            System.out.println ("\t\t\t\t~~~~~~~~~~~~~Player #"+ (i+1)+ " Got A Ladder!! GO UP!!!~~~~~~~~~~~~~");
        } 
        else if (userPosition == snakesLaddersArray[11])
        {                        
            userPosition = 69;
            System.out.println ("\t\t\t\t~~~~~~~~~~~~~Player #"+ (i+1)+ " Got A Ladder!! GO UP!!!~~~~~~~~~~~~~");
        }
        else if (userPosition == snakesLaddersArray[12])
        {                        
            userPosition = 49;
            System.out.println ("\t\t\t\t~~~~~~~~~~~~~Player #"+ (i+1)+ " Got A Ladder!! GO UP!!!~~~~~~~~~~~~~");
        }
        else if (userPosition == snakesLaddersArray[13])
        {                        
            userPosition = 46;
            System.out.println ("\t\t\t\t~~~~~~~~~~~~~Player #"+ (i+1)+ " Got A Ladder!! GO UP!!!~~~~~~~~~~~~~");
        }
        else if (userPosition == snakesLaddersArray[14])
        {                        
            userPosition = 25;
            System.out.println ("\t\t\t\t~~~~~~~~~~~~~Player #"+ (i+1)+ " Got A Ladder!! GO UP!!!~~~~~~~~~~~~~");
        } 
        if (userPosition < 0 || userPosition > 106)
        {
            System.out.println ("An error has occured please reset the game!!!!!!");
        }
        else if (userPosition > 100)
        {
            userPosition = userPosition - userRoll;
            System.out.println ("OOPS Player #"+ (i+1)+ " can't jump, you must land on a 100");            
        }
        else if (userPosition == 100)
        {
            System.out.println ("WOOHOOO Player #"+ (i+1)+ " WON, GOOD GAME!!!");            
        }
        return userPosition;
    }
}
