package com.example.app.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

// adminsテーブルのデータを保持
@Data
public class Admin {
	private int id;
	@NotBlank
	private String loginId;
	private String name;
	private String loginPass;
}