package com.finance_tracker.UICommands;

import com.finance_tracker.backendlogic.Mediator;

public class CreateFile extends Command{
    
    public CreateFile(Mediator CentralRef){
        super(CentralRef);
        this.CodeNum = 1;
        this.Name = "Create File";

    }
}
