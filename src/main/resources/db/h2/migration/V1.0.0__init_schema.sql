
    create table aut_account (
        id varchar(32) not null unique,
        created_by varchar(50),
        created_date timestamp,
        last_modified_by varchar(50),
        last_modified_date timestamp,
        version bigint,
        org_user_code varchar(255),
        password varchar(255),
        temporary_password varchar(255),
        primary key (id)
    );

    create table aut_function (
        id varchar(32) not null unique,
        created_by varchar(50),
        created_date timestamp,
        last_modified_by varchar(50),
        last_modified_date timestamp,
        version bigint,
        name varchar(255),
        description varchar(255),
        group_name varchar(255),
        order_by integer not null,
        type integer not null,
        url varchar(255),
        primary key (id)
    );

    create table aut_function_group_ref (
        aut_function_id varchar(32) not null,
        org_group_id varchar(32) not null,
        primary key (aut_function_id, org_group_id)
    );

    create table org_group (
        id varchar(32) not null unique,
        created_by varchar(50),
        created_date timestamp,
        last_modified_by varchar(50),
        last_modified_date timestamp,
        version bigint,
        name varchar(255),
        code varchar(255),
        leader_id varchar(255),
        order_by integer not null,
        parent varchar(255),
        system bit not null,
        primary key (id)
    );

    create table org_user (
        type varchar(128) not null,
        id varchar(32) not null unique,
        created_by varchar(50),
        created_date timestamp,
        last_modified_by varchar(50),
        last_modified_date timestamp,
        version bigint,
        name varchar(255),
        code varchar(255),
        company varchar(255),
        email varchar(255),
        sex integer not null,
        status integer not null,
        tel varchar(255),
        primary key (id)
    );

    create table org_user_defaults (
        id varchar(32) not null unique,
        created_by varchar(50),
        created_date timestamp,
        last_modified_by varchar(50),
        last_modified_date timestamp,
        version bigint,
        org_user_code varchar(255),
        name varchar(255),
        value varchar(255),
        primary key (id)
    );

    create table org_user_group_ref (
        org_user_id varchar(32) not null,
        org_group_id varchar(32) not null,
        primary key (org_user_id, org_group_id)
    );

    create table res_filter (
        id varchar(32) not null unique,
        created_by varchar(50),
        created_date timestamp,
        last_modified_by varchar(50),
        last_modified_date timestamp,
        version bigint,
        name varchar(255),
        actived bit not null,
        as_default bit not null,
        filter varchar(255),
        group_name varchar(255),
        order_by integer not null,
        page_name varchar(255),
        shared bit not null,
        system bit not null,
        primary key (id)
    );

    alter table aut_function_group_ref 
        add constraint FKA9D75B0B18399291 
        foreign key (org_group_id) 
        references org_group;

    alter table aut_function_group_ref 
        add constraint FKA9D75B0B4A6EF28C 
        foreign key (aut_function_id) 
        references aut_function;

    alter table org_user_group_ref 
        add constraint FK460B061A4162B1C3 
        foreign key (org_user_id) 
        references org_user;

    alter table org_user_group_ref 
        add constraint FK460B061A18399291 
        foreign key (org_group_id) 
        references org_group;
