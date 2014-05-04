package com.flower.dao;

import org.springframework.stereotype.Repository;

import com.flower.domain.Post;

@Repository
public class PostDao extends BaseDao<Post> {
	
	protected final String GET_PAGE_POSTS = "from Post where topic.topicId = ? order by createTime desc";
	protected final String DELETE_TOPIC_POSTS = "delete from Post where topic.topicId=?";
	
	public Page getPagedPosts(int topicId, int pageNo, int pageSize) {
		return pagedQuery(GET_PAGE_POSTS, pageNo, pageSize, topicId);
	}
	
	public void deleteTopicPosts(int topicId) {
		getHibernateTemplate().bulkUpdate(DELETE_TOPIC_POSTS, topicId);
	}

}
