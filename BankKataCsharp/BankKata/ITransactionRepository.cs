namespace BankKataTests
{
    public interface ITransactionRepository
    {
        void AddDepositTransaction(int amount);
        void AddWithDrawalTransaction(int amount);
    }
}