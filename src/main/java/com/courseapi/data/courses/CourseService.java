package com.courseapi.data.courses;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;   //spring will create an instance of TopicService and inject it into topic repository
	
	/*
	 * private List<Topic> topics = new ArrayList<>(Arrays.asList( new
	 * Topic("Spring", "Spring-Framework", "Framework Description"), new
	 * Topic("AWS", "AWS", " AWS Description"), new Topic("Docker", "Docker",
	 * "Docker Description"), new Topic("DSA", "DSA", "Algorithm Description") ));
	 */
	
	public List<Course> getAllCourses(String topicId){
		//return topics;
		List<Course> course = new ArrayList<>();
		courseRepository.findByTopicId(topicId)
		.forEach(course :: add);
		return course;
	}
	
	public Course getCourses(String id) {
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return courseRepository.findById(id).get();
	}

	public void addCourses(Course course) {
		//topics.add(topic);
		courseRepository.save(course); //to save into db 
	}

	public void updateCourses(Course course) {
		/*
		 * for(int i=0;i<topics.size();i++) { Topic t = topics.get(i);
		 * if(t.getId().equals(id)) { topics.set(i, topic); return ; } }
		 */
		
		courseRepository.save(course);
	}

	public void deleteCourses(String id) {
		//topics.removeIf( t -> t.getId().equals(id));
		courseRepository.deleteById(id);
	}
}
