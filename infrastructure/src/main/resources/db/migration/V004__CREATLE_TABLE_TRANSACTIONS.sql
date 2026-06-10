CREATE TABLE Transactions(
    Id BIGINT AUTO_INCREMENT PRIMARY KEY,
    FromWallet BIGINT NOT NULL ,
    ToWallet BIGINT NOT NULL,
    transaction_value DECIMAL(10, 2) NOT NULL,
    Status VARCHAR(30) NOT NULL,
    created_at DATETIME NOT NULL DEFAULT  CURRENT_TIMESTAMP,
    update_at DATETIME,

    FOREIGN KEY (FromWallet) REFERENCES Wallets(Id),
    FOREIGN KEY (ToWallet) REFERENCES Wallets(Id)
)
