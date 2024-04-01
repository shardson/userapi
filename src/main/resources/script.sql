CREATE TABLE 'db_course'.'users' (
 'id' INT NOT NULL AUTO_INCREMENT,
 'userId' VARCHAR(255) NULL,
 'firstName' VARCHAR(255) NULL,
 'lastName' VARCHAR(255) NULL,
 'email' VARCHAR(255) NULL,
 'encryptedPassword' VARCHAR(255) NULL,
 'emailVerificationToken' VARCHAR(255) NULL,
 'eMailVerificationStatus' VARCHAR(255) NULL,
 PRIMARY KEY ('id'));