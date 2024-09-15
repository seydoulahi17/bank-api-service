package com.bankservice;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface BankService {
    @WebMethod
    double getBalance(String accountNumber);

    @WebMethod
    boolean deposit(String accountNumber, double amount);

    @WebMethod
    boolean withdraw(String accountNumber, double amount);
}