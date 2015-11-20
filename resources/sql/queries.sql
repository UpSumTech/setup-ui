-- name: create-node!
-- creates a new node record
INSERT INTO nodes
(name, description)
VALUES (:name, :description)

-- name: update-node!
-- update an existing node record
UPDATE nodes
SET name = :name, description = :description
WHERE id = :id

-- name: get-node
-- retrieve a node given the id
SELECT * FROM nodes
WHERE id = :id

-- name: delete-node!
-- delete a node given the id
DELETE FROM nodes
WHERE id = :id

-- name: get-nodes
-- selects all available nodes
SELECT * FROM nodes
