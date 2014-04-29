DROP TABLE HeartRate;
DROP TABLE Distance;
DROP TABLE Speed;
DROP TABLE Calories;
DROP TABLE xUser;

CREATE TABLE xUser
(

    UserId INT NOT NULL GENERATED ALWAYS AS IDENTITY,
    fName VARCHAR(25) NOT NULL, 
    lName VARCHAR(50) NOT NULL,
    age int NOT NULL,    

    CONSTRAINT pk_User PRIMARY KEY (UserId)

);

CREATE TABLE HeartRate
(

    UserId INT,
    hrDate DATE,
    hrTime TIME,
    heartRate INT,    
    maxHeartRate INT,
    targetHeartRate INT,
    
    CONSTRAINT pk_HeartRate PRIMARY KEY (UserId, hrDate, hrTime),

    FOREIGN KEY (UserId) REFERENCES xUser(UserId)

);

CREATE TABLE Distance
(

    UserId INT,
    distanceDate DATE,
    distanceTime TIME,
    distance INT,
    
    CONSTRAINT pk_Distance PRIMARY KEY (UserId, distanceDate, distanceTime),

    FOREIGN KEY (UserId) REFERENCES xUser(UserId)

);

CREATE TABLE Speed
(

    UserId INT,
    speedDate DATE,
    speedTime TIME,
    distance INT,
    
    CONSTRAINT pk_Speed PRIMARY KEY (UserId, speedDate, speedTime),

    FOREIGN KEY (UserId) REFERENCES xUser(UserId)

);

CREATE TABLE Calories
(

    UserId INT,
    caloriesDate DATE,
    caloriesTime TIME,
    caloriesBurned INT,
    
    CONSTRAINT pk_Calories PRIMARY KEY (UserId, caloriesDate, caloriestime),

    FOREIGN KEY (UserId) REFERENCES xUser(UserId)

)