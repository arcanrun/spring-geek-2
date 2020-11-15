    create table roles (
        id bigserial PRIMARY KEY,
        name varchar(255) NOT NULL
    );
GO
    create table users (
        id bigserial PRIMARY KEY,
        age integer,
        email varchar(255),
        name varchar(32) NOT NULL,
        password varchar(128) NOT NULL
    );
GO

    create table users_roles (
        user_id bigint,
        role_id bigint,
        primary key (user_id, role_id),
        CONSTRAINT user_id_fk FOREIGN KEY (user_id) REFERENCES users(id),
        CONSTRAINT role_id_fk FOREIGN KEY (role_id) REFERENCES roles(id)
    );

