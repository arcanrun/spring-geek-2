CREATE TABLE pictures_data (
    id bigserial PRIMARY KEY,
    file_name varchar(255),
    data bytea NULL
);
GO

CREATE TABLE pictures (
  id bigserial PRIMARY KEY ,
  content_type varchar(255) NOT NULL,
  name varchar(255) NOT NULL,
  picture_data_id bigint NOT NULL CONSTRAINT picture_data_id_unique UNIQUE,
  CONSTRAINT picture_data_id_fk FOREIGN KEY (picture_data_id) REFERENCES pictures_data (id)
);
GO

CREATE TABLE products_pictures (
  product_id bigint,
  picture_id bigint,
  primary key (product_id, picture_id),
  CONSTRAINT product_id_fk FOREIGN KEY (product_id) REFERENCES products (id),
  CONSTRAINT picture_id_fk FOREIGN KEY (picture_id) REFERENCES pictures (id)
);
GO