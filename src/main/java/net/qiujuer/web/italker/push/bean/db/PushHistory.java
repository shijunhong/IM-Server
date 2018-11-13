package net.qiujuer.web.italker.push.bean.db;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.omg.CORBA.PRIVATE_MEMBER;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_PUSH_HISTORY")
public class PushHistory {


    @Id
    @PrimaryKeyJoinColumn
    //String存储的id是uuid的类型
    @GeneratedValue(generator = "uuid")
    //把uuid的生成器定义为uuid2,uuid2在hiber中是常规的UUID toString
    @GenericGenerator(name = "uuid",strategy = "uuid2")
    //不允许更改，不允许为null
    @Column(updatable = false,nullable = false)
    private String id;


    //推送的具体实体存储的都是JSON字符串
    //BOLB  比text还要大一点的大字段类型
    @Column(nullable = false,columnDefinition = "BLOB")
    private String entity;

    //推送的实体类型
    @Column(nullable = false)
    private int entityType;

    //接收者
    //一个接受者可以接受很多推送消息
    //fetch 加载一条推送消息的时候直接加载用户信息
    @JoinColumn(name = "receiverId")
    @ManyToOne(optional = false,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private User receiver;

    @Column(nullable = false,updatable = false,insertable = false)
    private String receiverId;


    //接收者当前状态下的设备推送id
    //User.pushId
    @Column
    private String receiverPushId;


    //定义为创建时间戳，在创建的时候就写入
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime cerateAt = LocalDateTime.now();

    //定义为更新时间戳，在创建的时候就写入
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime uptadeAt = LocalDateTime.now();


    //发送者
    @JoinColumn(name = "senderId")
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private User sender;

    @Column(updatable = false,insertable = false)
    private String senderId;

    //消息送达时间
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime arrivalAt ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public int getEntityType() {
        return entityType;
    }

    public void setEntityType(int entityType) {
        this.entityType = entityType;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public String getReceiverPushId() {
        return receiverPushId;
    }

    public void setReceiverPushId(String receiverPushId) {
        this.receiverPushId = receiverPushId;
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

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public LocalDateTime getArrivalAt() {
        return arrivalAt;
    }

    public void setArrivalAt(LocalDateTime arrivalAt) {
        this.arrivalAt = arrivalAt;
    }
}
