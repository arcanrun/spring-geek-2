    create table products (
        id bigint not null auto_increment,
        name varchar(255) not null,
        price decimal(5,2) not null,
        brand_id int not null,
        category_id int not null,
        primary key (id)
    ) engine=InnoDB;
GO

    create table categories (
        id bigint not null auto_increment,
        name varchar(255)  not null,
        primary key (id)
    ) engine=InnoDB;
GO

    create table brands (
        id bigint not null auto_increment,
        name varchar(255) not null,
        country varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;
GO

    alter table products
        add foreign key (brand_id)
                references brands (id);
GO

    alter table products
        add foreign key (category_id)
            references categories (id);
GO
