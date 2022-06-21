## commands

``` sh
mysql -h 127.0.0.1 --port 3306 -uroot -pmysql

CREATE DATABASE book_manager;
use book_manager;

CREATE TABLE user (
    id bigint NOT NULL,
    email varchar(256) UNIQUE NOT NULL,
    password varchar(128) NOT NULL,
    name varchar(32) NOT NULL,
    role_type enum('ADMIN', 'USER'),
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE book (
    id bigint NOT NULL,
    title varchar(128) NOT NULL,
    author varchar(32) NOT NULL,
    release_date date NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE rental (
    book_id bigint NOT NULL,
    user_id bigint NOT NULL,
    rental_datetime datetime NOT NULL,
    return_deadline datetime NOT NULL,
    PRIMARY KEY (book_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO book values
(100, 'Kotlin入門', 'ことりん太郎', '1999-11-30'),
(101, 'Java入門', 'じゃヴァ太郎', '1909-03-30');

INSERT INTO user values
(1, 'admin@test.com', '$s$10$.zeaifejaojzdcizlejfa31/fasjelfjiajefa', '管理者', 'ADMIN'),
(2, 'user@test.com', '$s$10$z.zeaifejaojzdcizlejfa/fa3942081iajefa', '管理者', 'ADMIN');

```

### Spring Security

- Spring プロジェクトの１つ
- Web アプリケーションで認証、認可などセキュリティ関連の機能を実現するためのフレームワーク

### memo

- Repository はデザインパターンの一種
    - データベース操作のロジックを抽象化する
- 今回 DB 層しか Interface に依存させてない
    - 本来は controller, service, もやるべき？
    - Android 前やったときは Interface にしてなかった
    - あんまり変更が入らないところだから？

### curl

``` sh
curl -i -c cookie.txt -H 'Content-Type:application/x-www-form-urlencoded' -X POST -d 'email=use' -d 'pass=ho' http://localhost:8080/login

curl -i -b cookie.txt http://localhost:8080/book/list
```

