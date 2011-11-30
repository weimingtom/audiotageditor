package com.life.audiotageditor.utils;

public class StringUtil {

	public static String formatPath(String path) {
		return path.replaceAll("\\\\", "/");
	}
}
