package com.uqiauto.service;

import javax.annotation.Resource;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.uqiauto.pojo.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uqiauto.dao.UserMapper;
import com.uqiauto.pojo.User;

import java.util.List;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;

	public User getUserById(Long userId){
		return this.userMapper.selectByPrimaryKey(userId);
	}

	public PageInfo<User> queryAllUser(){
		//设置分页
		PageHelper.startPage(1,10);
		//执行查询
		UserExample example=new UserExample();
		UserExample.Criteria criteria=example.createCriteria();
		List<User> userList=this.userMapper.selectByExample(example);
		//取分页后结果
		PageInfo<User> pageInfo=new PageInfo<User>(userList);
		long total=pageInfo.getTotal();
		int pages=pageInfo.getPages();
		int pageSize=pageInfo.getPageSize();
		System.out.println("total:" + total +"；pages:" + pages + "；pageSize:" + pageSize);
		return pageInfo;
	}

}
