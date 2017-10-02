CREATE DATABASE 'hclpoc' /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE 'user' (
  'user_id' int(10) NOT NULL AUTO_INCREMENT,
  'first_name' varchar(50) DEFAULT NULL,
  'last_name' varchar(50) DEFAULT NULL,
  'dob' date DEFAULT NULL,
  'address' varchar(500) DEFAULT NULL,
  'sex' varchar(10) DEFAULT NULL,
  'email' varchar(100) DEFAULT NULL,
  PRIMARY KEY ('user_id'),
  UNIQUE KEY 'user_id_UNIQUE' ('user_id')
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;
