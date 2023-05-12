package com.nt.entity;

import lombok.Data;

@Data
public class Tax {
	private double totalSalary;
	private Integer tax;
	private Integer cess;
	private Double lossOfPayPerDay;
	public double getTotalSalary() {
		return totalSalary;
	}
	public void setTotalSalary(double totalSalary) {
		this.totalSalary = totalSalary;
	}
	public Integer getTax() {
		return tax;
	}
	public void setTax(Integer tax) {
		this.tax = tax;
	}
	public Integer getCess() {
		return cess;
	}
	public void setCess(Integer cess) {
		this.cess = cess;
	}
	public Double getLossOfPayPerDay() {
		return lossOfPayPerDay;
	}
	public void setLossOfPayPerDay(Double lossOfPayPerDay) {
		this.lossOfPayPerDay = lossOfPayPerDay;
	}
	public Tax(double totalSalary, Integer tax, Integer cess, Double lossOfPayPerDay) {
		super();
		this.totalSalary = totalSalary;
		this.tax = tax;
		this.cess = cess;
		this.lossOfPayPerDay = lossOfPayPerDay;
	}
}
