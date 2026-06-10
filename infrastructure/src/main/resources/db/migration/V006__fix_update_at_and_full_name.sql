-- V006__fix_update_at_and_full_name.sql
-- Fill NULL update_at and full_name values and enforce NOT NULL + DEFAULT
-- Works for H2/Postgres-like syntax used in local dev. Review before applying in production.

-- 1) Ensure no NULLs remain
UPDATE Users SET update_at = CURRENT_TIMESTAMP WHERE update_at IS NULL;
UPDATE TransactionsPin SET update_at = CURRENT_TIMESTAMP WHERE update_at IS NULL;
UPDATE Wallets SET update_at = CURRENT_TIMESTAMP WHERE update_at IS NULL;
UPDATE Transactions SET update_at = CURRENT_TIMESTAMP WHERE update_at IS NULL;

UPDATE Users SET full_name = '' WHERE full_name IS NULL;

-- 2) Set DEFAULTs and NOT NULL constraints so DB enforces timestamps
ALTER TABLE Users ALTER COLUMN update_at SET DEFAULT CURRENT_TIMESTAMP;
ALTER TABLE Users ALTER COLUMN update_at SET NOT NULL;
ALTER TABLE TransactionsPin ALTER COLUMN update_at SET DEFAULT CURRENT_TIMESTAMP;
ALTER TABLE TransactionsPin ALTER COLUMN update_at SET NOT NULL;
ALTER TABLE Wallets ALTER COLUMN update_at SET DEFAULT CURRENT_TIMESTAMP;
ALTER TABLE Wallets ALTER COLUMN update_at SET NOT NULL;
ALTER TABLE Transactions ALTER COLUMN update_at SET DEFAULT CURRENT_TIMESTAMP;
ALTER TABLE Transactions ALTER COLUMN update_at SET NOT NULL;

-- 3) Make Users.full_name NOT NULL (we filled NULLs above)
ALTER TABLE Users ALTER COLUMN full_name SET NOT NULL;
