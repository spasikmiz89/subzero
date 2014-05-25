package entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "message")
public class Message {

    private final static String SEQUENCE = "message_seq";
    @Id
    @SequenceGenerator(name = SEQUENCE, sequenceName = SEQUENCE)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE)
    @Column(name = "id")
    private Integer id;

    @ManyToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "message")
    private String message;

    @Column(name = "date_dt")
    private Date date;

    @Column(name = "priority")
    private Integer priority;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}
