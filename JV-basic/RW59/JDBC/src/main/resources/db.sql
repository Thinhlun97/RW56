use jdbc;

drop table if exists Car;
create table Car (
                     CarID				int auto_increment primary key,
                     Maker				enum('HONDA', 'TOYOTA', 'NISSAN') not null,
                     Model				varchar(50) not null,
                     Year				datetime not null,
                     color				varchar(50) not null,
                     Note				varchar(500) not null
);

-- Insert table Car
insert into Car (Maker,			Model,			Year,					color,			Note)
values			('HONDA',		'HONDA1',		'2018-11-22',			'BLACK',		'a123'),
                  ('TOYOTA',		'TOYOTA1',		'2017-10-12',			'WHITE',		'abc1'),
                  ('NISSAN',		'NISSAN1',		'2019-01-20',			'BLUE',			'1234');


DROP PROCEDURE IF EXISTS demoStore ;
DELIMITER $$
CREATE PROCEDURE demoStore ()
BEGIN
        -- Đếm số lượng bản ghi cần xoá
select * from Car where year(year) = year(now());
END $$
DELIMITER ;
call demoStore();use jdbc;

drop table if exists Car;
create table Car (
                     CarID				int auto_increment primary key,
                     Maker				enum('HONDA', 'TOYOTA', 'NISSAN') not null,
                     Model				varchar(50) not null,
                     Year				datetime not null,
                     color				varchar(50) not null,
                     Note				varchar(500) not null
);

-- Insert table Car
insert into Car (Maker,			Model,			Year,					color,			Note)
values			('HONDA',		'HONDA1',		'2018-11-22',			'BLACK',		'a123'),
                  ('TOYOTA',		'TOYOTA1',		'2017-10-12',			'WHITE',		'abc1'),
                  ('NISSAN',		'NISSAN1',		'2019-01-20',			'BLUE',			'1234');


DROP PROCEDURE IF EXISTS demoStore ;
DELIMITER $$
CREATE PROCEDURE demoStore ()
BEGIN
        -- Đếm số lượng bản ghi cần xoá
select * from Car where year(year) = year(now());
END $$
DELIMITER ;
call demoStore();