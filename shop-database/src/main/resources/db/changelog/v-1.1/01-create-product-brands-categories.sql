create table categories
(
    id   bigserial PRIMARY KEY,
    name varchar(255) NOT NULL
);
GO

create table brands
(
    id      bigserial PRIMARY KEY,
    name    varchar(255) NOT NULL,
    country varchar(255)
);
GO

create table products
(
    id          bigserial PRIMARY KEY,
    name        varchar(255)  NOT NULL,
    price       decimal(5, 2) NOT NULL,
    brand_id    bigint        NOT NULL,
    category_id bigint        NOT NULL,
    CONSTRAINT brand_id_fk FOREIGN KEY (brand_id) REFERENCES brands (id),
    CONSTRAINT category_id_fk FOREIGN KEY (category_id) REFERENCES categories (id)
);

