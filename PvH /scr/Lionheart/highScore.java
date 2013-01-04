package Lionheart;

import java.awt.GridLayout;
import java.io.*;
import java.util.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class highScore
{

	int i=0;
	String[] names = new String[10];
	int[] scores= new int[10];
public void load(String fileName)throws IOException
{
    // this is creating a new scanner read and write the file
	Scanner inFile = new Scanner(new InputStreamReader(new FileInputStream(fileName)));
	// this will keep goin as long as there is a next line
	while(inFile.hasNextLine())
	{
		String playerName= inFile.nextLine();// this will take the next line in the txt file and save it in playerName
		String playerScore= inFile.nextLine();//this will take the next line in the txt file and save it in playerScore

		names[i] = playerName; // this will take the playerName and save it to position i int the String array called names
		scores[i] =Integer.parseInt(playerScore);// this takes the String from playerScore and change it into an int then store it in the scores int array position i
		
		i++;//i plus 1
	}
	inFile.close();//closes the file
    BubbleSort();//calls the bubblesort method
	
    i=0;// resets i back to 0
    save("./highscore.txt"); // calls the save method 
    
}

private void save(String fileName) throws IOException
{
    //this is creating a new scanner read and write the file
	PrintWriter outFile = new PrintWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
	
	// this for loop will contine for as long the array scores is
	for (int i=0;i<scores.length; i++)
	{
		String n=Integer.toString(scores[i]);// this converts the int in the scores array to a String
		outFile.write(names[i]);//this writes the names of the String in the names array
		outFile.write(System.getProperty("line.separator"));//writes in a blank space on the next line
		outFile.write(n);// writes the String in n to the txt file
		outFile.write(System.getProperty("line.separator"));//writes in a blank space on the next line
			
	}
outFile.close();// this closes the file
}
    
private void BubbleSort()
{
        int j;
        boolean flag = true;   
        int temp;// this hold an int which is being swapped
    String sTemp;// this hold an String which is being swapped
        while ( flag )// this will keep goin as long as the swapping occurs 
        {
            flag= false;  // changes flag to false   
            for(j=0;j<scores.length-1;j++)
            {
                if (scores[j] < scores[j+1])  // if the score at j is less than the score at j+1 then they swap
                {
                    // this bit of code take the smaller value stores it the swaps it with the bigger value and the two positions it uses it will swap the names stored in the names array
                    temp = scores[j]; 
                    sTemp = names[j];
                    scores[j] = scores[j+1];
                    names[j]= names[j+1];
                    scores[j+1] = temp;
                    names[j+1]= sTemp;
                    flag = true;   // this will change the flag back to true              
                } 
            } 
        } 
    } 
    
public void checkHS(int score) throws IOException
{
	
	JTextField name = new JTextField("Enter Name:", 20);
        // if the score from the game is higher than the bottom int in the scores array
        if (score>scores[9])
        {   
            //this has to load the file then ask for the users name put the name and take the score and put them in the last position in both arrays. runs the bubble sort then saves it to the file
            load("highscore.txt");
            
            JPanel myPanel = new JPanel();
        	myPanel.setLayout(new GridLayout(1, 1));
            myPanel.add(name);
            JOptionPane.showMessageDialog(null, myPanel, "Enter Name",
        			JOptionPane.CLOSED_OPTION);
        	
            names[9]= name.getText();
            scores[9]=score;
            BubbleSort();
            save("highscore.txt");
            outTxtFile();
        }
        else
        {
            System.out.println("Better Luck Next Time");// if not then it will out put better luck next time
        }
    
    }
    // this methods will just output the names and their score
public void outTxtFile()
{
    
    JLabel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10;

	JPanel myPanel = new JPanel();
	myPanel.setLayout(new GridLayout(10, 1));
	p1=new JLabel("1. "+names[0]+"  -  "+scores[0]);
	p2=new JLabel("2. "+names[1]+"  -  "+scores[1]);
	p3=new JLabel("3. "+names[2]+"  -  "+scores[2]);
	p4=new JLabel("4. "+names[3]+"  -  "+scores[3]);
	p5=new JLabel("5. "+names[4]+"  -  "+scores[4]);
	p6=new JLabel("6. "+names[5]+"  -  "+scores[5]);
	p7=new JLabel("7. "+names[6]+"  -  "+scores[6]);
	p8=new JLabel("8. "+names[7]+"  -  "+scores[7]);
	p9=new JLabel("9. "+names[8]+"  -  "+scores[8]);
	p10=new JLabel("10. "+names[9]+"  -  "+scores[9]);
	
	
	myPanel.add(p1);
	myPanel.add(p2);
	myPanel.add(p3);
	myPanel.add(p4);
	myPanel.add(p5);
	myPanel.add(p6);
	myPanel.add(p7);
	myPanel.add(p8);
	myPanel.add(p9);
	myPanel.add(p10);
	
	JOptionPane.showMessageDialog(null, myPanel, "Hightscores",
			JOptionPane.CLOSED_OPTION);
	
}
}


