package com.spring.crudoperations.dao;

import com.spring.crudoperations.model.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String>
{
    public Topic findByTopicId(String TopicId);
}
