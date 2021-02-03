create table demo(
`id` int(11) not null auto_increment COMMENT '主键',
`name` varchar(32) default '' COMMENT 'name',
`create_date` timestamp default current_timestamp COMMENT '创建日期',
primary key (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=COMPACT COMMENT='demo';
