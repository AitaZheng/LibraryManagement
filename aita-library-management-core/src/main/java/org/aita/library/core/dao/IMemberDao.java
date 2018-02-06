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
    MemberEntity findAndCreateMemeber(String email, String password);

    /**
     * 查询人员
     * @param memberId
     * @return
     */
    MemberEntity findMemeberById(Long memberId);

    /**
     * 查询组内人员
     * @param teamId
     * @return
     */
    MemberEntity findMemeberByTeamId(Long teamId);
}
