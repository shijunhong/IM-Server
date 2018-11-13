package net.qiujuer.web.italker.push.bean.db;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_MESSAGE")
public class Message {

    public static final int TYPE_STR = 1;//字符串
    public static final int TYPE_PIC = 2;//图片
    public static final int TYPE_FILE = 3;//文件
    public static final int TYPE_AUDIO = 4;//语音

    @Id
    @PrimaryKeyJoinColumn
    //由客户端生成id，避免复杂的服务器和客户端映射关系
    //把uuid的生成器定义为uuid2,uuid2在hiber中是常规的UUID toString
    @GenericGenerator(name = "uuid",strategy = "uuid2")
    //不允许更改，不允许为null
    @Column(updatable = false,nullable = false)
    private String id;

    //内容不许为空，类型为text
    @Column(nullable = false,columnDefinition = "TEXT")
    private String content;

    //附件
    @Column
    private String attach;


    //消息类型，
    @Column(nullable = false)
    private int type;


    //发送者 不为空
    //多消息对应一个发送者
    //当前消息，对应一个user
    @JoinColumn(name = "senderId")
    @ManyToOne(optional = false)
    private User sender;//发送者

    @Column(updatable = false,insertable = false)
    private String senderId;



    //接受者，可为空
    //多个消息对应一个接受者
    @JoinColumn(name = "receiverId")
    @ManyToOne
    private User receiver;//接收者

    @Column(updatable = false,insertable = false)
    private String receiverId;


    //定义为创建时间戳，在创建的时候就写入
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime cerateAt = LocalDateTime.now();

    //定义为更新时间戳，在创建的时候就写入
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime uptadeAt = LocalDateTime.now();



    //一个群可以接受多个消息
    @JoinColumn(name = "groupId")
    @ManyToOne
    private Group group;//接收者
    @Column(updatable = false,insertable = false)
    private String groupId;




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
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

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
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
