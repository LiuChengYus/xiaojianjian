package cn.accp.entity;

import java.io.Serializable;

/**
 * @Auther: Xiao Yu
 * @Date: Created in 14:17 2018/3/11
 */
public class Account implements Serializable{
    private String number;
    private String pwd;
    private Integer status;
    private Integer balnace;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getBalnace() {
        return balnace;
    }

    public void setBalnace(Integer balnace) {
        this.balnace = balnace;
    }
}
