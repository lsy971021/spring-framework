package com.lsy;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 对Date类型进行转换
 */
public class DateEditor extends PropertyEditorSupport {
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		try {
			setValue(new SimpleDateFormat("yyyy-MM-dd").parse(text));
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
}
