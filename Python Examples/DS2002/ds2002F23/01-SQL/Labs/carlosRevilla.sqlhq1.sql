-- cfr5spw, Carlos Revilla

-- ------------------------------------------------------------------
-- 0). First, How Many Rows are in the Products Table?
-- ------------------------------------------------------------------
SELECT COUNT(*) FROM products;

-- ------------------------------------------------------------------
-- 1). Product Name and Unit/Quantity
-- ------------------------------------------------------------------

SELECT product_name, quantity_per_unit FROM products;

-- ------------------------------------------------------------------
-- 2). Product ID and Name of Current Products
-- ------------------------------------------------------------------
SELECT id, product_name FROM products WHERE discontinued = false;

-- ------------------------------------------------------------------
-- 3). Product ID and Name of Discontinued Products
-- ------------------------------------------------------------------
SELECT id, product_name FROM products WHERE discontinued = true;

-- ------------------------------------------------------------------
-- 4). Name & List Price of Most & Least Expensive Products
-- ------------------------------------------------------------------
SELECT product_name, list_price
FROM products
WHERE list_price = (SELECT MAX(list_price) FROM products)
OR list_price = (SELECT MIN(list_price) FROM products);

-- ------------------------------------------------------------------
-- 5). Product ID, Name & List Price Costing Less Than $20
-- ------------------------------------------------------------------
SELECT id, product_name, list_price FROM products WHERE list_price < 20.00;
-- ------------------------------------------------------------------
-- 6). Product ID, Name & List Price Costing Between $15 and $20
-- ------------------------------------------------------------------
SELECT id, product_name, list_price FROM products WHERE list_price BETWEEN 15.00 AND 20.00;
-- ------------------------------------------------------------------
-- 7). Product Name & List Price Costing Above Average List Price
-- ------------------------------------------------------------------

SELECT product_name, list_price
FROM products
WHERE list_price > (SELECT AVG(list_price) FROM products);

-- ------------------------------------------------------------------
-- 8). Product Name & List Price of 10 Most Expensive Products 
-- ------------------------------------------------------------------
SELECT product_name, list_price
FROM products
ORDER BY list_price DESC
LIMIT 10;

-- ------------------------------------------------------------------ 
-- 9). Count of Current and Discontinued Products 
-- ------------------------------------------------------------------
SELECT discontinued, COUNT(*)
FROM products
GROUP BY discontinued;

-- ------------------------------------------------------------------
-- 10). Product Name, Units on Order and Units in Stock
--      Where Quantity In-Stock is Less Than the Quantity On-Order. 
-- ------------------------------------------------------------------
-- come back to this one
SELECT product_name, reorder_level , quantity_per_unit
FROM products
WHERE quantity_per_unit < reorder_level;
-- ------------------------------------------------------------------
-- EXTRA CREDIT -----------------------------------------------------
-- ------------------------------------------------------------------

-- ------------------------------------------------------------------
-- 11). Products with Supplier Company & Address Info
-- ------------------------------------------------------------------
SELECT product_name, supplier_ids
FROM products;

-- ------------------------------------------------------------------
-- 12). Number of Products per Category With Less Than 5 Units
-- ------------------------------------------------------------------
SELECT category, COUNT(*)
FROM products
WHERE quantity_per_unit < 5
GROUP BY category;
-- ------------------------------------------------------------------
-- 13). Number of Products per Category Priced Less Than $20.00
-- ------------------------------------------------------------------
SELECT category, COUNT(*)
FROM products
WHERE list_price < 20.00
GROUP BY category;