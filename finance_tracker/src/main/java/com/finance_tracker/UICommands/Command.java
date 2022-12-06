package com.finance_tracker.UICommands;

import java.util.Scanner;

import com.finance_tracker.backendlogic.DataFacade;
import com.finance_tracker.backendlogic.Mediator;

public abstract class Command {
    protected Scanner UserInput = new Scanner(System.in);
    protected Mediator CentralRef;
    protected DataFacade DataRef;
    protected String Name;
    protected Integer CodeNum;

    public Command(Mediator CentralRef){
        this.CentralRef = CentralRef;
        this.DataRef = this.CentralRef.getData();

    }

    public abstract void execute();

    public String getName(){
        return this.Name;
    }

    public Integer getNumber(){
        return CodeNum;
    }
}
