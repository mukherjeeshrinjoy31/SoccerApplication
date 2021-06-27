package com.application.soccer.enumobject;

public enum EnumPosition {
	
	CF(1, "CF"),
	ST(2, "ST"),
	LW(3, "LW"),
	RW(4, "RW"),
	CDM(5, "CDM"),
	CAM(6,"CAM"),
	CB(7, "CB"),
	RB(8, "RB"),
	LB(9, "LB"),
	GK(10, "GK");
	
	private Integer id;
	private String value;
	
	private EnumPosition(Integer id, String value) {
		this.id = id;
		this.value = value;
	}
	
	public Integer id() {
		return id;
	}
	
	public String value() {
		return value;
	}
	
}
