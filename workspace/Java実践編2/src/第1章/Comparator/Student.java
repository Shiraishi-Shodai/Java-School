package 第1章.Comparator;

import java.util.Objects;

public class Student implements Comparable<Student> {
	private int no; // 出席番号
	private String name; // 氏名
	private String address; // 住所
	private int year; // 生年月日 年
	private int month; // 生年月日 月
	private int day; // 生年月日 日

	public String toString() {
		return "学生情報　出席番号：" + this.no + ", 氏名：" + this.name + ", 住所：" + this.address + ", 生年月日：" + this.year + "/"
				+ this.month + "/" + this.day;
	}
	public Student(int no, String name, String address, int year, int month, int day) {
		this.no = no;
		this.name = name;
		this.address = address;
		this.year = year;
		this.month = month;
		this.day = day;
	}
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (o == null)
			return false;
		if (!(o instanceof Student))
			return false;
		Student r = (Student) o;
		if (this.no != r.no || !this.name.equals(r.name) || !this.address.equals(r.address) || this.year != r.year
				|| this.month != r.month || this.day != r.day) {
			return false;
		}
		return true;
	}
	public int hashCode() {
		return Objects.hash(this.no, this.name, this.address, this.year, this.month, this.day);
	}
	public int compareTo(Student obj) {
		if (this.no < obj.no) {
			return -1;
		}
		if (this.no > obj.no) {
			return 1;
		}
		return 0;
	}
	public int getYear() {
		return year;
	}
	public int getMonth() {
		return month;
	}
	public int getDay() {
		return day;
	}
}