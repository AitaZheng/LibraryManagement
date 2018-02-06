package org.aita.library.core.dao.impl;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.aita.library.core.dao.IMemberDao;
import org.aita.library.core.dao.entity.MemberEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 万松(Aaron)
 * @since 5.7
 */
@Slf4j
@Data
public class MemberDaoImpl extends BaseDao implements IMemberDao {

    @Override
    public MemberEntity findAndCreateMemeber(String email, String passwd) {
        PreparedStatement pstmt = getPreparedStatement("select * from book_manager.member where mail=? and passwd=?");
        MemberEntity member = null;
        try {
            pstmt.setString(1, email);
            pstmt.setString(2, passwd);
            ResultSet rst = pstmt.executeQuery();
            if (rst.next()) {
                member = new MemberEntity();
                member.setName(rst.getString("name"));
                member.setEmail(rst.getString("mail"));
                member.setPassword(rst.getString("passwd"));
                member.setId(rst.getLong("id"));
            }else{
                pstmt = getPreparedStatement("insert into member (mail,passwd) values (?,?)");
                //创建对象
                member = new MemberEntity();
                member.setEmail(email);
                member.setPassword(passwd);
                pstmt.setString(1,member.getEmail());
                pstmt.setString(2,member.getPassword());
                pstmt.execute();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return member;
    }

    @Override
    public MemberEntity findMemeberById(Long memberId) {
        return null;
    }

    @Override
    public MemberEntity findMemeberByTeamId(Long teamId) {
        return null;
    }
}
