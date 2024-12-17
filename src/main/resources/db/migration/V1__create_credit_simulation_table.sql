CREATE TABLE IF NOT EXISTS credit_simulation
(
    id                  VARCHAR(255)   NOT NULL,
    amount              DECIMAL(20, 2) NOT NULL,
    interest_rate       INT            NOT NULL,
    term_in_months      DECIMAL(20, 2) NOT NULL,
    monthly_installment DECIMAL(20, 2) NOT NULL,
    total_payment       DECIMAL(20, 2) NOT NULL,
    total_interest      DECIMAL(20, 2) NOT NULL,
    created_at          TIMESTAMP      NOT NULL,
    updated_at          TIMESTAMP      NOT NULL,
    deleted_at          TIMESTAMP,
    customer_name       VARCHAR(255)   NOT NULL,
    customer_email      VARCHAR(255)   NOT NULL,
    PRIMARY KEY (id)
    );


CREATE INDEX IF NOT EXISTS idx_credit_simulation_customer_name ON credit_simulation (customer_name);
CREATE INDEX IF NOT EXISTS idx_credit_simulation_customer_email ON credit_simulation (customer_email);

CREATE INDEX IF NOT EXISTS idx_credit_simulation_customer_name_email ON credit_simulation (customer_name, customer_email);
