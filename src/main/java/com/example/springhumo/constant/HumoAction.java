package com.example.springhumo.constant;

public enum HumoAction {
    LIST_CUSTOMERS("listCustomers"),
    LIST_CUSTOMER_CARDS("listCustomerCards"),
    QUERY_CARD_INFO("queryCardInfo"),
    HISTORY("queryTransactionHistory"),
    EXPORT("export"),
    IMPORT("import"),
    GET_CARD_ACCOUNT_BALANCE("getCardAccountsBalance"),
    PAYMENT("payment"),
    GET_PAYMENT("GetPayment"),
    revert("ReturnPayment"),
    getCardPinTryCounter("getCardPinTryCounter");

    private final String action;

    private HumoAction(String action) {
        this.action = action;
    }

    public String getAction() {
        return this.action;
    }
}
