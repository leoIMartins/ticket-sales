create table customers(

    id bigint not null auto_increment,
    name varchar(100) not null,
    document_id varchar(100) not null unique,
    email varchar(100) not null unique,
    phone varchar(11) not null unique,
    country varchar(100) not null,
    city varchar(100) not null,
    state varchar(100) not null,
    postal_code varchar(9) not null,
    address varchar(100),
    number varchar(20) not null,

    primary key(id)

);