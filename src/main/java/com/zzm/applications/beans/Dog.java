package com.zzm.applications.beans;

/**
 * <b>Description</b>  Dog
 *
 * @Author Zhenzhen
 * @Since 2020-06-20 周六 13:42
 * @Info Dog
 */

public class Dog {


    private String nickname;
    private Integer petId;

    public Dog() {
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "nickname='" + nickname + '\'' +
                ", petId=" + petId +
                '}';
    }
}
