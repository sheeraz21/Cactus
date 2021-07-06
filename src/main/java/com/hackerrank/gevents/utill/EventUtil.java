package com.hackerrank.gevents.utill;


import java.util.Arrays;

import org.springframework.stereotype.Service;

@Service
public class EventUtil {

	public static final String[] eventsType = { "PushEvent", "ReleaseEvent", "WatchEvent" };

	public boolean getEventType(String eventType) {

		if (Arrays.asList(eventsType).contains(eventType)) {

			return true;
		}
		return false;

	}

}
