--liquibase formatted sql

--changeset fix:order-customer-id-type
-- Fix: order.customer_id was added as BIGSERIAL (bigint) in changelog-0015
-- but the Java entity uses String (VARCHAR). This aligns DB with the entity type,
-- consistent with checkout.customer_id fix in changelog-0016.
ALTER TABLE IF EXISTS "order"
ALTER COLUMN customer_id TYPE VARCHAR(255) USING customer_id::VARCHAR(255);

ALTER TABLE IF EXISTS "order"
ALTER COLUMN customer_id DROP DEFAULT;
