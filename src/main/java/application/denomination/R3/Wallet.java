package application.denomination.R3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Wallet {
	private Map <Integer,Integer> denominations = new TreeMap<Integer, Integer>();
	
	int denominationsArray [] = {1000,200,100,1};
	
	
	public Map<Integer, Integer> getDenominations() {
		return denominations;
	}

	public int loadAndCalculateBalance() throws FileNotFoundException {	
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the denomination file(Press enter to load default denom file- denom.txt)");
		
		String fileName=scanner.nextLine();
		if(fileName.equals("") || fileName==null) {
			fileName="denom";
		}
		FileReader reader = new FileReader(fileName+".txt");
		
		Scanner in2 = new Scanner (reader);
		
		String nextLine = in2.nextLine();
		scanner.close();
		in2.close();
		StringTokenizer st = new StringTokenizer(nextLine,",");
		while(st.hasMoreTokens()) {
			String count = st.nextToken();
			int result = Integer.parseInt(count);
			
			Integer denominationCount = denominations.get(result);
			if(denominationCount==null) {
				denominationCount=0;
			}
			denominationCount++;
			denominations.put(result, denominationCount);				
		}	

		
		return getBalanceFromDenominations();
		
	}
	
	public int spend(int spendMoney) throws NotEnoughtBalanceException {
		if(spendMoney>getBalanceFromDenominations()) {
			throw new NotEnoughtBalanceException("Not enough balance");
		}
		int changeBalance = getBalanceFromDenominations() - spendMoney;
		resetDenominations();
		adjustChange(changeBalance);
		return getBalanceFromDenominations();
	}

	private void resetDenominations() {
		denominations = new TreeMap<Integer, Integer>();
		for(int i=0;i<denominationsArray.length;i++) {
			denominations.put(denominationsArray[i], 0);
		}
	}

	private void adjustChange(int change) {
		System.out.println("Change is "+change);
		if (change!=0) {
			for(int i=0;i<denominationsArray.length;i++) {
				change = spiltChange(denominationsArray[i],change);
				if(change==0) {
					break;
				}
			}			
		}
	}
	
	private int spiltChange(int denom,int change) {

		int changeDenomKey=change/denom;
		if (changeDenomKey>0) {
			int count = denominations.get(denom);
			count+=changeDenomKey;
			denominations.put(denom, count);
		}			
		int changeLeftOver = change%denom;			
		return 	changeLeftOver;	
	}
	
	private int getBalanceFromDenominations() {
		int balance=0;

		Iterator<Integer> itr = denominations.keySet().iterator();
		while(itr.hasNext()) {
			int denom = itr.next();
			int countDenom = denominations.get(denom);
			balance=balance+ denom*countDenom;
		}		
		return balance;
	}

}
