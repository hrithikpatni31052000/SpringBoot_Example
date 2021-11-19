package com.spring.crudoperations.service;

import com.spring.crudoperations.dao.TopicRepository;
import com.spring.crudoperations.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService
{
    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getAllTopics()
    {
        //return topics;
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Topic getTopic(String id)
    {
        //return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return topicRepository.findByTopicId(id);
    }

    public Topic addTopic(Topic topic)
    {
        //topics.add(topic);
        topicRepository.save(topic);
        return topic;
    }

    public Topic updateTopic(Topic topic, String id)
    {
        /*
        for(int i = 0 ; i < topics.size() ; i++)
        {
            Topic t = topics.get(i);
            if(t.getId().equals(id))
            {
                topics.set(i , topic);
                return;
            }
        }*/
        topicRepository.save(topic);
        return topic;
    }

    public void deleteTopic(String id)
    {
        //topics.removeIf(t -> t.getId().equals(id));
        topicRepository.deleteById(id);
    }
}
