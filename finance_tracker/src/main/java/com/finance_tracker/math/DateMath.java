package com.finance_tracker.math;

import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import com.finance_tracker.account.Account;
import com.finance_tracker.database.Mapper;
import com.finance_tracker.transaction.Transaction;

public class DateMath {


    // https://www.javatpoint.com/java-get-current-date
    protected Date getCurrentDate() {
        Date date = new Date();
        return date;
    }
    
    
    // https://stackabuse.com/how-to-get-the-number-of-days-between-dates-in-java/
    protected int getDayDiff(Date dateBefore, Date dateAfter) {
        long dateBeforeInMs = dateBefore.getTime();
        long dateAfterInMs = dateAfter.getTime();
    
        long timeDiff = Math.abs(dateAfterInMs - dateBeforeInMs);
        long daysDiffLong = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);
        // Doesn't have a TimeUnit for months or years?
        // Four our purposes we can just divide days by 30 or 365 for month/year
        // Proof of concept, rather than the nitty gritty of date math.
        int daysDiff = (int) daysDiffLong;
        return daysDiff;
    }


    protected Date getLastUpdateDate() {
        Mapper databaseMapper = Mapper.getInstance();
        HashMap<String, Transaction>  transactions = databaseMapper.getTransactions();
        HashMap<String, Account>  accounts = databaseMapper.getAccounts();

        Date lastUpdateDate = null;
        for (Transaction t: transactions.values()) {
            // first check all transactions
            Date transactionDate = t.getDate();
            if (transactionDate.after(lastUpdateDate)) {
                // if transaction is more recent than last most-recent transaction
                // its becomes the new most recent transaction
                lastUpdateDate = transactionDate;
            }
        }
        for (Account a: accounts.values()) {
            // then check all accounts (order doesn't matter)
            Date accountDate = a.getDate();
            if (accountDate.after(lastUpdateDate)) {
                lastUpdateDate = accountDate;
            }
        }
        return lastUpdateDate;
    }
}