package com.qtone.common.controller;

public class Test {
	
public static void main(String[] args) {
	String str="<html><head><title>Object moved</title></head><body><h2>Object moved to <a href=\"http://i.mypep.spm-edu.com/gdxkc/callback?next=http%3A%2F%2Fbook.mypep.spm-edu.com%2F&amp;token=A1Wqn2nQkj7C7/4vPG8tY MGOb1tjFbEXqpd/6WQX4CGnGl6Wc13yC0wEO4b8ocy&amp;operators_code=ZSJYQT\">here</a>.</h2></body></html>";
	String aa=str.substring(str.indexOf("http://"), str.indexOf("=ZSJYQT")+7);
	System.out.println(aa);
}
}
