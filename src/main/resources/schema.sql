CREATE TABLE CUSTOMER
(
    ID         UUID PRIMARY KEY,
    FIRST_NAME VARCHAR(50) NOT NULL,
    LAST_NAME  VARCHAR(50) NOT NULL
);

CREATE TABLE ITEMS
(
    ID          UUID PRIMARY KEY,
    NAME        VARCHAR(100),
    DESCRIPTION VARCHAR(100),
    PRICE       DOUBLE
);

CREATE TABLE ORDERS
(
    ID          UUID PRIMARY KEY,
    CUSTOMER_ID UUID REFERENCES CUSTOMER
);



CREATE TABLE ORDER_ITEM
(
    ID       INTEGER,
    ITEM_ID  UUID REFERENCES ITEMS,
    ORDER_ID UUID REFERENCES ORDERS
);