CREATE TABLE Client(
                       USERNAME NVARCHAR(100) primary key NOT NULL,
                       PWD NVARCHAR(100) NOT NULL
);

CREATE TABLE Account(
                        ACCOUNT_TYPE NVARCHAR(10) NOT NULL,
                        ID NVARCHAR(200) PRIMARY KEY NOT NULL,
                        CLIENT_ID NVARCHAR(10) NOT NULL,
                        BALANCE DOUBLE NOT NULL,
                        WITHDRAW_ALLOWED BOOLEAN NOT NULL,
                        foreign key (CLIENT_ID) references Client(USERNAME)
);



INSERT INTO Client(USERNAME, PWD) VALUES ('ali','stanford');

INSERT INTO Account VALUES ('SAVING', '0001001', 'ali', 150.0, TRUE);
INSERT INTO Account VALUES ('SAVING', '0001002', 'ali', 10.0, TRUE);
INSERT INTO Account VALUES ('SAVING', '0001003', 'ali', 194.0, TRUE);