
import java.util.Scanner;

public class Coin {

	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("This program will tell you the shortest amount of dollars & coins needed to make a certain amount of cents in US currency.");
		
		while(1 > 0) {
			System.out.println("\nTo enter the number of cents type 1.");
			System.out.println("To enter with dollars type 2.");
			System.out.println("To enter the number of cents with a restriction on nickels enter 3.");
			System.out.println("To enter the number of cents with the abilty to type what coins the computer can use type 4.");
			System.out.println("To exit type 5.");
			int ans = sc.nextInt();
			if(ans == 5) {
				
				System.out.println("Have a good day!");
				sc.close();
				System.exit(0);
				
			}
			
			if(ans == 2) {
				
				int numdollars, cents;
				System.out.println("Enter the amount of dollars & cents seperated by a period.(Ex. 103.45)");
				String num = sc.next();
				
				{
					String dollars = "",cents1 = "";
					int cont=0;
					
					for(int i=0; i < num.length(); i++) {
						
						if(num.charAt(i) == '.') {
							cont=i;
							break;
						}
						
						dollars += num.charAt(i);
						
					}
					
					for(int j= cont+1; j <num.length();j++) {
						
						cents1 += num.charAt(j);
						
					}
					
					if(cents1.length()<2) {
						
						int zeros = 0;
						
						for(int j=0;j<cents1.length();j++) {
							
							if(cents1.charAt(j) == '0') {
								zeros++;
							}
							
						}
						
						if(zeros == 0) {
							cents1+="0";
						}
						
					}
					
					if(dollars.equals("")) numdollars=0;
					else numdollars = Integer.parseInt(dollars);
					if(cents1.equals("")) cents=0;
					else cents = Integer.parseInt(cents1);
				}
				
				{
					
					int hunbill=0, fifbill=0, twenbill=0, tenbill=0, fivebill=0, twbill=0, onebill=0, quaters=0, dimes=0, nickels=0;
					
					hunbill = numdollars/100;
					numdollars = numdollars%100;
					fifbill = numdollars/50;
					numdollars = numdollars%50;
					twenbill = numdollars/20;
					numdollars = numdollars%20;
					fivebill=numdollars/5;
					numdollars = numdollars%5;
					twbill= numdollars/2;
					numdollars = numdollars%2;
					onebill = numdollars;
					numdollars =0;
					
					cents+= 100*numdollars;
					
					quaters = cents/25;
					cents = cents%25;
					dimes = cents/10;
					cents  = cents%10;
					nickels = cents/5;
					cents = cents%5;
					
					System.out.println("The least amount of coins needed to make this amount is: " + hunbill + " hundred bills, " + fifbill + " fifty bills," + twenbill + " twenty bills, " + tenbill + " ten bills, " + fivebill + " five bills, " + twbill + " two bills, " + onebill + " singles.");
					System.out.print(quaters + " quaters, " + dimes + " dimes, " + nickels + " nickels, " + cents + " pennies.");
					
				}
				
			}
			
			if(ans == 1) {
				
				System.out.println("Enter the number of cents");
				int cents = sc.nextInt();
				{
					int quaters=0, dimes=0, nickels=0;
					
					quaters = cents/25;
					cents = cents%25;
					dimes = cents/10;
					cents  = cents%10;
					nickels = cents/5;
					cents = cents%5;
					
					System.out.print("The least amount of coins needed to make this amount is: " + quaters + " quaters, " + dimes + " dimes, " + nickels + " nickels, " + cents + " pennies.");
					
				}
			
			}
			
			if(ans == 3) {
				
				System.out.println("Enter the number of cents.");
				int money = sc.nextInt();
				
				int quaters=0, dimes=0,c1,c2,cents=money;
				int[] coins = new int[6];
				
				{
					dimes = cents/10;
					cents = cents%10;
					quaters = cents/25;
					cents = cents%25;
					coins[0] = dimes;
					coins[1] = quaters;
					coins[2] = cents;
					c1 = dimes+quaters+cents;
				}
				
				cents = money;
				{
					quaters = cents/25;
					cents = cents%25;
					dimes = cents/10;
					cents=cents%10;
					coins[3] = quaters;
					coins[4] = dimes;
					coins[5] = cents;
					c2 = quaters+dimes+cents;
				}
				
				if(c1<c2) {
					
					System.out.println("The least amount of coins needed to make this amount not including nickels is: " + coins[1] + " quaters," + coins[0] + " dimes, " + coins[2] + " pennies.");
					
				}
				else {
				
					System.out.println("The least amount of coins needed to make this amount not including nickels is: " + coins[3] + " quaters, " + coins[4] + " dimes, " + coins[5] + " pennies.");
					
				}		
				
			}
			
			if(ans == 4) {
				
				//System.out.println("This option is not developed yet. Contact nadathurvikram@gmail.com for further info.");
				
				//Get user input
				System.out.println("Enter the number of quaters.");
				int quaters = sc.nextInt();
				System.out.println("Enter the number of dimes.");
				int dimes= sc.nextInt();
				System.out.println("Enter the number of nickels.");
				int nickels = sc.nextInt();
				System.out.println("Enter the number of pennies.");
				int pennies = sc.nextInt();
				
				{
					//Get total cents
					int totcents = quaters*25 + dimes*10 + nickels*5 + pennies, q1 = quaters, d1 =dimes, n1 = nickels;
					System.out.println("Totcents:" + totcents);
					quaters = totcents/25;
					System.out.println("Quaters before " + quaters);
					if(quaters>q1) {
						
						int diff = quaters - q1;
						System.out.println("Diff: " + diff);
						quaters = quaters - diff;
						System.out.println("Quaters after " + quaters);
						totcents = totcents - (quaters*25);
						totcents+= diff*25;
						System.out.println("Totcentsq:" + totcents);
						
					}
					else {
						totcents -= quaters*25;
					}	
					
					dimes = totcents/10;
					if(dimes>d1) {
						
						int diff = dimes - d1;
						dimes -= d1;
						totcents -= dimes*10;
						totcents+= diff*10;
						System.out.println("Totcentsd:" + totcents);
						
					}
					else {
						totcents -= dimes*10;
					}
					
					nickels = totcents/5;
					if(nickels>n1) {
						
						int diff = nickels - n1;
						nickels -= n1;
						totcents -= nickels*5;
						totcents+= diff*5;
						System.out.println("Totcentsn:" + totcents);
						
					}
					else {
						totcents -= nickels*5;
					}
					
					pennies = totcents;
					
					System.out.println("Using the least possible coins the best way to make the total amount " + ((quaters*25)+(dimes*10)+(nickels*5)+pennies) + " is by using: " + quaters + " quaters, " + dimes +" dimes, " + nickels + " nickels, " + pennies + " pennies.");
				
				}	
			}
		}

	}

}
