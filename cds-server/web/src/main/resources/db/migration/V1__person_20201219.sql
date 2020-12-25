-- Create table
DROP TABLE IF EXISTS person;
create table person (
    `name` varchar(255) NOT NULL,
    `age` int(32) NULL DEFAULT NULL,
    `number` varchar(255) NULL DEFAULT NULL,
    `gender` int(32) NULL DEFAULT NULL,
    PRIMARY KEY (name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

