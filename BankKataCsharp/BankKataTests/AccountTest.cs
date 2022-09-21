using BankKata;
using Moq;
using System.Collections.Generic;
using Xunit;

namespace BankKataTests
{
    public class AccountTest
    {

        Account _account;
        readonly Mock<ITransactionRepository> _transactionRepository = new Mock<ITransactionRepository>();
        readonly Mock<IStatementPrinter> _statementPrinter = new Mock<IStatementPrinter>();

        public AccountTest()
        {
            _account = new Account(_transactionRepository.Object, _statementPrinter.Object);
        }

        [Fact]
        public void ShouldStoreADepositTransaction()
        {
            _account.Deposit(100);

            _transactionRepository.Verify(it => it.AddDepositTransaction(100));
        }

        [Fact]
        public void ShouldStoreAWithdrawalTransaction()
        {
            _account.Withdraw(100);

            _transactionRepository.Verify(it => it.AddWithDrawalTransaction(100));
        }

        [Fact]
        public void ShouldPrintAllTransactions()
        {
            var allTransactions = new List<Transaction>();
            _transactionRepository.Setup(it => it.GetAllTransactions()).Returns(allTransactions);

            _account.PrintStatement();

            _statementPrinter.Verify(it => it.Print(allTransactions));
        }
    }
}
