package com.icourt.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Zhangtengfei
 * @date 2017-8-23
 * 用户实体类
 */
@Entity
@Table(name="user")
public class UserDO {
    /**
     * 用户Id
     */
    @Id
    @GeneratedValue
    private Integer id;
    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户年龄
     */
    private Integer age;

    public UserDO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserDO{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }
}
