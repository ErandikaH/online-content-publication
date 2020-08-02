CREATE TABLE IF NOT EXISTS user(
  id bigint(20) NOT NULL AUTO_INCREMENT,
  country_of_origin varchar(255) DEFAULT NULL,
  description varchar(255) DEFAULT NULL,
  email varchar(255) DEFAULT NULL,
  fire_base_registration varchar(255) DEFAULT NULL,
  full_name varchar(255) DEFAULT NULL,
  password varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS subscription (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  category_id int(5) DEFAULT NULL,
  user_id bigint(20) DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS publication (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  category int(5) DEFAULT NULL,
  details varchar(40000) DEFAULT NULL,
  published_date date NOT NULL,
  status int(5) DEFAULT NULL,
  summary varchar(255) DEFAULT NULL,
  title varchar(255) DEFAULT NULL,
  user_id bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES user(id)
);

CREATE TABLE IF NOT EXISTS comment (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  comments varchar(255) DEFAULT NULL,
  publication_id bigint(20) DEFAULT NULL,
  user_id bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (publication_id) REFERENCES publication(id),
  FOREIGN KEY (user_id) REFERENCES user(id)
);

CREATE TABLE IF NOT EXISTS notification_message (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  category_id int(5) DEFAULT NULL,
  message varchar(255) DEFAULT NULL,
  notification_status int(5) DEFAULT NULL,
  publication_id bigint(20) DEFAULT NULL,
  publication_status int(5) DEFAULT NULL,
  title varchar(255) DEFAULT NULL,
  user_id bigint(20) DEFAULT NULL,
  PRIMARY KEY (id)
  );
