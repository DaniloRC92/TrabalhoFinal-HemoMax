create table users(

    id text primary key unique not null,
    login text not null unique,
    senha text not null,
    role text not null

);