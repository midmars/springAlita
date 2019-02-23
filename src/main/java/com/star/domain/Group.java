package com.star.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;

@Entity
@Data
@Table(name="baseball_group")
public class Group {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;

    /**
     * 名稱
     */
    @Column
    private String name;
    /**
     * 勝場數
     */
    @Column
    private String victory;
    /**
     * 敗場數
     */
    @Column
    private String defeat;
}
