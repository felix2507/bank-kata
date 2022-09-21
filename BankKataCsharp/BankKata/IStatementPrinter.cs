using System.Collections.Generic;

namespace BankKataTests
{
    public interface IStatementPrinter
    {
        void Print(IList<Transaction> allTransactions);
    }
}