create schema if not exists eurderschema;

set search_path to eurderschema;

create table address
(
    ID uuid,
    STREET_NAME text,
    STREET_NUMBER text,
    POSTAL_CODE text,
    CITY_NAME text,
    COUNTRY text,
    constraint PK_ADDRESS primary key (id)
);

create table customer
(
    ID uuid:text,
    FIRST_NAME text,
    LAST_NAME text,
    EMAIL text,
    FK_ADDRESS_ID uuid,
    PHONE_NUMBER text,
    constraint FK_CUSTOMER_ADDRESS foreign key(FK_ADDRESS_ID) references ADDRESS (ID),
    constraint PK_CUSTOMER primary key (ID)
);

-- POPULATE TABLE ADDRESS
insert into ADDRESS(id, street_name, street_number, postal_code, city_name, country)
values ('832c0ca1-341a-4feb-9527-dc9c26348dc3','Rue de Merino','178','36895','Malaga','Spain');
insert into ADDRESS(id, street_name, street_number, postal_code, city_name, country)
values ('832c0ca1-341a-4feb-9527-dc9c26348dc4','Cure driveway','100','SL4785','London','UK');

-- POPULATE TABLE CUSTOMER
insert into CUSTOMER(id, first_name, last_name, email, fk_address_id, phone_number)
values ('832c0ca1-341a-4feb-9527-dc9c26348dc5','Robert', 'Smith', 'robertsmith@thecure.com',(select ID from ADDRESS where COUNTRY='UK'),'0044123');
insert into CUSTOMER(id, first_name, last_name, email, fk_address_id, phone_number)
values ('832c0ca1-341a-4feb-9527-dc9c26348dc9','Don', 'Quichotte', 'don@spagna.com',(select ID from ADDRESS where COUNTRY='Spain'),'0034968574');


-- EXECUTE THE CODE BELOW TO DROP ALL TABLES
-- drop table CUSTOMER;
-- drop table ADDRESS;

