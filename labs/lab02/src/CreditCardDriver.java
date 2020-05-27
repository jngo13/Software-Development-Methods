//Demonstrates the CreditCard class
//NEEDS MODIFICATION

public class CreditCardDriver
{
	public static void main(String[] args)
	{
		final Money LIMIT = new Money(1000);
		final Money FIRST_AMOUNT = new Money(200);
		final Money SECOND_AMOUNT = new Money(10.02);
		final Money THIRD_AMOUNT = new Money(25);
		final Money FOURTH_AMOUNT = new Money(990);
		Person owner = new Person("Bruce", "Wayne", 
				new Address("123 Wayne Manor", "Gotham","NY", "54321"));
		CreditCard visa = new CreditCard(owner, LIMIT);

		//INSERT MAIN METHOD TESTING HERE
		/*Test the following CreditCard methods:
		 * - getPersonals()
		 * - getCreditLimit()
		 * - getBalance()
		 * - normal use of charge() with FIRST_AMOUNT then SECOND_AMOUNT
		 * - normal use of payment() with THIRD_AMOUNT
		 * - charge() that exceeds the balance limit with FOURTH_AMOUNT
		 */

		//Hint: Print out the balance after each test & check that your 
		//output matches the output provided in the lab instructions.
		
		System.out.println(visa.getPersonals());
		System.out.println("Balance: " + visa.getBalance().toString());
		
		System.out.println("Credit Limit: " + visa.getCreditLimit().toString());
		//System.out.println("Balance: " + visa.getBalance().toString());
		
		System.out.println("Attempt to charge " + FIRST_AMOUNT.toString());
		visa.charge(FIRST_AMOUNT);
		System.out.println("Balance: " + visa.getBalance().toString());
		
		System.out.println("Attempt to charge " + SECOND_AMOUNT.toString());
		visa.charge(SECOND_AMOUNT);
		System.out.println("Balance: " + visa.getBalance().toString());
		
		System.out.println("Attempt to pay " + THIRD_AMOUNT.toString());
		visa.payment(THIRD_AMOUNT);
		System.out.println("Balance: " + visa.getBalance().toString());
		
		System.out.println("Attempt to charge " + FOURTH_AMOUNT.toString());
		visa.charge(FOURTH_AMOUNT);
		System.out.println("Balance: " + visa.getBalance().toString());
	}
}