  create table pay_account (
        id varchar(32) not null unique,
        created_by varchar(50),
        created_date timestamp,
        last_modified_by varchar(50),
        last_modified_date timestamp,
        version bigint,
        amount_available numeric,
        owner varchar(255),
        password varchar(255),
        primary key (id)
    );

    create table pay_callback_log (
        id varchar(32) not null unique,
        created_by varchar(50),
        created_date timestamp,
        last_modified_by varchar(50),
        last_modified_date timestamp,
        version bigint,
        result varchar(255),
        status integer not null,
        transaction_id varchar(255),
        primary key (id)
    );

    create table pay_receive_log (
        id varchar(32) not null unique,
        created_by varchar(50),
        created_date timestamp,
        last_modified_by varchar(50),
        last_modified_date timestamp,
        version bigint,
        header varchar(255),
        parameter varchar(255),
        transaction_id varchar(255),
        primary key (id)
    );

    create table pay_transaction (
        id varchar(32) not null unique,
        created_by varchar(50),
        created_date timestamp,
        last_modified_by varchar(50),
        last_modified_date timestamp,
        version bigint,
        amount numeric,
        bank_name varchar(255),
        business_ref varchar(255),
        callback_url varchar(255),
        callback_status integer not null,
        currency varchar(255),
        mid varchar(255),
        payment_ref varchar(255),
        receive_string varchar(255),
        remark varchar(255),
        status integer not null,
        transaction_id varchar(255),
        transaction_type integer not null,
        primary key (id)
    );