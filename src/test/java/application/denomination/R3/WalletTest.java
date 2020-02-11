package application.denomination.R3;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

public class WalletTest {
	
	Wallet wallet = new Wallet();
	
	@Before
	public void setUp() {
		System.out.println("***************************************************************");
	}
	
	@Test
	public void testLoadBalance() throws FileNotFoundException {		
		int balance = wallet.loadAndCalculateBalance();
		assertEquals(balance, 1502);
	}
	
	@Test
	public void spendMoneyFromBalanceScenario1_1() throws FileNotFoundException, NotEnoughtBalanceException {
		System.out.println("Running spendMoneyFromBalanceScenario1_1");
		wallet.loadAndCalculateBalance();
		System.out.println("denominations before spending are " + wallet.getDenominations());
		assertEquals(wallet.spend(1),1501);
		System.out.println("denominations after spending are " + wallet.getDenominations());
	}
	
	@Test
	public void spendMoneyFromBalanceScenario2_2() throws FileNotFoundException, NotEnoughtBalanceException {
		System.out.println("Running spendMoneyFromBalanceScenario2_2");
		wallet.loadAndCalculateBalance();
		System.out.println("denominations before spending are " + wallet.getDenominations());
		System.out.println("Spending 2");
		assertEquals(wallet.spend(2),1500);
		System.out.println("denominations after spending are " + wallet.getDenominations());
	}
	
	@Test
	public void spendMoneyFromBalanceScenario3_5() throws FileNotFoundException, NotEnoughtBalanceException {
		System.out.println("Running spendMoneyFromBalanceScenario3_5");
		System.out.println("Balance before spending are " +wallet.loadAndCalculateBalance());
		System.out.println("denominations before spending are " + wallet.getDenominations());
		System.out.println("Spending 5");
		assertEquals(wallet.spend(5),1497);
		System.out.println("denominations after spending are " + wallet.getDenominations());
	}
	
	
	@Test
	public void spendMoneyFromBalanceScenario4_105() throws FileNotFoundException, NotEnoughtBalanceException {		
		System.out.println("Running spendMoneyFromBalanceScenario4_105");
		System.out.println("Balance before spending are " + wallet.loadAndCalculateBalance());
		System.out.println("denominations before spending are " + wallet.getDenominations());
		System.out.println("Spending 105");
		assertEquals(wallet.spend(105),1397);
		System.out.println("denominations after spending are " + wallet.getDenominations());
	}
	
	@Test
	public void spendMoneyFromBalanceScenario5_295() throws FileNotFoundException, NotEnoughtBalanceException {
		System.out.println("Running spendMoneyFromBalanceScenario5_295");
		System.out.println("Balance before spending are " + wallet.loadAndCalculateBalance());
		System.out.println("denominations before spending are " + wallet.getDenominations());
		System.out.println("Spending 295");
		assertEquals(wallet.spend(295),1207);
		System.out.println("denominations after spending are " + wallet.getDenominations());
	}
	
	@Test(expected = NotEnoughtBalanceException.class)
	public void spendMoneyFromBalanceScenario6_NotEnoughBalance() throws FileNotFoundException, NotEnoughtBalanceException {
		System.out.println("Running spendMoneyFromBalanceScenario6_NotEnoughBalance");
		int balance=wallet.loadAndCalculateBalance();
		System.out.println("Balance before spending are " + balance);
		System.out.println("denominations before spending are " + wallet.getDenominations());
		System.out.println("Spending 1590");
		assertEquals(wallet.spend(1590),1207);
		System.out.println("denominations after spending are " + wallet.getDenominations());
	}
	
	@Test
	public void spendMoneyFromBalanceScenario7_1005() throws FileNotFoundException, NotEnoughtBalanceException {
		System.out.println("Running spendMoneyFromBalanceScenario7_1005");
		int balance = wallet.loadAndCalculateBalance();
		System.out.println("Balance before spending are " + balance);
		System.out.println("denominations before spending are " + wallet.getDenominations());
		System.out.println("Spending 1005");
		assertEquals(wallet.spend(1005),497);
		System.out.println("denominations after spending are " + wallet.getDenominations());
	}
	
	@Test
	public void spendMoneyFromBalanceScenario8_100() throws FileNotFoundException, NotEnoughtBalanceException {
		System.out.println("Running spendMoneyFromBalanceScenario8_100");
		int balance = wallet.loadAndCalculateBalance();
		System.out.println("Balance before spending are " + balance);
		System.out.println("denominations before spending are " + wallet.getDenominations());
		System.out.println("Spending 100");
		assertEquals(wallet.spend(100),1402);
		System.out.println("denominations after spending are " + wallet.getDenominations());
	}
	
	@Test
	public void spendMoneyFromBalanceScenario9_400() throws FileNotFoundException, NotEnoughtBalanceException {
		System.out.println("Running spendMoneyFromBalanceScenario9_400");
		int balance = wallet.loadAndCalculateBalance();
		System.out.println("Balance before spending are " + balance);
		System.out.println("denominations before spending are " + wallet.getDenominations());
		System.out.println("Spending 400");
		assertEquals(wallet.spend(400),1102);
		System.out.println("denominations after spending are " + wallet.getDenominations());
	}
	
	@Test
	public void spendMoneyFromBalanceScenario10_1000() throws FileNotFoundException, NotEnoughtBalanceException {
		System.out.println("Running spendMoneyFromBalanceScenario10_1000");
		int balance = wallet.loadAndCalculateBalance();
		System.out.println("Balance before spending are " + balance);
		System.out.println("denominations before spending are " + wallet.getDenominations());
		System.out.println("Spending 1000");
		assertEquals(wallet.spend(1000),502);
		System.out.println("denominations after spending are " + wallet.getDenominations());
		
	}
	

	

}
