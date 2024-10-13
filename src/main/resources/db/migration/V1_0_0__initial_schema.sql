create table if not exists products (
    id serial primary key,
    name varchar not null,
    description varchar not null,
    image varchar,
    price numeric,
    stock integer,
    type varchar
);

CREATE table if not exists order_lines (
    id serial primary key,
    quantity numeric,
    product_id integer not null,
    constraint fk_product foreign key (product_id) references products(id)
);

ALTER SEQUENCE products_id_seq INCREMENT BY 50;
ALTER SEQUENCE order_lines_id_seq INCREMENT BY 50;
