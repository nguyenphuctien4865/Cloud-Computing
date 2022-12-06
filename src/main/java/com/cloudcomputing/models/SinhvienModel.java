package com.cloudcomputing.models;
import java.sql.Date;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SinhvienModel {
	private String maSV;
	private String hoTen;
	private Date ngaySinh;
	private int maKhoa;
	private int accountID;
}
