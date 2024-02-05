
-- DDL - portfolio table
CREATE TABLE Portfolio (
    StockTicker VARCHAR(10) PRIMARY KEY,
    NumberOfShares INT,
    DatePurchased DATE,
    PurchasePrice DECIMAL(10, 2),
    CurrentPrice DECIMAL(10, 2)
);

-- DDL - company table
CREATE TABLE Company (
    CompanyName VARCHAR(255),
    StockTicker VARCHAR(10) PRIMARY KEY,
    Industry VARCHAR(100)
);

-- INSERTS FOR PORTFOLIO TABLE
INSERT INTO Portfolio VALUES ('TSLA', 50, '2023-01-15', 175.50, 222.18);
INSERT INTO Portfolio VALUES ('NEM', 150, '2023-02-10', 45.10, 36.66);
INSERT INTO Portfolio VALUES ('UBER', 200, '2023-03-05', 37.00, 49.92);
INSERT INTO Portfolio VALUES ('AAPL', 100, '2023-04-01', 165.20, 181.82);
INSERT INTO Portfolio VALUES ('PLTR', 300, '2023-04-20', 21.50, 18.80);
INSERT INTO Portfolio VALUES ('AMD', 80, '2023-05-15', 95.00, 113.45);

-- INSERTS FOR COMPANY TABLE
INSERT INTO Company VALUES ('Tesla, Inc.', 'TSLA', 'Automotive');
INSERT INTO Company VALUES ('Newmont Corporation', 'NEM', 'Mining');
INSERT INTO Company VALUES ('Uber Technologies, Inc.', 'UBER', 'Technology');
INSERT INTO Company VALUES ('Apple Inc.', 'AAPL', 'Consumer Electronics');
INSERT INTO Company VALUES ('Palantir Technologies Inc.', 'PLTR', 'Software');
INSERT INTO Company VALUES ('Advanced Micro Devices, Inc.', 'AMD', 'Semiconductors');

-- @TODO generatequery to get value of shares
SELECT c.CompanyName, p.StockTicker, p.NumberOfShares, CONCAT('$', FORMAT(p.NumberOfShares * p.CurrentPrice, 2)) AS 'Value'
FROM Portfolio p
JOIN Company c ON p.StockTicker = c.StockTicker;
