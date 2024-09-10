# -*- coding: utf-8 -*-
"""
Date: 07/01/2021
File: Lab 6, BankAccount.py 
Author: Katherine Reynolds
"""
class BankAccount:

        #non-default constructor, accepts 3 parameters, and assigns initial variable values
        def __init__(self, balance, name):
            self.balance = balance
            self.name = name
            self.num_deposits = 0
            self.deposit_total = 0
            self.num_withdrawals = 0
            self.withdraw_total = 0
            
        #method that increments the value of num_deposits to keep track of how many are made
        def numDeposits(self):
            self.num_deposits = self.num_deposits + 1 
            return self.num_deposits
        
        #method that increments the value of num_withdrawals to keep track of how many are made
        def numWithdraws(self):
            self.num_withdrawals = self.num_withdrawals + 1
            return self.num_withdrawals
            
        #method that updates the values of balance and deposit_total with the amount that is being deposited 
        #and calls the method numDeposits to update the num_deposists value by 1
        def deposit(self, amount):
            self.balance = self.balance + amount
            self.deposit_total = self.deposit_total + amount
            self.numDeposits()
        
        #method that updates the values of balance and withdraw_total with the amount that is being withdrawn
        # and calls the method numWithdrawals to update the num_withdrawals value by 1
        def withdrawal(self, amount):
            self.balance = self.balance - amount
            self.withdraw_total = self.withdraw_total + amount
            self.numWithdraws()
            
        #method to print out the account info after all the withdrawals and deposists have occurred 
        def endOfMonth(self):
            print("**********")
            print("Bank account : ", self.name)
            print("Balance : $", self.balance)
            print("Number of deposits : ", self.num_deposits, " totalling $", self.deposit_total)
            print("Number of withdraws : ", self.num_withdrawals, " totalling $", self.withdraw_total)
            print("**********")
            
#creating two objects of type BankAccount
account1 = BankAccount(0, "Chase")
account2 = BankAccount(100, "Bank of America")

#deposits and withdrawals for account1
account1.deposit(50)
account1.deposit(50)
account1.withdrawal(100)
account1.withdrawal(100)
account1.withdrawal(100)

#deposits and withdrawals for account2
account2.deposit(25)
account2.deposit(25)
account2.deposit(5000)
account2.withdrawal(10)
account2.withdrawal(1000)
account2.withdrawal(70)

#printing out account1 and account2 end of month statements
account1.endOfMonth()
account2.endOfMonth()
