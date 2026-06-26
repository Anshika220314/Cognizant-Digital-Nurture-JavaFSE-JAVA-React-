-- =========================================================
-- Exercise 3: Stored Procedures
-- =========================================================

-- Scenario 1: Apply 1% monthly interest to all savings accounts
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
IS
BEGIN
  UPDATE savings_accounts
  SET balance = balance + (balance * 0.01);
  COMMIT;
END ProcessMonthlyInterest;
/

-- Scenario 2: Add a bonus percentage to salaries of employees in a department
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
  p_department      IN VARCHAR2,
  p_bonus_percent   IN NUMBER
)
IS
BEGIN
  UPDATE employees
  SET salary = salary + (salary * p_bonus_percent / 100)
  WHERE department = p_department;
  COMMIT;
END UpdateEmployeeBonus;
/

-- Scenario 3: Transfer funds between accounts, checking sufficient balance
CREATE OR REPLACE PROCEDURE TransferFunds (
  p_from_account  IN NUMBER,
  p_to_account    IN NUMBER,
  p_amount        IN NUMBER
)
IS
  v_from_balance NUMBER;
BEGIN
  -- Lock and check source account balance
  SELECT balance INTO v_from_balance
  FROM accounts
  WHERE account_id = p_from_account
  FOR UPDATE;

  IF v_from_balance < p_amount THEN
    RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance in source account.');
  END IF;

  UPDATE accounts
  SET balance = balance - p_amount
  WHERE account_id = p_from_account;

  UPDATE accounts
  SET balance = balance + p_amount
  WHERE account_id = p_to_account;

  COMMIT;
EXCEPTION
  WHEN NO_DATA_FOUND THEN
    ROLLBACK;
    RAISE_APPLICATION_ERROR(-20002, 'One or both account IDs do not exist.');
  WHEN OTHERS THEN
    ROLLBACK;
    RAISE;
END TransferFunds;
/