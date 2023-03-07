create table if not exists Soup_Order (
id identity,
delivery_Name varchar(50) not null,
delivery_Street varchar(50) not null,
delivery_State varchar(50) not null,
delivery_Zip varchar(10) not null,
cc_number varchar(16) not null,
cc_expiration varchar(5) not null,
cc_cvv varchar(3) not null,
placed_at timestamp not null);

create table if not exists Soup (
id identity,
name varchar(50) not null,
soup_order bigint not null,
soup_order_key bigint not null,
created_at timestamp not null);

create table if not exists Ingredient_Ref (
ingredient varchar(2) not null,
soup bigint not null,
soup_key bigint not null);

create table if not exists Ingredient (
id varchar(2) not null unique,
name varchar(25) not null,
type varchar(10) not null);

create table if not exists USER_TABLE (
id identity,
username varchar(25) not null unique,
password varchar(60) not null,
fullname varchar(25),
street varchar(25),
city varchar(25),
state varchar(25),
zip varchar(25),
phonenumber varchar(25),
primary key (id)
);


alter table Soup
	add foreign key (soup_order) references Soup_Order(id);
alter table Ingredient_Ref
	add foreign key (ingredient) references Ingredient(id);
