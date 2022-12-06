package com.cloudcomputing.models;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class KhoaModel {
	private int khoa;
	private String tenKhoa;
	public KhoaModel(String tenKhoa) {
		super();
		this.tenKhoa = tenKhoa;
	}
}
