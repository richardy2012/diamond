--
-- Current Database: `repository`
--
DROP DATABASE IF EXISTS `repository`;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `repository` /*!40100 DEFAULT CHARACTER SET utf8 */;

GRANT ALL PRIVILEGES ON repository.* TO 'repository'@'localhost' IDENTIFIED BY 'repository';

USE `repository`;

CREATE TABLE data (
	namespace VARCHAR(128) NOT NULL,
	`key` VARCHAR(128) NOT NULL,
	`sub_key` VARCHAR(128) NOT NULL,
	`value` VARCHAR(4096),
	`sequence` BIGINT(22) NOT NULL,
	create_time DATETIME NOT NULL,
	last_modified_time DATETIME NOT NULL,
	PRIMARY KEY(namespace, `key`, sub_key)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8 COLLATE = utf8_bin;