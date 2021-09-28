CREATE TABLE channel_blacklists
(
    blacklist_id BINARY(16) PRIMARY KEY,
    channel_id   INT         NOT NULL,
    channel_name VARCHAR(50) NOT NULL,
    created_at   DATETIME(6) NOT NULL
);

CREATE TABLE category_blacklists
(
    blacklist_id BINARY(16) PRIMARY KEY,
    channel_id   INT         NOT NULL,
    channel_name VARCHAR(50) NOT NULL,
    created_at   DATETIME(6) NOT NULL
)
