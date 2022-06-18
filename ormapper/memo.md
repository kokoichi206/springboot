### Database setup
``` sh
docker container run --rm -d -e MYSQL_ROOT_PASSWORD=mysql -p 3306:3306 --name mysql mysql

// Docker command is order sensitive ?
// --- Worked ---
docker container run --rm -d --platform linux/x86_64 -e MYSQL_ROOT_PASSWORD=mysql -p 3306:3306 --name mysql mysql
// --- Didn't work ---
docker container run --rm linux/x86_64 -e MYSQL_ROOT_PASSWORD=mysql -p 3306:3306 --name mysql mysql -d --platform

mysql -h 127.0.0.1 --port 3306 -uroot -pmysql

CREATE DATABASE example;
use example;

CREATE TABLE user (
  id int(10) NOT NULL,
  name varchar(16) NOT NULL,
  age int(10) NOT NULL,
  profile varchar(64) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SHOW TABLES;
INSERT INTO user values
  (100, "Ichiro", 30, "hello"),
  (101, "Jiro", 27, "Hi"),
  (102, "Saburo", 22, "pien");

SELECT * FROM user;
```

### MyBatis
Generate mybatis

``` sh
./gradlew mbGenerator
```

- generatorConfig.xml
  - MyBatis Generator を実行する時の設定
- mybatis-config.xml
  - プログラム上で MyBatis を使用する際に必要な設定

