package com.finance_tracker.UICommands;

import com.finance_tracker.backendlogic.Mediator;

import java.util.ArrayList;
import java.util.Date;

import com.finance_tracker.account.Account;
import com.finance_tracker.account.AccountBuilder;
import com.finance_tracker.account.AccountEnum;
import com.finance_tracker.account.AccountRecord;
import com.finance_tracker.account.InterestEnum;
import com.finance_tracker.account.InterestPeriodEnum;

public class CreateAccount extends Command{
    
    public CreateAccount(Mediator CentralRef){
        super(CentralRef);
        this.CodeNum = 1;
        this.Name = "Create Account";
    }

    public void execute(){
        ArrayList<AccountRecord> EmptyList = new ArrayList<AccountRecord>();
        System.out.println("Enter Name: ");
        Name = this.UserInput.nextLine();
        AccountBuilder Builder = new AccountBuilder(Name,EmptyList);

        System.out.println("Enter Account Enum (int): ");
        int i =1;
        for(AccountEnum E: AccountEnum.values()){
            System.out.print(String.valueOf(i)+": ");
            System.out.println(E);
            i++;
        }
        int EnumType = this.UserInput.nextInt();
        switch(EnumType){
            case 1:
                Builder = Builder.setAccountEnum( AccountEnum.SAVINGS);
                break;
            case 2:
                Builder = Builder.setAccountEnum( AccountEnum.CHECKING);
                break;
            case 3:
                Builder = Builder.setAccountEnum( AccountEnum.PERSONAL_LOAN);
                break;
            case 4:
                Builder = Builder.setAccountEnum( AccountEnum.AUTO_LOAN);
                break;
            case 5:
                Builder = Builder.setAccountEnum( AccountEnum.STUDENT_LOAN);
                break;
            case 6:
                Builder = Builder.setAccountEnum( AccountEnum.RETIREMENT);
                break;
            case 7:
                Builder = Builder.setAccountEnum( AccountEnum.CREDIT_CARD);
                break;
            case 8:
                Builder = Builder.setAccountEnum( AccountEnum.MORTGAGE);
                break;
            default:
                Builder = Builder.setAccountEnum( AccountEnum.SAVINGS);
                break;
        }

        System.out.println("Enter Account Interest Rate: ");
        double interestRate = this.UserInput.nextDouble();
        Builder = Builder.setInterestRate( interestRate);

        System.out.println("Enter Account Interest Enum: ");
        int j =1;
        for(AccountEnum E: AccountEnum.values()){
            System.out.print(String.valueOf(j)+": ");
            System.out.println(E);
            j++;
        }

        EnumType = this.UserInput.nextInt();
        switch(EnumType){
            case 1:
                Builder = Builder.setInterestEnum( InterestEnum.SIMPLE);
                break;
            case 2:
                Builder = Builder.setInterestEnum( InterestEnum.COMPOUND);
                break;
            case 3:
                Builder = Builder.setInterestEnum( InterestEnum.CONTINUOUS);
                break;
            default:
                Builder = Builder.setInterestEnum( InterestEnum.SIMPLE);
                break;
        }

        System.out.println("Enter Interest Period: ");
        int k=1;
        for(AccountEnum E: AccountEnum.values()){
            System.out.print(String.valueOf(k)+": ");
            System.out.println(E);
            k++;
        }

        EnumType = this.UserInput.nextInt();
        switch(EnumType){
            case 1:
                Builder = Builder.setInterestPeriodEnum( InterestPeriodEnum.DAILY);
                break;
            case 2:
                Builder = Builder.setInterestPeriodEnum( InterestPeriodEnum.MONTHLY);
                break;
            case 3:
                Builder = Builder.setInterestPeriodEnum( InterestPeriodEnum.ANNUAL);
                break;
            default:
                Builder = Builder.setInterestPeriodEnum( InterestPeriodEnum.ANNUAL);
                break;
        }

        Account AccountA = Builder.buildAccount();
        Date Now = new Date();
        AccountRecord Today = new AccountRecord(Now, 0);
        AccountA.addRecord(Today);

        CentralRef.getData().addAccount(AccountA);

    }

}