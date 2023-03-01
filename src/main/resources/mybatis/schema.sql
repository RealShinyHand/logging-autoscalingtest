DROP TABLE IF EXISTS tb_memo;

create table tb_memo(
	id  Integer primary key not null AUTO_INCREMENT,
    memo varchar(200),
    writerIP char(39),
    serverIP char(39)
);