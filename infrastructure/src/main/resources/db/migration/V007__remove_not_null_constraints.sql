-- V007__remove_not_null_constraints.sql
-- Remove NOT NULL constraints from non-key columns (keep primary keys and foreign keys NOT NULL)
-- Target DB: H2 / Postgres-like. Review before applying in production.

-- USERS (keep Id PK NOT NULL)
ALTER TABLE Users ALTER COLUMN Email DROP NOT NULL;
ALTER TABLE Users ALTER COLUMN Password DROP NOT NULL;
ALTER TABLE Users ALTER COLUMN tax_number DROP NOT NULL;
ALTER TABLE Users ALTER COLUMN full_name DROP NOT NULL;
ALTER TABLE Users ALTER COLUMN Type DROP NOT NULL;
ALTER TABLE Users ALTER COLUMN created_at DROP NOT NULL;
ALTER TABLE Users ALTER COLUMN update_at DROP NOT NULL;

-- TRANSACTIONSPIN (keep Id PK NOT NULL)
ALTER TABLE TransactionsPin ALTER COLUMN Pin DROP NOT NULL;
ALTER TABLE TransactionsPin ALTER COLUMN Attempt DROP NOT NULL;
ALTER TABLE TransactionsPin ALTER COLUMN Blocked DROP NOT NULL;
ALTER TABLE TransactionsPin ALTER COLUMN created_at DROP NOT NULL;
ALTER TABLE TransactionsPin ALTER COLUMN update_at DROP NOT NULL;

-- WALLETS (keep Id PK and FKs UserId/TransactionPinId NOT NULL)
ALTER TABLE Wallets ALTER COLUMN balance DROP NOT NULL;
ALTER TABLE Wallets ALTER COLUMN created_at DROP NOT NULL;
ALTER TABLE Wallets ALTER COLUMN update_at DROP NOT NULL;

-- TRANSACTIONS (keep Id PK and FKs FromWallet/ToWallet NOT NULL)
ALTER TABLE Transactions ALTER COLUMN transaction_value DROP NOT NULL;
ALTER TABLE Transactions ALTER COLUMN Status DROP NOT NULL;
ALTER TABLE Transactions ALTER COLUMN created_at DROP NOT NULL;
ALTER TABLE Transactions ALTER COLUMN update_at DROP NOT NULL;

-- End of migration
