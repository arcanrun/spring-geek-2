    alter table products
       drop foreign key brand_id;
GO

    alter table products
       drop foreign key category_id;
GO

    drop table brands;
GO

    drop table categories;
GO

    drop table products;
GO
