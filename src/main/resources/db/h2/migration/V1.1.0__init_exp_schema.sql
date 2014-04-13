 create table exp_pricelist (
        id varchar(32) not null unique,
        created_by varchar(50),
        created_date timestamp,
        last_modified_by varchar(50),
        last_modified_date timestamp,
        version bigint,
        name varchar(255),
        exp_product_code varchar(255),
        exp_product_name varchar(255),
        currency varchar(255),
        order_by integer not null,
        price numeric,
        primary key (id)
    );

    create table exp_product (
        id varchar(32) not null unique,
        created_by varchar(50),
        created_date timestamp,
        last_modified_by varchar(50),
        last_modified_date timestamp,
        version bigint,
        name varchar(255),
        code varchar(255),
        full_name varchar(255),
        order_by integer not null,
        support bit not null,
        primary key (id)
    );