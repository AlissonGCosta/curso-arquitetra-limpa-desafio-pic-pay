-- V005__recreate_schema.sql
-- This migration drops existing tables that depend on Users and recreates the schema
-- with consistent column defaults to avoid NOT NULL insertion errors.
-- WARNING: this will remove data from the affected tables. Backup if needed.

-- Drop child tables first to avoid FK errors
DROP TABLE IF EXISTS Transactions CASCADE;
DROP TABLE IF EXISTS Wallets CASCADE;
DROP TABLE IF EXISTS TransactionsPin CASCADE;
DROP TABLE IF EXISTS Users CASCADE;

-- Recreate Users table (keep original column names but add sensible defaults)
CREATE TABLE Users(
    Id UUID NOT NULL PRIMARY KEY,
    Email VARCHAR(70) NOT NULL UNIQUE,
    Password VARCHAR(255) NOT NULL,
    tax_number VARCHAR(15) NOT NULL UNIQUE,
    full_name VARCHAR(70), -- allow null to avoid insert failures if app doesn't provide it
    Type VARCHAR(30) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Recreate TransactionsPin
CREATE TABLE TransactionsPin(
    Id BIGINT AUTO_INCREMENT PRIMARY KEY,
    Pin VARCHAR(50) NOT NULL,
    Attempt INT NOT NULL,
    Blocked BOOLEAN NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Recreate Wallets (note column names match entity @JoinColumn names)
CREATE TABLE Wallets(
    Id BIGINT AUTO_INCREMENT PRIMARY KEY,
    balance DECIMAL(10, 2) NOT NULL,
    UserId UUID NOT NULL UNIQUE,
    TransactionPinId BIGINT NOT NULL UNIQUE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (UserId) REFERENCES  Users(Id),
    FOREIGN KEY (TransactionPinId) REFERENCES  TransactionsPin(Id)
);

-- Recreate Transactions
CREATE TABLE Transactions(
    Id BIGINT AUTO_INCREMENT PRIMARY KEY,
    FromWallet BIGINT NOT NULL,
    ToWallet BIGINT NOT NULL,
    transaction_value DECIMAL(10, 2) NOT NULL,
    Status VARCHAR(30) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (FromWallet) REFERENCES Wallets(Id),
    FOREIGN KEY (ToWallet) REFERENCES Wallets(Id)
);
