package com.multifinance.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CommonUtil {
	public static String toTitleCase(String text) {
		if (text == null || text.isEmpty()) {
			return text;
		}
		StringBuilder converted = new StringBuilder();
		boolean convertNext = true;
		for (char ch : text.toCharArray()) {
			if (Character.isSpaceChar(ch)) {
				convertNext = true;
			} else if (convertNext) {
				ch = Character.toTitleCase(ch);
				convertNext = false;
			} else {
				ch = Character.toLowerCase(ch);
			}
			converted.append(ch);
		}
		return converted.toString().trim();
	}

	public static String modelToString(Object model) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(model).toString();
	}
	public static String DateFormatter(LocalDateTime date)
	{
		   DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		   return formatter.format(Date.from( date.atZone( ZoneId.systemDefault()).toInstant()));
	}
	public static String removeBracket(String text) {
		StringBuilder remove = new StringBuilder(text);
		remove.setCharAt(0, ' ');
		remove.setCharAt((remove.length() - 1), ' ');
		return remove.toString();
	}
	public static String replaceString(String text,String target,String replace)
	{
		String replacedStr = text.replace(target, replace);
		return replacedStr;
	}
	public static String createBracket(String text) {
		StringBuilder create = new StringBuilder(text);
		create.setCharAt(0, '{');
		create.setCharAt((create.length() - 1), '}');
		return create.toString();
	}

	public static String updateResponse(String json, String response) {
		JSONObject testObject = new JSONObject(json);
		testObject.put("response", response);
		return testObject.toString();
	}

	public static String getResponse(String json) {
		JSONObject testObject = new JSONObject(json);
		return testObject.getString("response").toString();
	}

	public static String getResponseList(String json, String key) {
		StringBuilder create = new StringBuilder();
		JSONObject jsonObject = new JSONObject(json);
		JSONArray jsonArray = jsonObject.getJSONArray(key);
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject anotherJsonObject = jsonArray.getJSONObject(i);
			create.append(anotherJsonObject.get("response"));
		}
		return create.toString();
	}
	
	public static void callLogsService(String url, Object model) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Object> entity = new HttpEntity<Object>(model, headers);
		restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

	}
}