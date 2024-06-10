 

public class CreditCard extends BankCard //making this class a subclass of bankcard class
{  
   //encapsulation of all instance variables
   private int cvcNumber;
   private double creditLimit;
   private double interestRate;
   private String expirationDate;
   private int gracePeriod;
   private boolean isGranted;
   
   //making constructor for CreditCard
   public CreditCard(int cardId, String clientName, String issuerBank, String bankAccount, int balanceAmount,
   int cvcNumber, double interestRate, String expirationDate)
   {
       super(balanceAmount,cardId,issuerBank,bankAccount,clientName);//calling constructor of superclass
       setClientName(clientName);//calling the mutator method
       //assiging the values 
       this.cvcNumber= cvcNumber;
       this.interestRate= interestRate;
       this.expirationDate= expirationDate;
       this.isGranted = false;
   }
   
   //Accessor methods for all Attributes
   public int getCvcNumber()
   {
      return this.cvcNumber; 
   } 
   public double getCreditLimit()
   {
       return this.creditLimit;
   }  
   public double getInterestRate()
   {
       return this.interestRate;
   } 
   public String getExpirationDate()
   {
       return this.expirationDate;
   } 
   public int getGracePeriod()
   {
       return this.gracePeriod;
   }
   public boolean getIsGranted()
   {
       return this.isGranted;
   }  
   
   //Mutator method with a if else statement to change isGranted
   public void setCreditLimit( int creditLimit, int gracePeriod)
   {
       this.creditLimit = creditLimit;
       this.gracePeriod = gracePeriod;
       if(creditLimit<= (2.5 * getBalanceAmount())){
           isGranted = true;
           System.out.println("Credit Card is issued.");
       }
       else{
           //isGranted = false;
           System.out.println("We are unable to issue a Credit Card as Credit limit is less than 2.5 times your Bank Account ");
       }
   }
   
   // method for cancelling Credit card
   public void cancelCreditCard()
   {
       this.cvcNumber = 0;
       this.creditLimit = 0;
       this.gracePeriod = 0;
       this.isGranted = false;
       System.out.println("Your Credit Card is cancelled sucessfully.");
   }
   
   //Overriding method with same name from super class  
   
   public void disout()
   {
     if(isGranted== false){
        System.out.println("You have "+ interestRate+ "% interest rate at your credit card.");
        System.out.println("The Expiration date of this Card is:   "+ expirationDate);
        System.out.println("Currently this Credit card is NOT ISSUED");
    }//different output with different isGranted values
   
    else{
        super.disout();
         System.out.println("The CVC number of your Credit Card is: "+cvcNumber);
         System.out.println("Your current Credit Limit is:          "+creditLimit);
         System.out.println("You have "+ interestRate+ "% interest rate at your credit card.");
         System.out.println("The Expiration date of this Card is:   "+ expirationDate);
         System.out.println("Grace period for this credit card is:  "+ gracePeriod);
         System.out.println("Currently this Credit card is ISSUED");
        
    }
   }
}

