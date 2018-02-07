package org.aita.library.core.dao.impl;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.aita.library.common.db.JDBCUtils;
import org.aita.library.common.db.ResultSetConvert;
import org.aita.library.core.dao.IMemberDao;
import org.aita.library.core.dao.entity.MemberEntity;
import org.aita.library.exception.LibraryManagementMemberException;
import org.aita.library.exception.LibraryManagementMemberPasswordInCorrectException;
import org.aita.library.exception.LibraryManagementSqlException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 万松(Aaron)
 * @since 5.7
 */
@Slf4j
@Data
public class MemberDaoImpl implements IMemberDao {

    @Override
    public MemberEntity findMember(String email, String passwd) {

        MemberEntity member = findMemberByEmail(email);
        if (member == null) {
            throw new LibraryManagementMemberException("用户不存在");
        } else if (!member.getPassword().equals(passwd)) {
            throw new LibraryManagementMemberPasswordInCorrectException("密码错误");
        }

        return member;
    }


    @Override
    public MemberEntity findMemberByEmail(String email) {

        MemberEntity member = JDBCUtils.getData(String.format("select * from book_manager.member where mail='%s' ", email),
                new ResultSetConvert<MemberEntity>() {
            @Override
            public MemberEntity transfer(ResultSet resultSet) {
                MemberEntity member = new MemberEntity();
                try {
                    member.setName(resultSet.getString("name"));
                    member.setEmail(resultSet.getString("mail"));
                    member.setPassword(resultSet.getString("passwd"));
                    member.setId(resultSet.getLong("id"));
                } catch (SQLException e) {
                    log.error("", e);
                }
                return member;
            }
        });

        return member;
    }


    @Override
    public MemberEntity save(String email, String passwd) {

        MemberEntity member = findMemberByEmail(email);

        if (member == null) {
            try {
                PreparedStatement pstmt = JDBCUtils.getPreparedStatement("insert into member (mail,passwd) values (?,?)");
                //创建对象
                member = new MemberEntity();
                member.setEmail(email);
                member.setPassword(passwd);
                pstmt.setString(1, member.getEmail());
                pstmt.setString(2, member.getPassword());
                pstmt.execute();

            } catch (SQLException e) {
                throw new LibraryManagementSqlException(e);
            }
        }else{
            throw new LibraryManagementMemberException(email+"用户已经存在");
        }

        return findMember(email,passwd);
    }

    @Override
    public MemberEntity findMemberById(Long memberId) {
        return null;
    }

    @Override
    public MemberEntity findMemberByTeamId(Long teamId) {
        return null;
    }
}
