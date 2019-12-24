package com.fangxp.mq.dto;

import java.io.Serializable;

/**
 * Created by michael on 2017/3/16.
 */
public class UserDTO implements Serializable{

    private static final long serialVersionUID = -4122647914333221041L;
    private Integer id;

    private String name;

    public UserDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public UserDTO() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
