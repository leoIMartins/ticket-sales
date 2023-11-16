create table tickets(

    id bigint not null auto_increment,
    name varchar(100) not null,
    price bigint not null,
    ticket_type varchar(100) not null,
    active tinyint not null,

    primary key(id)

);