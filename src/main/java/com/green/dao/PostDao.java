package com.green.dao;

import org.springframework.stereotype.Repository;

import com.green.domain.Post;

/**
 * Post的DAO类
 *
 */
@Repository
public class PostDao extends BaseDao<Post> {
	
	protected final String GET_PAGED_POSTS = "from Post where topic.topicId =? order by createTime desc"; 

	protected final String DELETE_TOPIC_POSTS = "delete from Post where topic.topicId=?";
	
	public Page getPagedPosts(int topicId, int pageNo, int pageSize) {
		return pagedQuery(GET_PAGED_POSTS,pageNo,pageSize,topicId);
	}
    
	/**
	 * 删除主题下的所有帖子
	 * @param topicId 主题ID
	 */
	public void deleteTopicPosts(int topicId) {
		getHibernateTemplate().bulkUpdate(DELETE_TOPIC_POSTS,topicId);
	}	
}
