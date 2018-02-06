package org.aita.library.core.dao.impl;

import com.sun.tools.javac.util.Assert;
import org.aita.library.core.dao.IMemberDao;
import org.aita.library.core.dao.entity.MemberEntity;
import org.junit.Before;
import org.junit.Test;

/**
 * @author 万松(Aaron)
 * @since 5.7
 */
public class MemberDaoTest {
    private IMemberDao memberDao;
    @Before
    public void setUp(){
        memberDao = new MemberDaoImpl();
    }
    @Test
    public void findAndCreateMemeber(){
        MemberEntity member1 = memberDao.findAndCreateMemeber("aita0908@163.com","12345678");
        MemberEntity member2 = memberDao.findAndCreateMemeber("aita@126.com","12345678");
        Assert.checkNonNull(member1);
        Assert.checkNonNull(member2);
    }
}
