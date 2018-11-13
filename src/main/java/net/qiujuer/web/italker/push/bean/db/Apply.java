package net.qiujuer.web.italker.push.bean.db;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_APPLY")
public class Apply {

    public static final int TYPE_ADD_USER = 1;//添加好友
    public static final int TYPE_ADD_GROUP = 2;//添加群

    @Id
    @PrimaryKeyJoinColumn
    //String存储的id是uuid的类型
    @GeneratedValue(generator = "uuid")
    //把uuid的生成器定义为uuid2,uuid2在hiber中是常规的UUID toString
    @GenericGenerator(name = "uuid",strategy = "uuid2")
    //不允许更改，不允许为null
    @Column(updatable = false,nullable = false)
    private String id;



    //描述部分，对我们的事情信息做描述
    @Column(nullable = false)
    private String description;


    //附件  可以附带图片地址或者其他
    @Column(columnDefinition = "TEXT")
    private String attach;

    //当前申请的类型
    @Column(nullable = false)
    private int type;

    //目标id 不强关联，不建立主外键
    //如果type = TYPE_ADD_USER User.id
    //如果type = TYPE_ADD_GROUP Group.id
    @Column(nullable = false)
    private String targetId;


    //申请人  可为空，为系统信息
    //一个人可以有很多个事情
    @ManyToOne()
    @JoinColumn(name = "applicantId")
    private User applicant;

    @Column(updatable = false,insertable = false)
    private String applicantId;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public User getApplicant() {
        return applicant;
    }

    public void setApplicant(User applicant) {
        this.applicant = applicant;
    }

    public String getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(String applicantId) {
        this.applicantId = applicantId;
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
