using System.Collections.Generic;

namespace BankKataTests
{
    public interface ITransactionRepository
    {
        void AddDepositTransaction(int amount);
        void AddWithDrawalTransaction(int amount);
        List<Transaction> GetAllTransactions();
    }
}