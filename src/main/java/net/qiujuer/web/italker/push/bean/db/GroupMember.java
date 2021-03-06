package net.qiujuer.web.italker.push.bean.db;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_GROUP_MEMBER")
public class GroupMember {

    public static final int NOTIFY_LEVEL_INVALID  = -1;//默认不接受消息
    public static final int NOTIFY_LEVEL_NONE = 0;//默认通知级别
    public static final int NOTIFY_LEVEL_CLOSE = 1;//接受消息不提示


    public static final int PERMISSION_TYPE_NONE = 0;//普通成员
    public static final int PERMISSION_TYPE_ADMIN = 1;//管理员
    public static final int PERMISSION_TYPE_ADMIN_SU= 100;//创建者


    @Id
    @PrimaryKeyJoinColumn
    //String存储的id是uuid的类型
    @GeneratedValue(generator = "uuid")
    //把uuid的生成器定义为uuid2,uuid2在hiber中是常规的UUID toString
    @GenericGenerator(name = "uuid",strategy = "uuid2")
    //不允许更改，不允许为null
    @Column(updatable = false,nullable = false)
    private String id;

    //别名
    @Column
    private String alias;

    //通知消息级别
    @Column(nullable = false)
    private int notifyLevel = NOTIFY_LEVEL_NONE;

    //成员类型
    @Column(nullable = false)
    private int permissionType = PERMISSION_TYPE_NONE;


    //定义为创建时间戳，在创建的时候就写入
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime cerateAt = LocalDateTime.now();

    //定义为更新时间戳，在创建的时候就写入
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime uptadeAt = LocalDateTime.now();

    //成员对应的用户信息
    @JoinColumn(name = "userId")
    @ManyToOne(optional = false,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private User user;

    @Column(nullable = false,updatable = false,insertable = false)
    private String userId;

    //成员信息对应的群信息
    @JoinColumn(name = "groupId")
    @ManyToOne(optional = false,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Group group;

    @Column(nullable = false,updatable = false,insertable = false)
    private String groupId;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getNotifyLevel() {
        return notifyLevel;
    }

    public void setNotifyLevel(int notifyLevel) {
        this.notifyLevel = notifyLevel;
    }

    public int getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(int permissionType) {
        this.permissionType = permissionType;
    }

    public LocalDateTime getCerateAt() {
        return cerateAt;
    }

    public void setCerateAt(LocalDateTime cerateAt) {
        this.cerateAt = cerateAt;
    }

    public LocalDateTime getUptadeAt() {
        return uptadeAt;
    }

    public void setUptadeAt(LocalDateTime uptadeAt) {
        this.uptadeAt = uptadeAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}
