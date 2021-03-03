package com.courseapi.data.topic;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;   //spring will create an instance of TopicService and inject it into topic repository
	
	/*
	 * private List<Topic> topics = new ArrayList<>(Arrays.asList( new
	 * Topic("Spring", "Spring-Framework", "Framework Description"), new
	 * Topic("AWS", "AWS", " AWS Description"), new Topic("Docker", "Docker",
	 * "Docker Description"), new Topic("DSA", "DSA", "Algorithm Description") ));
	 */
	
	public List<Topic> getAllTopics(){
		//return topics;
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll()
		.forEach(topics :: add);
		return topics;
	}
	
	public Topic getTopic(String id) {
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return topicRepository.findById(id).get();
	}

	public void addTopic(Topic topic) {
		//topics.add(topic);
		topicRepository.save(topic); //to save into db 
	}

	public void updateTopic(String id, Topic topic) {
		/*
		 * for(int i=0;i<topics.size();i++) { Topic t = topics.get(i);
		 * if(t.getId().equals(id)) { topics.set(i, topic); return ; } }
		 */
		
		topicRepository.save(topic);
	}

	public void deleteTopic(String id) {
		//topics.removeIf( t -> t.getId().equals(id));
		topicRepository.deleteById(id);
	}
}
