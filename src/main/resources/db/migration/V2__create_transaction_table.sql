CREATE TABLE Transaction(
                        ID int primary key auto_increment not null ,
                        DATE NVARCHAR(200) NOT NULL,
                        DESCRIPTION NVARCHAR(200) NOT NULL,
                        ACCOUNT_ID NVARCHAR(200) NOT NULL,
                        FOREIGN KEY (ACCOUNT_ID) references Account(ID)
);

