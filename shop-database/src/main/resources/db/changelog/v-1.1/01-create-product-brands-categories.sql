    create table products (
        id bigserial not null primary key,
        name varchar(255) not null,
        price decimal(5,2) not null,
        brand_id int not null,
        category_id int not null);
GO

    create table categories (
        id bigserial not null primary key,
        name varchar(255)  not null
    );
GO

    create table brands (
        id bigserial not null primary key,
        name varchar(255) not null,
        country varchar(255));
GO

    alter table products
        add foreign key (brand_id)
                references brands (id);
GO

    alter table products
        add foreign key (category_id)
            references categories (id);
GO
