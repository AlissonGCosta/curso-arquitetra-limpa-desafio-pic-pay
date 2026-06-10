-- V009__standardize_schema_snake_case.sql
-- Remove tabelas antigas para recriar no padrão snake_case
DROP TABLE IF EXISTS transactions CASCADE;
DROP TABLE IF EXISTS wallets CASCADE;
DROP TABLE IF EXISTS transactions_pin CASCADE;
DROP TABLE IF EXISTS users CASCADE;

-- Tabela users
CREATE TABLE users (
                       id UUID NOT NULL PRIMARY KEY,
                       email VARCHAR(70) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       tax_number VARCHAR(15) NOT NULL UNIQUE,
                       full_name VARCHAR(70),
                       type VARCHAR(30) NOT NULL,
                       created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                       update_at TIMESTAMP  DEFAULT CURRENT_TIMESTAMP
);

-- Tabela transactions_pin
CREATE TABLE transactions_pin (
                                  id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                  pin VARCHAR(50) NOT NULL,
                                  attempt INT NOT NULL,
                                  blocked BOOLEAN NOT NULL,
                                  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                  update_at TIMESTAMP  DEFAULT CURRENT_TIMESTAMP
);

-- Tabela wallets
CREATE TABLE wallets (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         balance DECIMAL(10, 2) NOT NULL,
                         user_id UUID NOT NULL UNIQUE,
                         transaction_pin_id BIGINT NOT NULL UNIQUE,
                         created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                         update_at TIMESTAMP  DEFAULT CURRENT_TIMESTAMP,
                         CONSTRAINT fk_wallets_user FOREIGN KEY (user_id) REFERENCES users(id),
                         CONSTRAINT fk_wallets_pin FOREIGN KEY (transaction_pin_id) REFERENCES transactions_pin(id)
);

-- Tabela transactions
CREATE TABLE transactions (
                              id BIGINT AUTO_INCREMENT PRIMARY KEY,
                              from_wallet BIGINT NOT NULL,
                              to_wallet BIGINT NOT NULL,
                              transaction_value DECIMAL(10, 2) NOT NULL,
                              status VARCHAR(30) NOT NULL,
                              created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                              update_at TIMESTAMP  DEFAULT CURRENT_TIMESTAMP,
                              CONSTRAINT fk_transactions_from_wallet FOREIGN KEY (from_wallet) REFERENCES wallets(id),
                              CONSTRAINT fk_transactions_to_wallet FOREIGN KEY (to_wallet) REFERENCES wallets(id)
);