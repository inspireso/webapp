 create table res_number (
        id varchar(32) not null unique,
        created_by varchar(50),
        created_date timestamp,
        last_modified_by varchar(50),
        last_modified_date timestamp,
        version bigint,
        name varchar(255),
        code varchar(255),
        current_value bigint not null,
        increment_by bigint not null,
        max_value bigint not null,
        min_value bigint not null,
        primary key (id)
    );