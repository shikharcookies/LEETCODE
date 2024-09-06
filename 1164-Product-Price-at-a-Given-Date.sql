# Write your MySQL query statement below
SELECT
    DISTINCT t.product_id,
    COALESCE(p.price, 10) AS price
FROM
    (SELECT DISTINCT product_id FROM products) t
    LEFT JOIN 
    (SELECT 
        product_id,
        FIRST_VALUE(new_price) OVER(PARTITION by product_id ORDER BY change_date DESC) AS price
    FROM products
    WHERE change_date <= '2019-08-16') p 
    using (product_id);