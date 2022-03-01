CREATE DATABASE db;
GO

USE db;
GO

CREATE TABLE auction (
    id          uniqueidentifier PRIMARY KEY,
    name        VARCHAR(255),
    description VARCHAR(255)
);
GO

CREATE TABLE item (
    id                    uniqueidentifier PRIMARY KEY,
    auction_id            uniqueidentifier REFERENCES auction (id),
    name                  VARCHAR(255),
    description           VARCHAR(255),
    start_amount_in_cents INTEGER,
    bid_amount_in_cents   INTEGER,
    start_amount_in_pln   INTEGER,
    bid_amount_in_pln     INTEGER
);
GO