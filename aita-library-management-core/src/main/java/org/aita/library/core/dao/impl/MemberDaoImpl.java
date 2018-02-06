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
    public MemberEntity findAndCreateMemeber(String email, String password) {
        PreparedStatement pstmt = getPreparedStatement("select * from member where email=?,paasword=?");
        MemberEntity member = null;
        try {
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            ResultSet rst = pstmt.executeQuery();
            if (rst.next()) {
                member = new MemberEntity();
                member.setName(rst.getString("name"));
                member.setEmail(rst.getString("email"));
                member.setPassword(rst.getString("password"));
                member.setId(rst.getLong("id"));
            }
            if (member == null) {
                //创建对象
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
