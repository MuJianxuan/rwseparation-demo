-- 读写分离
CREATE TABLE `t_user` (
  `id` bigint(20) DEFAULT NULL,
  `nickname` varchar(200) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `birthday` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 分库分表 and 读写分离
CREATE TABLE `t_user0` (
  `id` bigint(20) DEFAULT NULL,
  `nickname` varchar(200) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `birthday` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_user1` (
  `id` bigint(20) DEFAULT NULL,
  `nickname` varchar(200) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `birthday` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;