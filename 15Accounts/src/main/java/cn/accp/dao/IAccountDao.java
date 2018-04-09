package cn.accp.dao;

import cn.accp.entity.Account;

/**
 * @Auther: Xiao Yu
 * @Date: Created in 14:20 2018/3/11
 */
public interface IAccountDao   {

    public Account selectAccountOne(Account account);
    public int updateAccountup(Account account);
    public int updateAccountdown(Account account);
}
