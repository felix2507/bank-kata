using System.Collections.Generic;

namespace BankKataTests
{
    public class TransactionRepository : ITransactionRepository
    {
        public void AddDepositTransaction(int amount)
        {
            throw new System.NotImplementedException();
        }

        public void AddWithDrawalTransaction(int amount)
        {
            throw new System.NotImplementedException();
        }

        public List<Transaction> GetAllTransactions()
        {
            throw new System.NotImplementedException();
        }
    }
}