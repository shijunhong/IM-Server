package net.qiujuer.web.italker.push.bean.db;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * 用户的model，对应数据库
 * */

@Entity
@Table(name = "TB_USER")
public class User {
    //这是一个主键，
    @Id
    @PrimaryKeyJoinColumn
    //String存储的id是uuid的类型
    @GeneratedValue(generator = "uuid")
    //把uuid的生成器定义为uuid2,uuid2在hiber中是常规的UUID toString
    @GenericGenerator(name = "uuid",strategy = "uuid2")
    //不允许更改，不允许为null
    @Column(updatable = false,nullable = false)
    private String id;

    //用户名必须唯一
    @Column(nullable = false,length = 128,unique = true)
    private String name;

    //电话必须唯一
    @Column(nullable = false,length = 62,unique = true)
    private String phone;

    @Column(nullable = false)
    private String password;

    //头像允许为空
    @Column
    private String portrait;

    @Column
    private String description;//描述

    //性别有初始值，所以不为空
    @Column(nullable = false)
    private int sex = 0;//性别


    //token必须唯一，token可以拉去用户信息
    @Column(unique = true)
    private String token;

    //用于推送的设备ID
    @Column
    private String pushId;

    //定义为创建时间戳，在创建的时候就写入
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime cerateAt = LocalDateTime.now();

    //定义为更新时间戳，在创建的时候就写入
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime uptadeAt = LocalDateTime.now();

    //最后一次收到消息的时间
    @Column
    private LocalDateTime lastReceivedAt = LocalDateTime.now();



    //我关注的人的列表
    //对应的数据库表字段  TV_USER_FOLLOW_.orifinId;
    @JoinColumn(name = "originId")
    //定义为懒加载，默认加载User信息的时候不查询这个集合
    @LazyCollection(LazyCollectionOption.EXTRA)
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<UserFollow> following = new HashSet<>();



    //关注我的人的列表
    //对应的数据库表字段  TV_USER_FOLLOW_.orifinId;
    @JoinColumn(name = "targetId")
    //定义为懒加载，默认加载User信息的时候不查询这个集合
    @LazyCollection(LazyCollectionOption.EXTRA)
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<UserFollow> followers = new HashSet<>();


    //我所有创建的群
    @JoinColumn(name = "ownerId")
    //定义为懒加载，默认加载User信息的时候不查询这个集合
    @LazyCollection(LazyCollectionOption.EXTRA)
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Group> groups = new HashSet<>();





    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
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

    public LocalDateTime getLastReceivedAt() {
        return lastReceivedAt;
    }

    public void setLastReceivedAt(LocalDateTime lastReceivedAt) {
        this.lastReceivedAt = lastReceivedAt;
    }


    public Set<UserFollow> getFollowing() {
        return following;
    }

    public void setFollowing(Set<UserFollow> following) {
        this.following = following;
    }

    public Set<UserFollow> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<UserFollow> followers) {
        this.followers = followers;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }
}
