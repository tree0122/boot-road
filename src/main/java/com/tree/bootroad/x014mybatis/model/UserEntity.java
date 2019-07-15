package com.tree.bootroad.x014mybatis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * CREATE TABLE IF NOT EXISTS `users`(
 *    `id` INT UNSIGNED AUTO_INCREMENT,
 *    `name` VARCHAR(100),
 *    `nick_name` VARCHAR(40),
 *    PRIMARY KEY ( `id` )
 * )ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    private Long id;
    private String name;
    private String nickName;
}
