SELECT
	items.id AS id,
	items.name AS name,
	items.price,
	details.quantity,
	items.price * details.quantity AS subtotal,
	orders.customer_id AS customer_id
FROM order_details details
JOIN orders ON details.order_id = orders.id
AND
JOIN items ON details.item_id = items.id
