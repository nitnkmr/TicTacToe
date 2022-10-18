package TicTacToe;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameFrame {
	//creating list for checking win conditions
	static ArrayList<Integer> playerPosition=new ArrayList<>();
	static ArrayList<Integer> cpuPosition=new ArrayList<>();

	public static void main(String[] args) {
		//Creating Game Board and Printing it..
		char[][] frame = { { ' ', '|', ' ', '|', ' ' }, { '-', '+', '-', '+', '-' }, { ' ', '|', ' ', '|', ' ' },
				{ '-', '+', '-', '+', '-' }, { ' ', '|', ' ', '|', ' ' } };
		printGameFrame(frame);
		
		
		//Taking inputs from user to play with CPU
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your position:-->");
			int pos = sc.nextInt();
			//if the position already taken than we take input again from user.
			while(playerPosition.contains(pos) || cpuPosition.contains(pos)) {
				System.out.println("Position Taken ! enter a new Position");
				 pos=sc.nextInt();
			}
			//if winner is user than check with the condition and printing it
			String result=checkWin();
			if(result.length()>0) {
				System.out.println(result);
				break;
			}
			
			chooseBlock(frame, pos, "player");
			//if cpu wins the print result by using this condition...
			Random rand=new Random();
			int cpuPos=rand.nextInt(9)+1;
			while(playerPosition.contains(cpuPos) || cpuPosition.contains(cpuPos)) {
				cpuPos=rand.nextInt(9)+1;
			}
			
			chooseBlock(frame, cpuPos, "cpu");
			
		    result=checkWin();
		    if(result.length()>0) {
			System.out.println(result);
			break;
		    }
		}
	
	}
	

	private static void printGameFrame(char[][] frame) {
		//method to print game board 

		for (int i = 0; i < frame.length; i++) {
			for (int j = 0; j < frame[0].length; j++) {
				System.out.print(frame[i][j]);
			}
			System.out.println();

		}
	}
	public static void chooseBlock(char[][] frame,int pos, String user) {
		//method for selecting and printing the position on game board where user want placed there input..
		char symbol=' ';
		if(user=="player") {
			symbol='X';
			//adding item to the list so we can check win condition
			playerPosition.add(pos);
		}
		else if(user=="cpu") {
			symbol='O';
			// same for cpu...adding item to the list so we can check win condition

			cpuPosition.add(pos);
		}


		switch (pos) {
		case 1: {
			frame[0][0] = symbol;
			
			break;
		}
		case 2: {
			frame[0][2] = symbol;
			
			break;
		}
		case 3: {
			frame[0][4] = symbol;
			
			break;
		}
		case 4: {
			frame[2][0] = symbol;
			break;
			
		}
		case 5: {
			frame[2][2] = symbol;
			
			break;
		}
		case 6: {
			frame[2][4] = symbol;
			
			break;
		}
		case 7: {
			frame[4][0] = symbol;
			
		}
		case 8: {
			frame[4][2] = symbol;
			
			break;
		}
		case 9: {
			frame[4][4] =symbol;
			break;
		}
		default:
			break;
		
		
		}
		printGameFrame(frame);
		
	}
	public static String checkWin() {
		//predefined conditions of winning game...
		List leftrow=Arrays.asList(1,2,3);
		List midrow=Arrays.asList(4,5,6);
		List rightrow=Arrays.asList(7,8,9);
		List topcol=Arrays.asList(1,4,7);
		List midcol=Arrays.asList(2,5,8);
		List bottomcol=Arrays.asList(3,6,9);
		List firstdia=Arrays.asList(1,5,9);
		List seconddia=Arrays.asList(3,5,7);
		
		List<List> winning=new ArrayList<>();
		winning.add(leftrow);
		winning.add(midrow);
		winning.add(rightrow);
		winning.add(topcol);
		winning.add(midcol);
		winning.add(bottomcol);
		winning.add(firstdia);
		winning.add(seconddia);
		for(List l:winning) {
			if(playerPosition.containsAll(l)) {
				return "Congrats YOu win";
			}
			else if(cpuPosition.containsAll(l)) {
				return "sry! Batter LuckNextTime";
			}
			else if(cpuPosition.size()+playerPosition.size()==9) {
				return "its A Tie";
			}
		}
		
		
		return "";
	}

}
