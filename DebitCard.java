 


//Making DebitCard a subclass of BankCard
public class DebitCard extends BankCard
{
    //encapsulation for instance variable
    private int pinNumber; 
    private int withdrawalAmount;
    private String dateOfWithdrawal;
    private boolean hasWithdrawn;
    //Making Constructor with Six parameters 
    public DebitCard(int cardId,String bankAccount,int balanceAmount,String issuerBank,String clientName,int pinNumber)
    {
        super(balanceAmount,cardId,issuerBank,bankAccount,clientName); //calling constructor of super class
        setClientName(clientName);
        this.pinNumber= pinNumber;
        this.withdrawalAmount= 0;
        this.dateOfWithdrawal = "";
        this.hasWithdrawn = false;
    }
    
    // accessor method for all instance variables
    public int getPinNumber()
    {
        return this.pinNumber;
    }
    public int getWithdrawalAmount()
    {
        return this.withdrawalAmount;
    }
    public String getDateOfWithdrawal()
    {
        return this.dateOfWithdrawal;
    }
    public boolean getHasWithdrawn()
    {
        return this.hasWithdrawn;
    }
    
    //mutator method for Withdrawal Amount
    public void setWithdrawalAmount(int withdrawalAmount)
    {
        this.withdrawalAmount = withdrawalAmount;
    }
    
    //withdraw method which deducts money from client account
    public void withdraw(int withdrawalAmount, String dateOfWithdrawal, int pinNumber)
    {
      if(this.pinNumber!=pinNumber){
          System.out.println("YOU HAVE ENTERED WRONG PIN NUMBER"); //output when pin number is mistake
          }
      else{
        if(getBalanceAmount()>=withdrawalAmount){
            setWithdrawalAmount(withdrawalAmount);
            this.dateOfWithdrawal=dateOfWithdrawal;
            this.hasWithdrawn=true;
            setBalanceAmount(getBalanceAmount()-withdrawalAmount);
            System.out.println( withdrawalAmount +" has been withdrawn sucessfully. Remaining amount is: "+ getBalanceAmount());
        }
        else{ //output when withdrawal amount is larger than current bank amount
            System.out.println("Sorry, You do not have sufficient balance for transaction.  Current Balance is " + getBalanceAmount());       
        }
      }
    }
    //Method overriding with the disout method from BankCard class 
    
    public void disout()
    {    
         super.disout(); // calling display method from super class
         if(this.hasWithdrawn == true){
           System.out.println("Your Pin number of your Debitcard is: "+this.pinNumber);
           System.out.println("You Withdrew balance on the date of:  "+this.dateOfWithdrawal);
           System.out.println("The Amount you had Withdrawn is:      "+this.withdrawalAmount);
                
        }
        else{
            System.out.println("Your current Bank Balance is: " + getBalanceAmount());
        }
    }
}
    
        

    
    