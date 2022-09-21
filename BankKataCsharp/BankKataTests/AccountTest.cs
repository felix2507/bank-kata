using BankKata;
using Moq;
using Xunit;

namespace BankKataTests
{
    public class AccountTest
    {

        [Fact]
        public void shouldStoreADepositTransaction()
        {
            var transactionRepository = new Mock<ITransactionRepository>();
            var account = new Account(transactionRepository.Object);

            account.Deposit(100);

            transactionRepository.Verify(repo => repo.AddDepositTransaction(100));
        }

        [Fact]
        public void shouldStoreAWithdrawalTransaction()
        {
            var transactionRepository = new Mock<ITransactionRepository>();
            var account = new Account(transactionRepository.Object);

            account.Withdraw(100);

            transactionRepository.Verify(repo => repo.AddWithDrawalTransaction(100));
        }
    }
}
