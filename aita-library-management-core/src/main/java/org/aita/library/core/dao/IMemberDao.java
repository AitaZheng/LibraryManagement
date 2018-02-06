package org.aita.library.core.dao;

import org.aita.library.core.dao.entity.MemberEntity;

/**
 * @author 万松(Aaron)
 * @since 5.7
 */
public interface IMemberDao {
    /**
     * 查询并创建人员
     * @param email
     * @param password
     * @return
     */
    MemberEntity findMember(String email, String password);

    MemberEntity findMemberByEmail(String email);

    MemberEntity save(String email, String passwd);

    /**
     * 查询人员
     * @param memberId
     * @return
     */
    MemberEntity findMemberById(Long memberId);

    /**
     * 查询组内人员
     * @param teamId
     * @return
     */
    MemberEntity findMemberByTeamId(Long teamId);
}
