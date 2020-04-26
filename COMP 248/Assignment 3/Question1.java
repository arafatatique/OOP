// ------------------------------------------------
// Assignment 3
// Written by: Arafat Atique 40132573
// For COMP 248 Section P - Fall 2019
// Due: November 4 2019
// ------------------------------------------------

//This program will generate random passwords from a three-dimensional array 
import java.util.Random;
public class Question1
{
    public static void main(String[] args) {
    	//Defining the array and its contents 
    	final String[][][] book= {
	    		{
	    			{"ALICE was beginning to get very tired of sitting by her sister on the\n",
	    			"bank, and of having nothing to do. Once or twice she had peeped into the\n",
	    			"book her sister was reading, but it had no pictures or conversations in\n",
	    			"it, \"and what is the use of a book,\" thought Alice, \"without pictures or\n",
	    			"conversations?\"\n"},
	    			{"So she was considering in her OWN mind (as well as she could, for the\n",
	    			"day made her feel very sleepy and stupid), whether the pleasure of\n",
	    			"making a daisy-chain would be worth the trouble of getting up and\n",
	    			"picking the daisies, when suddenly a White Rabbit with pink eyes ran\n",
	    			"close by her.\n"},
	    			{"There was nothing so very remarkable in that, nor did Alice think it so\n",
	    			"very much out of the way to hear the Rabbit say to itself, \"Oh dear! Oh\n",
	    			"dear! I shall be too late!\" But when the Rabbit actually took a watch\n",
	    			"out of its waistcoat-pocket and looked at it and then hurried on, Alice\n",
	    			"started to her feet, for it flashed across her mind that she had never\n",
	    			"before seen a rabbit with either a waistcoat-pocket, or a watch to take\n",
	    			"out of it, and, burning with curiosity, she ran across the field after\n",
	    			"it and was just in time to see it pop down a large rabbit-hole, under\n",
	    			"the hedge. In another moment, down went Alice after it!"}
	    			},
	    			{
	    			{"\"WHAT a curious feeling!\" said Alice. \"I must be shutting up like a\n",
	    			"telescope!\"\n"},
	    			{"And so it was indeed! She was now only ten inches high, and her face\n",
	    			"brightened up at the thought that she was now the right size for going\n",
	    			"through the little door into that lovely garden.\n"},
	    			{"After awhile, finding that nothing more happened, she decided on going\n",
	    			"into the garden at once; but, alas for poor Alice! When she got to the\n",
	    			"door, she found she had forgotten the little golden key, and when she\n",
	    			"went back to the table for it, she found she could not possibly reach\n",
	    			"it: she could see it quite plainly through the glass and she tried her\n",
	    			"best to climb up one of the legs of the table, but it was too slippery,\n",
	    			"and when she had tired herself out with trying, the poor little thing\n",
	    			"sat down and cried.\n"},
	    			{"\"Come, there's no use in crying like that!\" said Alice to herself rather\n",
	    			"sharply. \"I advise you to leave off this minute!\" She generally gave\n",
	    			"herself very good advice (though she very seldom followed it), and\n",
	    			"sometimes she scolded herself so severely as to bring tears into her\n",
	    			"eyes.\n"},
	    			{"Soon her eye fell on a little glass box that was lying under the table:\n",
	    			"she opened it and found in it a very small cake, on which the words \"EAT\n",
	    			"ME\" were beautifully marked in currants. \"Well, I'll eat it,\" said\n",
	    			"Alice, \"and if it makes me grow larger, I CAN reach the key; and if it\n",
	    			"makes me grow smaller, I can creep under the door: so either way I'll\n",
	    			"get into the garden, and I don't care which happens!\"\n"},
	   				{"She ate a little bit and said anxiously to herself, \"Which way? Which\n",
	   				"way?\" holding her hand on the top of her head to feel which way she was\n",
	   				"growing; and she was quite surprised to find that she remained the same\n",
	   				"size. So she set to work and very soon finished off the cake."}
    				},	    				
	    			{
	    			{"The King and Queen of Hearts were seated on their throne when they\n",
	    			"arrived, with a great crowd assembled about them--all sorts of little\n",
	    			"birds and beasts, as well as the whole pack of cards: the Knave was\n",
	   				"standing before them, in chains, with a soldier on each side to guard\n",
	   				"him; and near the King was the White Rabbit, with a trumpet in one hand\n",
	   				"and a scroll of parchment in the other. In the very middle of the court\n",
	   				"was a table, with a large DISH of tarts upon it. \"I wish they'd get the\n",
    				"trial done,\" Alice thought, \"and hand 'round the refreshments!\"\n"},	    				
	    			{"The judge, by the way, was the King and he wore his crown over his great\n",
	    			"wig. \"That's the jury-box,\" thought Alice; \"and those twelve cratures\n",
	    			"(some were animals and some were birds) I suppose they are the jurors.\"\n"},
	    			{"Just then the White Rabbit cried out \"Silence in the court!\"\n"},
	    			{"\"HERALD! read the accusation!\" said the King."}
	    		}
	    		};
    	System.out.println("Welcome to the password generator game!");
    	System.out.println();
    	int []total= {0}; //An array to keep track of total passwords generated 
	    Random r=new Random(); //Random variable to generate new passwords 
        //This for loop will be used to generate 10000 passwords 
	    for(int i=0;i<10000;i++){
            int[] counts={0,0,0,0,0,0,0};	//This array will be used to keep track of seven counts to record the number of conditions a password failed to satisfy
            String password="";
            int j=0;
            String[] pass=new String[3];	//to store the three words
           
            
            
            while(true){
                int page=r.nextInt(book.length); //Generating a random page 
                int paragraph=r.nextInt(book[page].length); //Generating a random paragraph 
                int lines=r.nextInt(book[page][paragraph].length); //Generating a random line
                String[] words=book[page][paragraph][lines].split(" ",0); //Store the word of that specific line generated 
                int index=r.nextInt(words.length);
                //If statement to make sure a word contains more than one character 
                if(words[index].length()<=1){
                    counts[1]++;  
                    continue;
                }
                //if statement to make sure the chosen word does not contain \n 
                if(words[index].indexOf('\n')!=-1)
                {
                    counts[0]++;                   
                    continue;
                }
                //Series of if statements to make sure no two words are exactly the same 
                pass[j++]=words[index];
                if(j==3){
                    if(pass[0].compareTo(pass[1])==0){
                        j=0;
                        counts[2]++;
                        continue;
                    }
                   
                    if(pass[2].compareTo(pass[1])==0){
                        j=0;
                        counts[2]++;
                        continue;
                    }
                   
                    if(pass[0].compareTo(pass[2])==0){
                        j=0;
                        counts[2]++;
                        continue;
                    }
                    //If statement to make sure the password contains 8 to 16 characters
                    int len=pass[0].length()+pass[1].length()+pass[2].length();
                    if(len<8 || len>16){
                        j=0;
                        counts[6]++;
                        continue;
                    }
                    //If statement and loop to make sure the password contains a special character 
                    password=pass[0]+pass[1]+pass[2];
                    boolean upper=false,lower=false; 
                    int countSpecial=0; //This count will be used to keep track of the special character requirement 
                    for(int k=0;k<password.length();k++){
                       char c=password.charAt(k);
                       if(c>='A' && c<='Z')
                        upper=true;
                       else if(c>='a' && c<='z')
                        lower=true;
                       else
                            countSpecial++;
                    }
                    //If statement to make sure the password contains an uppercase character 
                    if(!upper){
                        counts[3]++;
                        j=0;
                        continue;
                    }
                    //If statement to make sure the password contains a lowercase character 
                    if(!lower){
                        counts[4]++;
                        j=0;
                        continue;
                    }
                    //If statement and loop to make sure the password contains a special character 
                    if(countSpecial!=1){
                        counts[5]++;
                        j=0;
                        continue;
                    }
                    break;
                }
               
            }
            //Displaying the password 
            System.out.println("Password =  "+password+ "\t\t Newline = "+counts[0]+"\t\t Single = "+counts[1]+"\t\t Equal = "+counts[2]+"\t\t Length = "+counts[6]+ "\t\t Upper = "+counts[3]+"\t\t Lower = "+counts[4]+"\t\t Special = "+counts[5]);
            total[0]++;
            //The program will stop generating passwords if the the lowercase character requirement fails 
            if(counts[4]!=0)
                break;
          
            
        }
       System.out.println();
       System.out.println("Total passwords generated: "+total[0]);
       System.out.println();
       System.out.println("Thank you for using the password generator game. Good bye.");
    }
}