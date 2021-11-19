package com.spring.crudoperations.controller;

import com.spring.crudoperations.model.Topic;
import com.spring.crudoperations.service.TopicService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TopicController
{
    @Autowired
    private TopicService topicService;

    Logger logger = Logger.getLogger(TopicController.class);

    @RequestMapping("/topics")
    public List<Topic> getAllTopics()
    {
        logger.info("Retrieve all topics");
        return topicService.getAllTopics();
    }


    @RequestMapping("/topics/{id}")
    public Optional<Topic> getTopic(@PathVariable String id)
    {
        logger.info("Retrieve topic with topic id = " + id);
        return topicService.getTopic(id);
    }

    @RequestMapping(method = RequestMethod.POST , value = "/topics")
    public void addTopic(@RequestBody Topic topic)
    {
        logger.info("Adding new Topic");
        topicService.addTopic(topic);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
    public void updateTopic(@RequestBody Topic topic , @PathVariable String id)
    {
        logger.info("Update topic with topic id = " + id);
        topicService.updateTopic(topic , id);
    }

    @RequestMapping(method = RequestMethod.DELETE , value = "/topics/{id}")
    public void deleteTopic(@PathVariable String id)
    {
        logger.info("Delete Topic with topic id = " + id);
        topicService.deleteTopic(id);
    }
}
