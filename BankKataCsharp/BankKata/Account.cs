using BankKataTests;
using System;

namespace BankKata
{
    public class Account
    {
        private readonly ITransactionRepository _transactionRepository;
        private readonly IStatementPrinter _statementPrinter;

        public Account(ITransactionRepository transactionRepository, IStatementPrinter statementPrinter)
        {
            _transactionRepository = transactionRepository;
            _statementPrinter = statementPrinter;
        }

        public void Deposit(int amount)
        {
            _transactionRepository.AddDepositTransaction(100);
        }

        public void Withdraw(int amount)
        {
            _transactionRepository.AddWithDrawalTransaction(amount);
        }

        public void PrintStatement()
        {
            _statementPrinter.Print(_transactionRepository.GetAllTransactions());
        }
    }
}