package io.springbootstarter.repository;

import io.springbootstarter.model.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String>
{

}
