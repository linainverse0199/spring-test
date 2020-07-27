create table if not exists USER (
    id identity,
    name varchar (25) not null,
    birthday timestamp not null
);
create table if not exists MARMALADE (
    id identity,
    taste varchar(25) not null,
    shape varchar(25)
)
