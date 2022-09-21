using System.Collections.Generic;
using BankKata;
using Moq;
using Xunit;

namespace BankKataTests
{
    public class PrintStatementFeatureTest
    {
        private readonly Mock<IConsole> _consoleMock;
        private readonly ITransactionRepository _transactionRepository;
        private readonly Account _account;

        private readonly IList<string> _printedConsoleStatements;
        private IStatementPrinter _statementPrinter;

        public PrintStatementFeatureTest()
        {
            // Moq hat leider keine (elegante) Möglichkeit die Reihenfolge von Aufrufen zu prüfen,
            // daher machen wir das "zu Fuß"
            _printedConsoleStatements = new List<string>();

            _consoleMock = new Mock<IConsole>(MockBehavior.Strict);
            _consoleMock.Setup(x => x.PrintLine(It.IsAny<string>()))
                .Callback((string text) => _printedConsoleStatements.Add(text));

            _transactionRepository = new TransactionRepository();
            _statementPrinter = new StatementPrinter();

            _account = new Account(_transactionRepository, _statementPrinter);
        }

        [Fact]
        public void PrintsRunningBalanceOfAllTransactions()
        {
            _account.Deposit(1000);
            _account.Withdraw(100);
            _account.Deposit(400);

            _account.PrintStatement();

            Assert.Equal(new[]
            {
                "DATE | AMOUNT | BALANCE",
                "10/04/2014 | 500.00 | 1400.00",
                "02/04/2014 | -100.00 | 900.00",
                "01/04/2014 | 1000.00 | 1000.00"
            }, _printedConsoleStatements);
        }
    }
}