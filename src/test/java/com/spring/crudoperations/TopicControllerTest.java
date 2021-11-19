package com.spring.crudoperations;

import com.spring.crudoperations.dao.TopicRepository;
import com.spring.crudoperations.model.Topic;
import com.spring.crudoperations.service.TopicService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicControllerTest
{
    @Autowired
    private TopicService topicService;

    @MockBean
    private TopicRepository topicRepository;

    @Test
    public void getAllTopicsTest()
    {
        when(topicRepository.findAll()).thenReturn(Stream
                .of(new Topic("6" , "SpringBoot" ,"SpringBoot Description") ,
                        new Topic("7" , "SpringWeb" , "SpringWeb Description"))
                .collect(Collectors.toList()));

        assertEquals(2, topicService.getAllTopics().size());
    }

    @Test
    public void getTopicTest()
    {
        Topic topic = new Topic("2","Maven" ,"Maven Description");
        when(topicRepository.findByTopicId(topic.getId())).thenReturn(topic);

        assertEquals(topic, topicService.getTopic(topic.getId()));
    }

    @Test
    public void addTopicTest()
    {
        Topic topic = new Topic("2" , "Maven" ,"Maven Description");
        when(topicRepository.save(topic)).thenReturn(topic);

        assertEquals(topic , topicService.addTopic(topic));
    }

    @Test
    public void deleteTopicTest()
    {
        Topic topic = new Topic("2" , "Maven" ,"Maven Description");
        topicService.deleteTopic(topic.getId());
        verify(topicRepository , times(1)).deleteById(topic.getId());
    }

    @Test
    public void updateTopicTest()
    {
        String topicId = "2";
        Topic topic = new Topic("2" , "Maven" ,"Maven Description");
        when(topicRepository.save(topic)).thenReturn(topic);

        assertEquals(topic , topicService.updateTopic(topic , topicId));
    }
}
