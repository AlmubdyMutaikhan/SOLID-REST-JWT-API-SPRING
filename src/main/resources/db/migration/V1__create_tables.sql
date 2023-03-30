CREATE TABLE Account(
                        ACCOUNT_TYPE NVARCHAR(10) NOT NULL,
                        ID NVARCHAR(200) PRIMARY KEY NOT NULL,
                        CLIENT_ID NVARCHAR(10) NOT NULL,
                        BALANCE DOUBLE NOT NULL,
                        WITHDRAW_ALLOWED BOOLEAN NOT NULL
);

CREATE TABLE Client(
                        ID int auto_increment primary key NOT NULL,
                        USERNAME NVARCHAR(100) NOT NULL,
                        PWD NVARCHAR(100) NOT NULL
);

INSERT INTO Client(USERNAME, PWD) VALUES ('ali','stanford');

INSERT INTO Account VALUES ('SAVING', '0001001', '10', 150.0, TRUE);
INSERT INTO Account VALUES ('SAVING', '0001002', '18', 10.0, TRUE);
INSERT INTO Account VALUES ('SAVING', '0001003', '11', 194.0, TRUE);