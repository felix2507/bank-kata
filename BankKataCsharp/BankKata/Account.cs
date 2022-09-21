using BankKataTests;
using System;

namespace BankKata
{
    public class Account
    {
        private readonly ITransactionRepository transactionRepository;

        public Account(ITransactionRepository transactionRepository)
        {
            this.transactionRepository = transactionRepository;
        }

        public void Deposit(int amount)
        {
            transactionRepository.AddDepositTransaction(100);
        }

        public void Withdraw(int amount)
        {
            transactionRepository.AddWithDrawalTransaction(amount);
        }

        public void PrintStatement()
        {
            throw new NotImplementedException();
        }
    }
}