package org.aita.library.core.dao.entity;

/**
 * @author 万松(Aaron)
 * @since 5.7
 */
public class MemberEntity {
    private Long id;
    private String email;
    private String name;
    private String password;
    private Long teamId;
    private Long createTime;
    private Long modifyTime;

    public MemberEntity() {
    }

    public MemberEntity(Long id, String email, String name, String password, Long teamId, Long createTime, Long modifyTime) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
        this.teamId = teamId;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Long modifyTime) {
        this.modifyTime = modifyTime;
    }
}
