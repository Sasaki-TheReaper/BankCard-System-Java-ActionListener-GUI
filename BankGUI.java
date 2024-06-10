/**
 * This is BankGUI class which holds all the methods and components for GUI
 * @author Anjan Khadka
 * @version 19.0.1
 */




import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;




public class BankGUI{

    private JFrame frame;
    //Bank Card variables
    private JPanel pnlBC;
    private JLabel welcomeLabel,fillLabel,balanceAmtLabl,issuerLabel,bankAccLabel,clientNmLabel;
    private JTextField BAmtf,IBtf,BActf,CNatf;
    private JButton CredBCButton,DebBCutton;
    

    // Debit Card variables
    private JPanel pnlDC;
    private JTextField DC_Add_IDtf,DCIDtf,PNtf,PNWtf,WAmtf;
    private JComboBox<String> WYears,WMonths,WDays;
    private JLabel addDebCardLabel,pinNumLabel,withAmtLabel,DOW_Label,wthCardIdLabel,wthPinNumLabel;
    private JButton withdrawButton,addDebitCardButton,credDfButton,bankDfButton;
    

    // Credit Card variables
    private JPanel pnlCC;
    private JTextField CC_Add_CIDtf,CVCtf,IRtf,CLtf,GPtf,CCIDtf,CancelCreditIDtf;
    private JComboBox<String> EYears,EMonths,EDays;
    private JLabel addCredCardidLabel,cvcNumLabel,interestLabel,DOE_Label,credLimitLabel,graceLabel,
    setCreLim_CId_label,cancelCC_CId_Label;
    private JButton addCreditCardButton,setCreditLimiButton,cancelCCButton,debCfButton,bnkCfButton,
    bankCardClearButton,debitDisplayButton,debitClearButton,creditDisplyButton,creditClearButton;
    
    
    //variables for checking invalid integers
    public final static int INVALID = -1;
    
    //Arraylist of bank card to store array objects
    ArrayList<BankCard> cardList = new ArrayList<BankCard>();

    
    // Instance List varibables for year, month and days to use in date combobox
    private String[] years = {"Year","2020","2021","2022","2023","2024","2025","2026","2027"}; 
    private String[] months = {"Month","January","February","March","April","May","June","July","August",
    "September","October","November","December"};
    private String[] days = {"Day","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16",
    "17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32"};


    //Constructor of BankGUI
    public BankGUI(){
      initFrame();
      initBankCard();
      initDebitCard();
      initCreditCard();

    }
    //Method for Creating a Frame 
    public void initFrame() {
      frame = new JFrame("Bank GUI");
      frame.setSize(900,900);
      frame.setLayout(null);
      frame.setResizable(false);
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    //Bank Card Panel >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    public void initBankCard() {
      pnlBC = new JPanel();
      pnlBC.setLayout(null);
      pnlBC.setLocation(50,30);
      pnlBC.setSize(800, 750);
      pnlBC.setBackground(Color.CYAN);
      TitledBorder borderBank = new TitledBorder("BankCard");
      borderBank.setTitleJustification(TitledBorder.CENTER);
      borderBank.setTitleFont(new Font("Arial", Font.BOLD,24));
      pnlBC.setBorder(borderBank);
      frame.add(pnlBC);
      
      //Labelling and giving text fields to enter the data
      welcomeLabel = new JLabel("Welcome to Bank GUI");
      welcomeLabel.setBounds(140,50,600,80);
      welcomeLabel.setForeground(Color.RED);
      welcomeLabel.setFont(new Font("Futura", Font.BOLD, 45)); // adding font style to the label
      pnlBC.add(welcomeLabel);
      
      //label to show a large text on bank card
      fillLabel = new JLabel("Fill all fields before clicking card type.");
      fillLabel.setBounds(70,470,600,80);
      fillLabel.setForeground(Color.RED);
      fillLabel.setFont(new Font("Futura",Font.PLAIN,30)); // adding font style
      pnlBC.add(fillLabel);
      
      //Bank Card  BalanceAmount
      balanceAmtLabl = new JLabel("Balance Amount");
      balanceAmtLabl.setFont(new Font("Ariel Black", Font.PLAIN, 15)); // adding font style to labels 
      balanceAmtLabl.setBounds(70,130,120,50);
      pnlBC.add(balanceAmtLabl);

      BAmtf = new JTextField();
      BAmtf.setBounds(200,130,170,50);
      pnlBC.add(BAmtf);
      
      //BankCard IssuerBank
      issuerLabel = new JLabel("Issuer Bank");
      issuerLabel.setFont(new Font("Ariel Black", Font.PLAIN, 15));
      issuerLabel.setBounds(70,180,120,70);
      pnlBC.add(issuerLabel);

      IBtf = new JTextField();
      IBtf.setBounds(200,190,170,50);
      pnlBC.add(IBtf);

      //BankCard BankAccount
      bankAccLabel = new JLabel("Bank Account");
      bankAccLabel.setFont(new Font("Ariel Black", Font.PLAIN, 15));
      bankAccLabel.setBounds(70,240,120,70);
      pnlBC.add(bankAccLabel);

      BActf = new JTextField();
      BActf.setBounds(200,250,170,50);
      pnlBC.add(BActf);

      //BankCard ClientName
      clientNmLabel = new JLabel("Client Name");
      clientNmLabel.setFont(new Font("Ariel Black", Font.PLAIN, 15));
      clientNmLabel.setBounds(70,300,120,70);
      pnlBC.add(clientNmLabel);

      CNatf = new JTextField();
      CNatf.setBounds(200,310,170,50);
      pnlBC.add(CNatf);

     
     // button made to clear all the textfields in bank card panel
      bankCardClearButton = new JButton("Clear");
      bankCardClearButton.setBounds(300,680,100,50);
      pnlBC.add(bankCardClearButton);
      bankCardClearButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e){
           clearButton(pnlBC);
         
         }         
      });
       
      //button made to open credit card panel
      CredBCButton = new JButton("Credit Card");
      CredBCButton.setBounds(140,550,120,50);
      CredBCButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ae){
           pnlCC.setVisible(true);
           pnlBC.setVisible(false);
        } 
      });
      pnlBC.add(CredBCButton);
      
      //button made to open debit card panel
      DebBCutton = new JButton("Debit Card");
      DebBCutton.setBounds(300,550,120,50);
      DebBCutton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ae){
          pnlDC.setVisible(true);
          pnlBC.setVisible(false);
        } 
      });
      pnlBC.add(DebBCutton);
     
     }

    //Debit card Panel >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    public void initDebitCard() {
      pnlDC = new JPanel();
      pnlDC.setLayout(null);
      pnlDC.setLocation(50,30);
      pnlDC.setSize(800, 750);
      pnlDC.setBackground(Color.GREEN);
      TitledBorder borderDebit = new TitledBorder("Debit Card");
      borderDebit.setTitleJustification(TitledBorder.CENTER);
      borderDebit.setTitleFont(new Font("Arial", Font.BOLD,24));
      pnlDC.setBorder(borderDebit);
      pnlDC.setVisible(false);
      frame.add(pnlDC);
      
      //Labelling and giving text fields to enter the data
      //addDebit PinNumber
      pinNumLabel = new JLabel("Pin Number");
      pinNumLabel.setBounds(50 ,50 , 120, 70);
      pinNumLabel.setFont(new Font("Ariel Black", Font.PLAIN, 15));
      pnlDC.add(pinNumLabel);

      PNtf = new JTextField();
      PNtf.setBounds(170,60,170,50);
      pnlDC.add(PNtf);
  
      //addDebit CardID
      addDebCardLabel = new JLabel("Card ID");
      addDebCardLabel.setBounds(50,110,120,70);
      addDebCardLabel.setFont(new Font("Ariel Black", Font.PLAIN, 15));
      pnlDC.add(addDebCardLabel);

      DC_Add_IDtf = new JTextField();
      DC_Add_IDtf.setBounds(170,120,170,50);
      pnlDC.add(DC_Add_IDtf);     

      //Withdraw WithdrawalAmount
      withAmtLabel = new JLabel("WithDrawal Amount");
      withAmtLabel.setBounds(50, 280, 200, 70);
      withAmtLabel.setFont(new Font("Ariel Black", Font.PLAIN, 15));
      pnlDC.add(withAmtLabel);

      WAmtf = new JTextField();
      WAmtf.setBounds(250,290,170,50);
      pnlDC.add(WAmtf);
      
      //Withdraw Date of Withdrawal    
      DOW_Label = new JLabel("Date of Withdrawal");
      DOW_Label.setBounds(50, 410, 200, 70);
      DOW_Label.setFont(new Font("Ariel Black", Font.PLAIN, 15));
      pnlDC.add(DOW_Label);
     
      //Combo box to enter the date of withdrawal
      WYears = new JComboBox<String>(years); 
      WYears.setBounds(250,430,90,28);
      pnlDC.add(WYears);

      
      WMonths = new JComboBox<String>(months); 
      WMonths.setBounds(350,430,90,28);
      pnlDC.add(WMonths);

      WDays = new JComboBox<String>(days); 
      WDays.setBounds(450,430,90,28);
      pnlDC.add(WDays);
    
      //withdraw CardID
      wthCardIdLabel = new JLabel("Card ID");
      wthCardIdLabel.setBounds(70,340,120,70);
      wthCardIdLabel.setFont(new Font("Ariel Black", Font.PLAIN, 15));
      pnlDC.add(wthCardIdLabel);

      DCIDtf = new JTextField();
      DCIDtf.setBounds(250,350,170,50);
      pnlDC.add(DCIDtf);

      //withdraw PinNumber
      wthPinNumLabel = new JLabel("Pin Number");
      wthPinNumLabel.setBounds(50 ,470 , 120, 70);
      wthPinNumLabel.setFont(new Font("Ariel Black", Font.PLAIN, 15));
      pnlDC.add(wthPinNumLabel);

      PNWtf = new JTextField();
      PNWtf.setBounds(250,480,170,50);
      pnlDC.add(PNWtf);

       // Creating a JLabel to make a line and seprate Debit card panel
      JLabel lblspam = new JLabel("__________________________________________________________________________________________");
      lblspam.setBounds(10,230,600,50);

      pnlDC.add(lblspam);
     
      //Button to call the withdrawal method
      withdrawButton=new JButton("Withdraw");
      withdrawButton.setBounds(140, 580, 120, 50);
      pnlDC.add(withdrawButton);
      withdrawButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ae){
          withdrawal();
        }
      });
  
      // button to add debit card 
      addDebitCardButton = new JButton("Add Debit Card");
      addDebitCardButton.setBounds(170,180,170,50);
      addDebitCardButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
            addDebitCard();          
        }
      });
      pnlDC.add(addDebitCardButton);
      
      //button to open credit card panel 
      credDfButton = new JButton("Credit Card");
      credDfButton.setBounds(550,60,120,50);
      credDfButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ae){
          pnlCC.setVisible(true);
          pnlDC.setVisible(false);
         
        } 
      });
      pnlDC.add(credDfButton);
      
      //button to open bank card panel
      bankDfButton = new JButton("Bank Card");
      bankDfButton.setBounds(550,150,120,50);
      bankDfButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ae){
          pnlBC.setVisible(true);
          pnlDC.setVisible(false);
        } 
      });
      pnlDC.add(bankDfButton);
      
      //button to display the data entered in debit card
      debitDisplayButton = new JButton("Display");
      debitDisplayButton.setBounds(670, 600, 90, 50);
      debitDisplayButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ae){
            Display();
        } 
      });
      pnlDC.add(debitDisplayButton);
      
      // button to clear the data entered in debit card
      debitClearButton = new JButton("Clear");
      debitClearButton.setBounds(540,600,100,50);
      pnlDC.add(debitClearButton);
      debitClearButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e){
           clearButton(pnlDC);
         }         
      });

    }  



    
      // Credit Card Frame >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
     public void initCreditCard(){
      pnlCC = new JPanel();
      pnlCC.setLayout(null);
      pnlCC.setLocation(50,30);
      pnlCC.setSize(800, 750);
      pnlCC.setBackground(Color.ORANGE
      );
      TitledBorder borderCredit =new TitledBorder("Credit Card");
      borderCredit.setTitleJustification(TitledBorder.CENTER);
      borderCredit.setTitleFont(new Font("Arial", Font.BOLD,24));
      pnlCC.setBorder(borderCredit);  
      pnlCC.setVisible(false);   
      frame.add(pnlCC);

      // Labelling and creating text fields and combobox for credit card
      //addCredit CVCNumber 
      cvcNumLabel = new JLabel("CVC Number");
      cvcNumLabel.setBounds(50,50, 120, 70);
      cvcNumLabel.setFont(new Font("Ariel Black", Font.PLAIN, 15));
      pnlCC.add(cvcNumLabel);
      
      CVCtf = new JTextField();
      CVCtf.setBounds(170,50,170,50);
      pnlCC.add(CVCtf);

      //addCredit  InterestRate
      interestLabel = new JLabel("Interest Rate");
      interestLabel.setBounds(50, 100, 120, 70);
      interestLabel.setFont(new Font("Ariel Black", Font.PLAIN, 15));
      pnlCC.add(interestLabel);

      
      IRtf = new JTextField();
      IRtf.setBounds(170,110,170,50);
      pnlCC.add(IRtf);

      //addCredit DateOfExpiration
      DOE_Label = new JLabel("Expiration Date");
      DOE_Label.setBounds(50,160,120,70);
      DOE_Label.setFont(new Font("Ariel Black", Font.PLAIN, 15));
      pnlCC.add(DOE_Label);

      // combo box to enter the date of expiration
      EYears = new JComboBox<String>(years);
      EYears.setBounds(200,180,90,28);
      pnlCC.add(EYears);

    
      EMonths = new JComboBox<String>(months);
      EMonths.setBounds(300,180,90,28);
      pnlCC.add(EMonths);
                
    
      EDays = new JComboBox<String>(days);
      EDays.setBounds(400,180,90,28);
      pnlCC.add(EDays);
      
      //addCredit  CardID
      addCredCardidLabel = new JLabel("Card ID");
      addCredCardidLabel.setBounds(50, 240, 120, 70);
      addCredCardidLabel.setFont(new Font("Ariel Black", Font.PLAIN, 15));
      pnlCC.add(addCredCardidLabel);

      CC_Add_CIDtf = new JTextField();
      CC_Add_CIDtf.setBounds(170,250,170,50);
      pnlCC.add(CC_Add_CIDtf);
      
      //label made to separate fields of credit card panel
      JLabel lblspam2 = new JLabel("___________________________________________________________________________________________");
      lblspam2.setBounds(10,300,600,50);
      pnlCC.add(lblspam2);

      //setCreditLimit CreditLimit
      credLimitLabel = new JLabel("Credit Limit");
      credLimitLabel.setBounds(50, 360, 120, 70);
      credLimitLabel.setFont(new Font("Ariel Black", Font.PLAIN, 15));
      pnlCC.add(credLimitLabel);
      
      CLtf = new JTextField();
      CLtf.setBounds(170,360,170,50);
      pnlCC.add(CLtf);

      //setCreditLimit GracePeriod
      graceLabel = new JLabel("Grace Period");
      graceLabel.setBounds(50, 410, 120, 70);
      graceLabel.setFont(new Font("Ariel Black", Font.PLAIN, 15));
      pnlCC.add(graceLabel);

      GPtf = new JTextField();
      GPtf.setBounds(170,420,170,50);
      pnlCC.add(GPtf);

      //setCreditLimit CardId
      setCreLim_CId_label = new JLabel("Card ID");
      setCreLim_CId_label.setBounds(50, 470, 120, 70);
      setCreLim_CId_label.setFont(new Font("Ariel Black", Font.PLAIN, 15));
      pnlCC.add(setCreLim_CId_label);

      CCIDtf = new JTextField();
      CCIDtf.setBounds(170,480,170,50);
      pnlCC.add(CCIDtf);
      
      //label to separate panel
      JLabel lblspam3 = new JLabel("___________________________________________________________________________________________");
      lblspam3.setBounds(10,540,600,50);
      pnlCC.add(lblspam3);

      //CancelCreditCard CardID
      cancelCC_CId_Label = new JLabel("Card ID");
      cancelCC_CId_Label.setBounds(50, 600, 120, 70);
      cancelCC_CId_Label.setFont(new Font("Ariel Black", Font.PLAIN, 15));
      pnlCC.add(cancelCC_CId_Label);

      CancelCreditIDtf = new JTextField();
      CancelCreditIDtf.setBounds(170,610,170,50);
      pnlCC.add(CancelCreditIDtf);
      
      //button to add the data of credit card 
      addCreditCardButton=new JButton("Add Credit Card" );
      addCreditCardButton.setBounds(370, 250, 150, 50);
      addCreditCardButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ae){
          addCreditCard();
        }
      });
      pnlCC.add(addCreditCardButton);
      
      //button to set credit limit 
      setCreditLimiButton = new JButton("Set Credit Limit");
      setCreditLimiButton.setBounds(430,400,270,50);
      setCreditLimiButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ce){
          addCreditLimit();
        }          
      });
      pnlCC.add(setCreditLimiButton);
      
      //button to cancel the credit card
      cancelCCButton = new JButton("Cancel Credit Card");
      cancelCCButton.setBounds(130,680,270,50);
      cancelCCButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
          cancelCreditCard();
        }
      });
      pnlCC.add(cancelCCButton);

      //button to open bank card panel
      bnkCfButton = new JButton("Bank Card");
      bnkCfButton.setBounds(550,60,120,50);
      bnkCfButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ab){
         pnlBC.setVisible(true);
         pnlCC.setVisible(false);
         
        } 
       });
      pnlCC.add(bnkCfButton);

      //button to open debit card panel
      debCfButton= new JButton("Debit Card");
      debCfButton.setBounds(550,150,120,50);
      debCfButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ad){
          pnlDC.setVisible(true);
          pnlCC.setVisible(false);
        } 
       });
      pnlCC.add(debCfButton);

       //button to display the data of credit card
      creditDisplyButton = new JButton("Display");
      creditDisplyButton.setBounds(500, 600, 90, 50);
      creditDisplyButton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
           Display();
        }
      });
      pnlCC.add(creditDisplyButton);

      //button to clear the data of credit card
      creditClearButton = new JButton("Clear");
      creditClearButton.setBounds(600,600,100,50);
      pnlCC.add(creditClearButton);
      creditClearButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e){
             clearButton(pnlCC);
         }         
      }); 
    }

//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
      // clearButton method to clear fields 
    public void clearButton(Container container) 
    {
      for (Component c : container.getComponents()) {
          if (c instanceof JTextField) {
              JTextField f = (JTextField) c;
              f.setText("");
          } else if (c instanceof Container)
              clearButton((Container) c); 
      }
      WYears.setSelectedIndex(0);
      WMonths.setSelectedIndex(0);
      WDays.setSelectedIndex(0);
      EYears.setSelectedIndex(0);
      EMonths.setSelectedIndex(0);
      EDays.setSelectedIndex(0);
    }
    
    //Add Debit Card
    public void addDebitCard()
    {  
      String issuerBank = getIssuerBank();
      String bankAccount = getBankAccount();
      String clientName = getClientName();
      int balanceAmount = getBalanceAmount();
      int cardID = getAddDebitCardId();
      int pinNumber = getPinNumber();
    if(issuerBank.isEmpty()|| bankAccount.isEmpty()|| clientName.isEmpty() || balanceAmount == INVALID || cardID == INVALID || pinNumber == INVALID){
      JOptionPane.showMessageDialog(frame,"Date enterd is invalid. Please fill appropriate data to add Debit Card.","Debit Card not added",JOptionPane.ERROR_MESSAGE);
    }
    
    else if (checkDebitCardUnique(cardID)){
        cardList.add(new DebitCard(cardID, bankAccount, balanceAmount, issuerBank, clientName, pinNumber));
        String message = "Card ID:  "+ cardID+ "\nClient Name:  " + clientName+ "\nIssuer Bank: "+ issuerBank+ "\nBank Account: "+ bankAccount + "\nBalance Amount: "+ balanceAmount + "\nPin Number: "+ pinNumber;
        JOptionPane.showMessageDialog(frame, message, "Debit Card added sucessfully",JOptionPane.OK_CANCEL_OPTION);
      }

      else{
        JOptionPane.showMessageDialog(frame, "Debit Card couldn't be added. Try again!!", "Card not added",
         JOptionPane.ERROR_MESSAGE);
      }
      

    }
     // method to withdraw by calling withdraw method of debit card
    public void withdrawal()
    {
      boolean is_found = false;
      if(getDebitCardId() == INVALID || getWithdrawalAmount()==INVALID || getWithdrawalPinNumber()== INVALID || getDateOfWithdrawal().isEmpty())
      {
        JOptionPane.showMessageDialog(frame," The data given was not valid. Check and try again.","Invalid Input",JOptionPane.ERROR_MESSAGE);
      }
      else
      {
          JOptionPane.showMessageDialog(frame," CardId is:  "+getDebitCardId()+".\n"+" WithDrawal amount is:  "+getWithdrawalAmount()+".\n"+" Pin number is: "+getWithdrawalPinNumber()+".\n"+"Date of Withdrawal: "+getDateOfWithdrawal() ," Inputed Data",JOptionPane.INFORMATION_MESSAGE);
        for(BankCard bObj:cardList)
        {
          if(bObj instanceof DebitCard)
          {
            DebitCard dObj=(DebitCard) bObj;
            if(dObj.getCardId()==getDebitCardId())
            {
              if(dObj.getPinNumber() == getWithdrawalPinNumber()){
              dObj.withdraw(getWithdrawalAmount(),getDateOfWithdrawal(),getWithdrawalPinNumber());
              JOptionPane.showMessageDialog(frame,getWithdrawalAmount()+" has been withdrawal sucessfully.","Withdraw sucessfull", JOptionPane.INFORMATION_MESSAGE);
              is_found = true;
              break;
              }
              else{
                JOptionPane.showMessageDialog(frame,"Given Pin number to withdraw money was incorrect.","Invalid Input", JOptionPane.ERROR_MESSAGE);
              }
            }
            else{
              JOptionPane.showMessageDialog(frame,"Given card id to withdraw money was incorrect.","Invalid Input", JOptionPane.ERROR_MESSAGE);
            }
        
          } 
                   
        }  
      }
      if(is_found== false){
        JOptionPane.showMessageDialog(frame,"Balance is not Withdrawn.","Error",JOptionPane.ERROR_MESSAGE);
      }  
    }                     
    
    

    //add credit card data
    public void addCreditCard()
    {
      int cardID = getAddCardIDCredit();
      String clientName = getClientName();
      String issuerBank = getIssuerBank();
      String bankAccount = getBankAccount();
      int balanceAmount = getBalanceAmount();
      int cvcNumber = getCVCNumber();
      double interestRate = getInterestRate();
      String expirationDate = getExpirationDate();
      if (cardID == INVALID || clientName.isEmpty() || issuerBank.isEmpty() || bankAccount.isEmpty() || cvcNumber == INVALID || interestRate == INVALID || expirationDate.isEmpty()) {
        JOptionPane.showMessageDialog(frame,"Fields cannot be empty, Please Fill them before adding Credit Card","Empty Fields",JOptionPane.ERROR_MESSAGE);
      }
      else if (checkCreditCardUnique(cardID)){
        cardList.add(new CreditCard(cardID, clientName, issuerBank, bankAccount, balanceAmount, cvcNumber, interestRate, expirationDate));
        String message = "Card ID:  "+ cardID+ "\nClient Name:  " + clientName+ "\nIssuer Bank: "+ issuerBank+ "\nBank Account: "+ bankAccount + "\nBalance Amount: "+ balanceAmount + "\nCVC Number: "+ cvcNumber + "\nInterest Rate: " + interestRate + "\nExpiration Date: " + expirationDate;
        JOptionPane.showMessageDialog(frame, message, "Credit Card added sucessfully",JOptionPane.OK_CANCEL_OPTION);
          } 
      else{
        JOptionPane.showMessageDialog(frame,"Credit Card could't be added."+"\n Fill all the fields correctly.","Credit Card not added",JOptionPane.ERROR_MESSAGE);  
      }
    }

    //cancel credit card 
    public void cancelCreditCard(){   
      if(getCancelCreditCardID()!= INVALID){
         for(BankCard bObj: cardList)
         {
          if(bObj instanceof CreditCard)
          {
            CreditCard cObj = (CreditCard) bObj;
            if(cObj.getCardId() == getCancelCreditCardID()){
              if(cObj.getIsGranted() == true){
               cObj.cancelCreditCard();
               JOptionPane.showMessageDialog(frame,"Credit card is cancelled successfully.","Cancel CreditCard",JOptionPane.OK_OPTION);
              }
              else{
                JOptionPane.showMessageDialog(frame,"The Credit card is not Granted. Set credit limit first.","Credit Card not cancelled",JOptionPane.ERROR_MESSAGE);
                
              }
            }
          
          else{
              JOptionPane.showMessageDialog(frame,"The card Id provided did not match. Try again.","Wrong Card ID",JOptionPane.ERROR_MESSAGE);
            }
          }
         }
      } 
      
      else{
        JOptionPane.showMessageDialog(frame, "Object of Credit Card not found.", "CreditCard not added",JOptionPane.ERROR_MESSAGE);
        
      }
    }

    // check if debit card  Card id is unique    
    public boolean checkDebitCardUnique(int cardID)
    {
      boolean isUnique = true;
      for (BankCard bObj : cardList){
        if(bObj instanceof DebitCard){
          DebitCard dc = (DebitCard) bObj;
          if(dc.getCardId() == cardID){
            JOptionPane.showMessageDialog(frame, "Card ID is already added. Please add different ID.","Card ID not unique",JOptionPane.WARNING_MESSAGE);
            isUnique = false;
            break;
          }
      }
    }
      return isUnique;
    
  }
    //method to check credit card's card id is unique
    public boolean checkCreditCardUnique(int cardid)
    {
      boolean isUnique = true;
      for (BankCard bObj : cardList){
       if(bObj instanceof CreditCard){
         CreditCard cc = (CreditCard) bObj;
        if(cc.getCardId() == cardid)
        {
          JOptionPane.showMessageDialog(frame, "Card ID is already added. Please add different ID.","Card ID not unique",JOptionPane.WARNING_MESSAGE);
            isUnique = false;
            break;
        }
      }
    }
      return isUnique;
      
    }


    // method to set credit limit
    public void addCreditLimit(){
      int cardID = getCardIDCredit();
      int creditLimit = getCreditLimit();
      int GracePeriod = getGracePeriod();
      for(BankCard obj2 : cardList){
        if(obj2 instanceof CreditCard){
          
          CreditCard cc = (CreditCard) obj2;
          if(cc.getCardId() == cardID){
            JOptionPane.showMessageDialog(frame, "Credit Limit: "+creditLimit+"\nGrace Period: "+GracePeriod ,"Credit Limit Added",JOptionPane.OK_CANCEL_OPTION);
            cc.setCreditLimit(creditLimit, GracePeriod);
            
          }
          else{
            JOptionPane.showMessageDialog(frame, "The Card ID provided doesn't match."+"\n Credit Limit cannot be set","Credit Limit not set",JOptionPane.ERROR_MESSAGE);
          }
        }
      }

    }

    

   // Display method for display buttons
    public void Display()
    {
    for (BankCard obj : cardList){
      if(obj instanceof DebitCard){
      DebitCard dc = (DebitCard) obj;
      dc.disout();
      JOptionPane.showMessageDialog(frame,"The details of Debit card is printed in the terminal. Please check there.","Display Information",JOptionPane.INFORMATION_MESSAGE);
      }
      else if(obj instanceof CreditCard){
        CreditCard cc = (CreditCard) obj;
        cc.disout();
        JOptionPane.showMessageDialog(frame,"The details of Credit card is printed in the terminal. Please check there.","Display Information",JOptionPane.INFORMATION_MESSAGE);
      }
      else{
        JOptionPane.showMessageDialog(frame,"Cannot find the object in cardList. Add a card first.","Object not set",JOptionPane.ERROR_MESSAGE);
      }
    }
  }

  
    
    //BankCard getter methods .........................................................................................................
    //BankCard BalanceAmount
    public int getBalanceAmount(){
      String BalanceAmountText = BAmtf.getText().trim();
      int BalanceAmount = INVALID;
      try{
       
        BalanceAmount = Integer.parseInt(BalanceAmountText);
        if(BalanceAmount < 0 ){
         BalanceAmount = INVALID;
         JOptionPane.showMessageDialog(frame, "Enter valid positive Integer number for Balance Amount", "Invalid Value",
         JOptionPane.WARNING_MESSAGE);

        }

        if (BalanceAmountText.isEmpty()){
          JOptionPane.showMessageDialog(frame, "Please fill BalanceAmount Field", "Error", JOptionPane.WARNING_MESSAGE);
        }
      }
      catch(NumberFormatException e){
        JOptionPane.showMessageDialog(frame,"Error "+  e.getMessage(), "Error box", JOptionPane.ERROR_MESSAGE);
      }
      return BalanceAmount;   
    
    }
   
    //BankCard IssuerBank
    public String getIssuerBank(){
      String IssuerBankText = IBtf.getText().trim();  
      if (IssuerBankText.isEmpty()){
        JOptionPane.showMessageDialog(frame, "Please fill Issuer Bank Field", "Error", JOptionPane.WARNING_MESSAGE);
      }
      return IssuerBankText;   
    }

    //BankCard BankAccount
    public String getBankAccount(){
      String BankAccountText = BActf.getText().trim();  
      if (BankAccountText.isEmpty()){
        JOptionPane.showMessageDialog(frame, "Please fill Bank ACcount Field", "Error", JOptionPane.WARNING_MESSAGE);
      }
      return BankAccountText;  
    }

    //BankCard ClientName
    public String getClientName(){
      String ClientNameText = CNatf.getText().trim();  
      if (ClientNameText.isEmpty()){
        JOptionPane.showMessageDialog(frame, "Please fill Client Name Field", "Error", JOptionPane.WARNING_MESSAGE);
      }
      return ClientNameText;  
    }
    

    //credit card getter methods >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 

    //addCredit CardId
    public int getAddCardIDCredit(){
      String CardIDText = CC_Add_CIDtf.getText().trim();
      int CardID = INVALID;
      try{
         if (CardIDText.isEmpty()){
          JOptionPane.showMessageDialog(frame, "Please fill CardID Text Field", "Error", JOptionPane.WARNING_MESSAGE);
        }
        CardID = Integer.parseInt(CardIDText);
        if(CardID <= 0 ){
         CardID = INVALID;
         JOptionPane.showMessageDialog(frame, "Enter valid positive Integer number for Card ID.", "Invalid Value",JOptionPane.WARNING_MESSAGE);
        }
      }
      catch(NumberFormatException e){
        JOptionPane.showMessageDialog(frame,"Error "+  e.getMessage(), "Error box", JOptionPane.ERROR_MESSAGE);
      }
      return CardID;
    }

    //addCreditCard cvcNumber
    public int getCVCNumber(){
      String CVCNumberText = CVCtf.getText().trim();
      int CVCNumber = INVALID;
      try{
        if (CVCNumberText.isEmpty()){
          JOptionPane.showMessageDialog(frame, "Please fill CVC Number Field", "Error", JOptionPane.WARNING_MESSAGE);
        }
    
        CVCNumber = Integer.parseInt(CVCNumberText);
        if(CVCNumber <= 0 ){
         CVCNumber = INVALID;
         JOptionPane.showMessageDialog(frame, "Enter valid positive Integer number for CVC Number", "Invalid Value",
         JOptionPane.WARNING_MESSAGE);
        }
      }
      catch(NumberFormatException e){
        JOptionPane.showMessageDialog(frame,"Error "+ e.getMessage(), "Error box", JOptionPane.ERROR_MESSAGE);
      }
      return CVCNumber;   
    }
    
    //addCreditCard interestRate
    public double getInterestRate(){
      String InterestRateText = IRtf.getText().trim();
      double InterestRate = INVALID;
      try{
        if (InterestRateText.isEmpty()){
          JOptionPane.showMessageDialog(frame, "Please fill Interest Rate Field", "Error", JOptionPane.WARNING_MESSAGE);
        }
        InterestRate = Double.parseDouble(InterestRateText);
        if(InterestRate <= 0 ){
         InterestRate = INVALID;
         JOptionPane.showMessageDialog(frame, "Enter valid positive Double number for Interest Rate", "Invalid Value",
         JOptionPane.WARNING_MESSAGE);
        }
      }
      catch(NumberFormatException e){
        JOptionPane.showMessageDialog(frame,"Error "+  e.getMessage(), "Error box", JOptionPane.ERROR_MESSAGE);
      }
      return InterestRate;   
    }
    
    //addCreditCard ExpirationDate
    public String getExpirationDate(){
      String date = "";
      String year = EYears.getSelectedItem().toString();
      String month = EMonths.getSelectedItem().toString();
      String day = EDays.getSelectedItem().toString();
      try{
      if(year.equals("Year") || month.equals("Month") || day.equals("Day")) {
         date = null;
         JOptionPane.showMessageDialog(frame, "Please choose the Expiration Date", "Empty value",
         JOptionPane.WARNING_MESSAGE);
      }
       else {
          date = year + "-" + month + "-" + day;
       }   
      
    }
    catch(Exception e){
      JOptionPane.showMessageDialog(frame,"Error "+  e.getMessage(), "Error box", JOptionPane.ERROR_MESSAGE);
    
       
    }
     
      return date;
    }


    //setCreditLimit creditlimit
    public int getCreditLimit(){
      String CreditLimitText = CLtf.getText().trim();
      int CreditLimit = INVALID;
      try{
        CreditLimit = Integer.parseInt(CreditLimitText);
        if (CreditLimitText.isEmpty()){
          JOptionPane.showMessageDialog(frame, "Please fill Credit Limit Field", "Error", JOptionPane.WARNING_MESSAGE);
        }
        if(CreditLimit <= 0 ){
         CreditLimit = INVALID;
         JOptionPane.showMessageDialog(frame, "Enter valid positive Double number for Credit Limit", "Invalid Value",
         JOptionPane.WARNING_MESSAGE);
        }
      } 
      catch(NumberFormatException e){
        JOptionPane.showMessageDialog(frame,"Error "+  e.getMessage(), "Error box", JOptionPane.ERROR_MESSAGE);
      
      }
      return CreditLimit;   
      
    }  
    
    //setCreditLimit cardid
    public int getCardIDCredit(){
      String CardIDText = CCIDtf.getText().trim();
      int CardID = INVALID;
      try{
         if (CardIDText.isEmpty()){
          JOptionPane.showMessageDialog(frame, "Please fill CardID Text Field", "Error", JOptionPane.WARNING_MESSAGE);
        }
        CardID = Integer.parseInt(CardIDText);
        if(CardID <= 0 ){
         CardID = INVALID;
         JOptionPane.showMessageDialog(frame, "Enter valid positive Integer number for Card ID.", "Invalid Value",JOptionPane.WARNING_MESSAGE);
        }
      }
      catch(NumberFormatException e){
        JOptionPane.showMessageDialog(frame,"Error "+  e.getMessage(), "Error box", JOptionPane.ERROR_MESSAGE);
      }
      return CardID;
    }
    
    //setcreditlimit graceperiod
    public int getGracePeriod(){
      String GracePeriodText = GPtf.getText().trim();
      int GracePeriod = INVALID;
      try{
        GracePeriod = Integer.parseInt(GracePeriodText);
        if (GracePeriodText.isEmpty()){
          JOptionPane.showMessageDialog(frame, "Please fill Grace Period Field", "Error", JOptionPane.WARNING_MESSAGE);
        }
        if(GracePeriod <= 0 ){
         GracePeriod = INVALID;
         JOptionPane.showMessageDialog(frame, "Enter valid positive Integer number for Grace Period", "Invalid Value",
         JOptionPane.WARNING_MESSAGE);
        }
        }

      catch(NumberFormatException e){
        JOptionPane.showMessageDialog(frame,"Error "+  e.getMessage(), "Error box", JOptionPane.ERROR_MESSAGE);
      }
      return GracePeriod;   
    }

    //cancelCreditCard cardid
    public int getCancelCreditCardID(){
      String CardIDText = CancelCreditIDtf.getText().trim();
      int CardID = INVALID;
      try{
         if (CardIDText.isEmpty()){
          JOptionPane.showMessageDialog(frame, "Please fill CardID Text Field", "Error", JOptionPane.WARNING_MESSAGE);
        }
        CardID = Integer.parseInt(CardIDText);
        if(CardID <= 0 ){
         CardID = INVALID;
         JOptionPane.showMessageDialog(frame, "Enter valid positive Integer number for Card ID.", "Invalid Value",         JOptionPane.WARNING_MESSAGE);
        }
      }
      catch(NumberFormatException e){
        JOptionPane.showMessageDialog(frame,"Error "+  e.getMessage(), "Error box", JOptionPane.ERROR_MESSAGE);
      }
      return CardID;
    }


    // DebitCard getter methods >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    
    //addDebitCard pinnumber
    public int getPinNumber(){
      String PinNumberText = PNtf.getText().trim();
      int PinNumber = INVALID;
      try{
        PinNumber = Integer.parseInt(PinNumberText);
        if (PinNumberText.isEmpty()){
          JOptionPane.showMessageDialog(frame, "Please fill Pin Number Field", "Error", JOptionPane.WARNING_MESSAGE);
        }
        if(PinNumber < 0 ){
         PinNumber = INVALID;
         JOptionPane.showMessageDialog(frame, "Enter valid positive Integer number for Pin Number", "Invalid Value",
         JOptionPane.WARNING_MESSAGE);
        }
      }
      catch(NumberFormatException e){
        JOptionPane.showMessageDialog(frame,"Error "+ e.getMessage(), "Error box", JOptionPane.ERROR_MESSAGE);
      }
      return PinNumber;   
    }

    //addDebitCard cardid
    public int getAddDebitCardId(){
      String DebitCardIDText = DC_Add_IDtf.getText().trim();
      int DebitCardID = INVALID;
      try{
         if (DebitCardIDText.isEmpty()){
          JOptionPane.showMessageDialog(frame, "Please fill DebitCardID Text Field", "Error", JOptionPane.WARNING_MESSAGE);
        }
        DebitCardID = Integer.parseInt(DebitCardIDText);
        if(DebitCardID <= 0 ){
         DebitCardID = INVALID;
         JOptionPane.showMessageDialog(frame, "Enter valid positive Integer number for Card ID.", "Invalid Value",  JOptionPane.WARNING_MESSAGE);
        }
      }
      catch(NumberFormatException e){
        JOptionPane.showMessageDialog(frame,"Error "+  e.getMessage(),"Error box", JOptionPane.ERROR_MESSAGE);
      }
      return DebitCardID;
    }
    
    //withdrawal pinNumber
    public int getWithdrawalPinNumber(){
      String PinNumberText = PNWtf.getText().trim();
      int PinNumber = INVALID;
      try{
        PinNumber = Integer.parseInt(PinNumberText);
        if (PinNumberText.isEmpty()){
          JOptionPane.showMessageDialog(frame, "Please fill Pin Number Field", "Error", JOptionPane.WARNING_MESSAGE);
        }
        if(PinNumber < 0 ){
         PinNumber = INVALID;
         JOptionPane.showMessageDialog(frame, "Enter valid positive Integer number for Pin Number", "Invalid Value",
         JOptionPane.WARNING_MESSAGE);
        }
      }
      catch(NumberFormatException e){
        JOptionPane.showMessageDialog(frame,"Error "+  e.getMessage(), "Error box", JOptionPane.ERROR_MESSAGE);
      }
      return PinNumber;   
    }

    //withdrawal withdrawalAmount
    public int getWithdrawalAmount(){
      String WithdrawalAmountText = WAmtf.getText().trim();
      int WithdrawalAmount = INVALID;
      try{
        WithdrawalAmount = Integer.parseInt(WithdrawalAmountText);
        if (WithdrawalAmountText.isEmpty()){
          JOptionPane.showMessageDialog(frame, "Please fill Withdrawal Amount Field", "Error", JOptionPane.WARNING_MESSAGE);
        }
        if(WithdrawalAmount < 0 ){
         WithdrawalAmount = INVALID;
         JOptionPane.showMessageDialog(frame, "Enter valid positive Integer number for Withdrawal", "Invalid Value",
         JOptionPane.WARNING_MESSAGE);
        }
      }
      catch(NumberFormatException e){
        JOptionPane.showMessageDialog(frame,"Error "+  e.getMessage(), "Error box", JOptionPane.ERROR_MESSAGE);
      }
      return WithdrawalAmount;   
    }

    //withdrwawal dateofWithdrawal    
    public String getDateOfWithdrawal(){
      String date = "";
      String year = WYears.getSelectedItem().toString();
      String month = WMonths.getSelectedItem().toString();
      String day = WDays.getSelectedItem().toString();
       
      try{
      if(year.equals("Year") || month.equals("Month") || day.equals("Day")) {
         date = null;
      }
      else {
         date = year + "-" + month + "-" + day;
      }
    }
    catch(Exception e){
      JOptionPane.showMessageDialog(frame,"Error "+  e.getMessage(),"Error box", JOptionPane.ERROR_MESSAGE);
    
    }

      return date;
    }

    //withdrawal cardid
    public int getDebitCardId(){
      String DebitCardIDText = DCIDtf.getText().trim();
      int DebitCardID = INVALID;
      try{
         if (DebitCardIDText.isEmpty()){
          JOptionPane.showMessageDialog(frame, "Please fill DebitCardID Text Field", "Error", JOptionPane.WARNING_MESSAGE);
        }
        DebitCardID = Integer.parseInt(DebitCardIDText);
        if(DebitCardID <= 0 ){
         DebitCardID = INVALID;
         JOptionPane.showMessageDialog(frame, "Enter valid positive Integer number for Card ID.", "Invalid Value",  JOptionPane.WARNING_MESSAGE);
        }
      }
      catch(NumberFormatException e){
        JOptionPane.showMessageDialog(frame,"Error "+  e.getMessage(),"Error box", JOptionPane.ERROR_MESSAGE);
      }
      return DebitCardID;
    }
   
   
    // main method of BankGUI class
    public static void main(String[] args) {
      // calling the construstor and setting the frame visibility to true
        new BankGUI().frame.setVisible(true);;
    }
   
  


}



