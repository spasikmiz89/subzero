package service;


import bean.Messages;
import entity.Message;
import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.faces.bean.ManagedProperty;
import java.util.Date;
import java.util.List;
@Transactional
public class MessageServiceImpl implements MessageService{

    @ManagedProperty("#{sessionFactory}")
    private SessionFactory sessionFactory;

    @Override
    public void addMessage(Messages messages) {
        Session session = sessionFactory.getCurrentSession();
        Message message = new Message();
        message.setDate(new Date());
        message.setMessage(messages.getMessage());
        message.setPriority(0);
        message.setUser((User)session.load(User.class,messages.getUserId()));
        session.saveOrUpdate(message);
        //session.flush();
    }

    @Override
    public void delete(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(session.load(Message.class,id));
    }

    @Override
    public void vote(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Message message = (Message)session.load(Message.class,id);
        message.setPriority(message.getPriority() + 1);
        session.saveOrUpdate(message);
    }

    @Override
    public List<Message> getMessages() {
        Session session = sessionFactory.getCurrentSession();
        return (List<Message>)session.createQuery("select m from Message m order by m.priority desc").list();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
