package com.finance_tracker.transaction;

enum TransactionEnum {
    ONE_TIME,
    RECURRING;
}


enum TransactionFrequencyEnum {
    WEEKLY,
    MONTHLY,
    ANNUALLY
}


// A "nice to have" will be letting the user add unique category names
enum CategoryEnum {
    VACATION,
    GIFT,
    BILLS,
    FOOD,
    ENTERTAINMENT,
    CLOTHES,
    MISC_SPENDING,
    FITNESS
}
