DROP TABLE xUser;

CREATE TABLE xUser
(

    UserId INT NOT NULL GENERATED ALWAYS AS IDENTITY,
    fName VARCHAR(25) NOT NULL, 
    lName VARCHAR(50) NOT NULL,
    age int NOT NULL,    

    CONSTRAINT pk_UserId PRIMARY KEY (UserId)

)

CREATE TABLE HeartRate
(

    UserId int,
    hrDate date,
    heartRate int

)
