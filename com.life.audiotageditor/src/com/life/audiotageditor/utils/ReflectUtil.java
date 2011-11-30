package com.life.audiotageditor.utils;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

public class ReflectUtil {

	public static String getProperty(Object bean, String name) {
		try {
			String propertyValue = BeanUtils.getProperty(bean, name);
			return propertyValue == null ? "" : propertyValue;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return "";
	}

	public static void setProperty(Object bean, String name, String value) {
		try {
			BeanUtils.setProperty(bean, name, value);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
