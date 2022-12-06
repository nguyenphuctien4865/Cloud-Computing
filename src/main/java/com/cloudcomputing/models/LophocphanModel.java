package com.cloudcomputing.models;
import java.sql.Date;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LophocphanModel {
	private int id;
	private String maLop;
	private String loai;
	private String maMH;
	private String maGV;
	private String phong;
	private int soSV;
	private Date ngayBD;
	private int namHoc;
	private int thu;
	private String tiet;
	
	public LophocphanModel(String maLop, String loai, String maMH, String maGV, String phong, int soSV, Date ngayBD,
			int namHoc, int thu, String tiet) {
		super();
		this.maLop = maLop;
		this.loai = loai;
		this.maMH = maMH;
		this.maGV = maGV;
		this.phong = phong;
		this.soSV = soSV;
		this.ngayBD = ngayBD;
		this.namHoc = namHoc;
		this.thu = thu;
		this.tiet = tiet;
	}
	
}
