package com.life.audiotageditor.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

	public static String formatPath(String path) {
		return path.replaceAll("\\\\", "/"); //$NON-NLS-1$ //$NON-NLS-2$
	}

	public static String substring(String string, String pattern) {
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(string);
		if (m.find()) {
			string = m.group();
		}
		return string;
	}
}
