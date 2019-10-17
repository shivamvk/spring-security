CREATE TABLE role (
  role_id int(11) NOT NULL AUTO_INCREMENT,
  role_name varchar(255) DEFAULT NULL,
  role_description varchar(255) DEFAULT NULL,
  PRIMARY KEY (role_id)
);
INSERT INTO role VALUES (1,'SUPER_USER','This user has ultimate rights for everything');
INSERT INTO role VALUES (2,'ADMIN_USER','This user has admin rights for administrative work');
INSERT INTO role VALUES (3,'SITE_USER','This user has access to site, after login - normal user');

CREATE TABLE user (
  user_id int(11) NOT NULL AUTO_INCREMENT,
  first_name varchar(255) NOT NULL,
  last_name varchar(255) NOT NULL,
  email varchar(255) NOT NULL,
  phone varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  status varchar(255),
  PRIMARY KEY (user_id)
);

CREATE TABLE user_role (
  user_id int(11) NOT NULL,
  role_id int(11) NOT NULL,
  PRIMARY KEY (user_id,role_id),
  KEY FK_user_role (role_id),
  CONSTRAINT FK_user FOREIGN KEY (user_id) REFERENCES user (user_id),
  CONSTRAINT FK_user_role FOREIGN KEY (role_id) REFERENCES role (role_id)
) ;

insert into user (user_id,first_name,last_name,email,phone,password,status) values (7898,'Shivam','Bhasin','shivamvkinbox@gmail.com','8130583124','$2a$10$gmzZkvrGOAVHDEz5dh1tMet3x1i4WZ5nKJvVp20XTIvyvgsFhpNtW','VERIFIED');
insert into user_role (user_id, role_id) values ('7898','1');
insert into user_role (user_id, role_id) values ('7898','2');
insert into user_role (user_id, role_id) values ('7898','3');






