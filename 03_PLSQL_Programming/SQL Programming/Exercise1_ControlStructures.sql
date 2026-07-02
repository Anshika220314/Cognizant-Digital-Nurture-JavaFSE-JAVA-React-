
-- Scenario 1: Apply 1% interest discount to loans for customers > 60
BEGIN
  FOR cust_rec IN (SELECT customer_id, age FROM customers) LOOP
    IF cust_rec.age > 60 THEN
      UPDATE loans
      SET interest_rate = interest_rate - (interest_rate * 0.01)
      WHERE customer_id = cust_rec.customer_id;
    END IF;
  END LOOP;
  COMMIT;
END;
/

-- Scenario 2: Promote customers with balance > 10000 to VIP
-- Note: Oracle tables don't have a native BOOLEAN type, so IsVIP is
-- usually CHAR(1) ('Y'/'N') or NUMBER(1) (1/0). Using 'Y' here.
BEGIN
  FOR cust_rec IN (SELECT customer_id, balance FROM customers) LOOP
    IF cust_rec.balance > 10000 THEN
      UPDATE customers
      SET is_vip = 'Y'
      WHERE customer_id = cust_rec.customer_id;
    END IF;
  END LOOP;
  COMMIT;
END;
/

-- Scenario 3: Print reminders for loans due in the next 30 days
SET SERVEROUTPUT ON;
DECLARE
  v_message VARCHAR2(200);
BEGIN
  FOR loan_rec IN (
    SELECT l.loan_id, l.due_date, c.name
    FROM loans l
    JOIN customers c ON c.customer_id = l.customer_id
    WHERE l.due_date BETWEEN SYSDATE AND SYSDATE + 30
  ) LOOP
    v_message := 'Reminder: Dear ' || loan_rec.name ||
                 ', your loan (ID: ' || loan_rec.loan_id ||
                 ') is due on ' || TO_CHAR(loan_rec.due_date, 'DD-MON-YYYY') || '.';
    DBMS_OUTPUT.PUT_LINE(v_message);
  END LOOP;
END;
/