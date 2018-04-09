package cn.accp.service;

import cn.accp.dao.IAccountDao;
import cn.accp.entity.Account;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Auther: Xiao Yu
 * @Date: Created in 14:26 2018/3/11
 */
@Service("iAccountService")
public class AccountServiceImpl implements IAccountService {
    @Resource(name = "IAccountDao")
    private IAccountDao accountDao;
    public Account selectAccountOne(Account account) {
        return accountDao.selectAccountOne(account);
    }

    public int updateAccountup(Account account) {
        return accountDao.updateAccountup(account);
    }

    public int updateAccountdown(Account account) {
        return accountDao.updateAccountdown(account);
    }
}
