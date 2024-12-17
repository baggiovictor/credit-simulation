CREATE TABLE credit_simulation
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
    PRIMARY KEY (id)
);

CREATE INDEX idx_credit_simulation_id ON credit_simulation (id);