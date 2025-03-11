package com.example.app.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.Event;

@Mapper
public interface EventMapper {
	Event find();
	void update(Event event);
}
