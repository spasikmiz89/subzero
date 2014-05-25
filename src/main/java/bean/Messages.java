package bean;


import entity.Message;
import entity.User;
import service.MessageService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ManagedBean(name = "Messages", eager=true)
@RequestScoped
public class Messages {

    @ManagedProperty("#{messageService}")
    private MessageService messageService;

    private List<Message> messages;

    private List<User> winners;

    private Integer id;

    private Integer userId;

    private String message;

    private Date date;

    private Integer priority;

    @PostConstruct
    public void init() {
        this.messages = messageService.getMessages();
    }

    public void vote(Integer id){
        messageService.vote(id);
        this.messages = messageService.getMessages();
    }

    public void delete(Integer id){
         messageService.delete(id);
        this.messages = messageService.getMessages();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public void addMessage(){
         messageService.addMessage(this);
        this.messages = messageService.getMessages();
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public MessageService getMessageService() {
        return messageService;
    }

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    public List<User> getWinners() {
        return winners;
    }

    public void setWinners(List<User> winners) {
        this.winners = winners;
    }
}
