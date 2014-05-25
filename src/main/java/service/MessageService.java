package service;

import bean.Messages;
import entity.Message;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Spasik
 * Date: 29.04.14
 * Time: 21:58
 * To change this template use File | Settings | File Templates.
 */
public interface MessageService {
    public void addMessage(Messages messages);
    public List<Message> getMessages();
    public void vote(Integer id);
    public void delete(Integer id);
}
