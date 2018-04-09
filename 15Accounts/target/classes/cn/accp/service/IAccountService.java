package cn.accp.service;

import cn.accp.entity.Account;

/**
 * @Auther: Xiao Yu
 * @Date: Created in 14:25 2018/3/11
 */
public interface IAccountService {

    public Account selectAccountOne(Account account);
    public int updateAccountup(Account account);
    public int updateAccountdown(Account account);
}
