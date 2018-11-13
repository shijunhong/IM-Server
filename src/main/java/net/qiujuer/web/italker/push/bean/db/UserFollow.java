package net.qiujuer.web.italker.push.bean.db;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;


/**
 * 用户关系的model
 * 用于用户直接进行好友关系的实现
 * */
@Entity
@Table(name = "TB_USER_FOLLOW")
public class UserFollow {


    @Id
    @PrimaryKeyJoinColumn
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid2")
    @Column(updatable = false,nullable = false)
    private String id;

    //定义发起人，你关注某人，这里就是你
    //n2o  你可以关注很多人，你的每一次关注都是一条记录
    //你可以创建很多个关注的信息，所以是多对1，user对应多个UserFollow
    //不可选，必须存储，一条关注记录，一定要有一个关注人
    @ManyToOne(optional = false)
    //定义的是数据库红的存储字段
    //定义关联的表字段名为originId 对应User.id
    @JoinColumn(name = "originId")
    private User origin;


    @Column(nullable = false,updatable = false,insertable = false)
    private String originId;

    //定义关注人，
    //n2o 你可以被很多人关注，每一次关注产生一条记录，所以多个UserFollow对应一个user
    @JoinColumn(name = "targetId")
    @ManyToOne(optional = false)
    private User target;


    @Column(nullable = false,updatable = false,insertable = false)
    private String targetId;

    //别名，也就是对target的备注
    @Column
    private String alias;

    //定义为创建时间戳，在创建的时候就写入
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime cerateAt = LocalDateTime.now();

    //定义为更新时间戳，在创建的时候就写入
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime uptadeAt = LocalDateTime.now();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getOrigin() {
        return origin;
    }

    public void setOrigin(User origin) {
        this.origin = origin;
    }

    public String getOriginId() {
        return originId;
    }

    public void setOriginId(String originId) {
        this.originId = originId;
    }

    public User getTarget() {
        return target;
    }

    public void setTarget(User target) {
        this.target = target;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
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
}
