-- ACCOUNT_HOLDER (cliente bancário, criado sob demanda)
CREATE TABLE account_holder (
    id SERIAL PRIMARY KEY,
    user_id INT NOT NULL UNIQUE,
    cpf VARCHAR(11) UNIQUE,
    rg VARCHAR(20),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_account_holder_user
        FOREIGN KEY (user_id)
        REFERENCES users (id)
        ON DELETE CASCADE
);

-- ACCOUNT (contas bancárias)
CREATE TABLE account (
    id SERIAL PRIMARY KEY,
    account_holder_id INT NOT NULL,
    account_number VARCHAR(15) NOT NULL UNIQUE,
    branch VARCHAR(6),
    check_digit VARCHAR(2) NOT NULL,
    account_type VARCHAR(20) NOT NULL, -- CURRENT, SAVINGS
    balance NUMERIC(19,2) DEFAULT 0,
    active BOOLEAN DEFAULT TRUE,
    opening_date DATE NOT NULL DEFAULT CURRENT_DATE,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_account_holder
        FOREIGN KEY (account_holder_id)
        REFERENCES account_holder (id)
        ON DELETE CASCADE
);