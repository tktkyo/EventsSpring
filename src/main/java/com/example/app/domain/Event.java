package com.example.app.domain;

import lombok.Data;

// eventsテーブルの情報を保持
@Data
public class Event {
	private int id;
	private String title;
	private String date;
	private String treatment;
	private String gift;
}
