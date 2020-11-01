    create table roles (
        id bigserial PRIMARY KEY not null,
        name varchar(255) not null
    );
GO
    create table users (
        id bigserial PRIMARY KEY not null,
        age integer,
        email varchar(255),
        name varchar(32) not null,
        password varchar(128) not null
    );
GO

    create table users_roles (
        user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    );
GO

    alter table roles
       add constraint UK_ofx66keruapi6vyqpv6f2or37 unique (name);
GO

    alter table users_roles
       add constraint FKj6m8fwv7oqv74fcehir1a9ffy
       foreign key (role_id)
       references roles (id);
GO

    alter table users_roles
       add constraint FK2o0jvgh89lemvvo17cbqvdxaa
       foreign key (user_id)
       references users (id);
GO
