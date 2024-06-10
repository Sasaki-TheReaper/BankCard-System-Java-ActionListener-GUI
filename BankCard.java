 


public class BankCard
{ 
   //encapsulation of instance variable 
  private int balanceAmount;
  private int cardId;
  private String issuerBank;
  private String bankAccount;
  private String clientName;
  // Paramaterized Constuctor for assigning instance variables 
  public BankCard(int balanceAmount,int cardId,String issuerBank,String bankAccount, String clientName)
  {
      this.balanceAmount = balanceAmount;
      this.cardId = cardId;
      this.issuerBank = issuerBank;
      this.bankAccount = bankAccount;
      this.clientName = "";
  }
  //setter method for client name
  public void setClientName(String clientName)
  {
      this.clientName =clientName;
     
  }
  public void setBalanceAmount(int balanceAmount)
  {
      this.balanceAmount= balanceAmount;
  }
  //getter methods
  public String getClientName()
  {
      return this.clientName;
  }
  public int getBalanceAmount()
  {
      return this.balanceAmount;
  }
  public int getCardId()
  {
     return this.cardId;   
  }
  public String getIssuerBank()
  {
      return this.issuerBank;
  }
  public String getBankAccount()
  {
      return this.bankAccount;
  }
  /*Method to display all the details of Variables when the clientName is 
   * given but also display a appropritate message when it is empty.
   */
  public void disout()
  {
       if(clientName.equals("")){
          System.out.println("Client Name is Empty. Please Enter It.");
      }
      System.out.println("USERNAME     : " + clientName);
      System.out.println("BALANCE      : " + balanceAmount);
      System.out.println("CARD NUMBER  : " + cardId);
      System.out.println("BANK NAME    : " + issuerBank);
      System.out.println("BANK ACCOUNT : " + bankAccount);
    }
 
}
