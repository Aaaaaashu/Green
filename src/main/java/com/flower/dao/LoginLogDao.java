package com.flower.dao;

import org.springframework.stereotype.Repository;

import com.flower.domain.LoginLog;

@Repository
public class LoginLogDao extends BaseDao<LoginLog> {
	public void save(LoginLog loginLog) {
		this.getHibernateTemplate().save(loginLog);
	}
}
