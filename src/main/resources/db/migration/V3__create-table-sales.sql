create table sales(

    id bigint not null auto_increment,
    ticket_id bigint not null,
    customer_id bigint not null,

    primary key(id)

);