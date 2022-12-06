package com.cloudcomputing.models;

import java.sql.Date;
import lombok.*;	

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GiangvienModel {
	private String maGV;
	private String hoTen;
	private Date ngaySinh;
	private int maKhoa;
	private String loaiGV;
}
