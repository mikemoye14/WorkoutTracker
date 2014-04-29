
DROP TABLE HeartRates;
DROP TABLE Distances;
DROP TABLE Speeds;
DROP TABLE Calories;
DROP TABLE xUsers;

CREATE TABLE xUsers
(

    UserId INT NOT NULL GENERATED ALWAYS AS IDENTITY,
    fName VARCHAR(25) NOT NULL, 
    lName VARCHAR(50) NOT NULL,
    age INT NOT NULL,

    CONSTRAINT pk_Users PRIMARY KEY (UserId)

);

CREATE TABLE HeartRates
(

    UserId INT,
    hrDate DATE,
    hrTime TIME,
    heartRate INT,
    
    CONSTRAINT pk_HeartRates PRIMARY KEY (UserId, hrDate, hrTime),

    FOREIGN KEY (UserId) REFERENCES xUsers(UserId)

);

CREATE TABLE Distances
(

    UserId INT,
    distanceDate DATE,
    distanceTime TIME,
    distance INT,
    
    CONSTRAINT pk_Distances PRIMARY KEY (UserId, distanceDate, distanceTime),

    FOREIGN KEY (UserId) REFERENCES xUsers(UserId)

);

CREATE TABLE Speeds
(

    UserId INT,
    speedDate DATE,
    speedTime TIME,
    speed INT,
    
    CONSTRAINT pk_Speeds PRIMARY KEY (UserId, speedDate, speedTime),

    FOREIGN KEY (UserId) REFERENCES xUsers(UserId)

);

CREATE TABLE Calories
(

    UserId INT,
    caloriesDate DATE,
    caloriesTime TIME,
    caloriesBurned INT,
    
    CONSTRAINT pk_Calories PRIMARY KEY (UserId, caloriesDate, caloriestime),

    FOREIGN KEY (UserId) REFERENCES xUsers(UserId)

);

/*
INSERT INTO xUsers
(    
    fName,
    lName,
    age
)
VALUES
(
    'Mike',
    'M',
    25
);
*/
/*
INSERT INTO HeartRates
(
    userId,
    hrDate,
    hrTime,
    heartRate

)
VALUES
(
    1,
    '01/29/2014',
    '13:09',
    209

)
*/