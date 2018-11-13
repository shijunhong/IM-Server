package net.qiujuer.web.italker.push.bean.db;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_USER_FOLLOW")
public class Group {


    @Id
    @PrimaryKeyJoinColumn
    //String存储的id是uuid的类型
    @GeneratedValue(generator = "uuid")
    //把uuid的生成器定义为uuid2,uuid2在hiber中是常规的UUID toString
    @GenericGenerator(name = "uuid",strategy = "uuid2")
    //不允许更改，不允许为null
    @Column(updatable = false,nullable = false)
    private String id;


    //群名称
    @Column(nullable = false)
    private String name;


    //群描述
    @Column(nullable = false)
    private String description;


    //群头像
    @Column(nullable = false)
    private String picture;


    //定义为创建时间戳，在创建的时候就写入
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime cerateAt = LocalDateTime.now();

    //定义为更新时间戳，在创建的时候就写入
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime uptadeAt = LocalDateTime.now();



    //群的创建者，
    //optional  可选为false  必须有创建者
    //fetch 加载方式为FetchType.EAGER 即加载  意味着加载群信息的时候必须加载用户的信息
    //casecade:联级级别为all  所有的变更  豆浆进行关系更新
    @ManyToOne(optional = false,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "ownerId")
    private User user;

    @Column(nullable = false,updatable = false,insertable = false)
    private String ownerId;




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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
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
