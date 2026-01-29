use bangtandb;

# USER & BALANACE
create table Wallet (
    ID int primary key auto_increment,
    Username varchar(50) unique,
    Balance double
);

# MONEY MOVEMENT HISTORY
create table Transaction (
    ID int primary key auto_increment,
    Wallet_ID int,
    Type varchar(20),
    Amount double,
    Total_Amount double,
    Date timestamp default current_timestamp,
    foreign key (Wallet_ID) references Wallet(ID)
);

select * from Transaction;
select * from Wallet;
