package com.edesafio.quasar.service.impl;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.edesafio.quasar.dto.SatelliteDTO;
import com.edesafio.quasar.dto.SatellitesDTO;


@Service
public class MessageService {

	public String getMessage(SatellitesDTO satellites) {
		
		String messageFinal = "";

		ArrayList<String> messageFull = new ArrayList<String>();

		for (SatelliteDTO satelite : satellites.getSatellite()) {
			if (messageFull.size() == 0) {
				messageFull.addAll(satelite.getMessage());
			}
			for (int i = 0; i < satelite.getMessage().size(); i++) {

				if (!(messageFull.get(i) == (satelite.getMessage().get(i))) && (satelite.getMessage().get(i) != "")) {
					messageFull.set(i, satelite.getMessage().get(i));
				}
			}

		}
		
		messageFinal = data(messageFull.toString(), ", ", " ");
		messageFinal = data(messageFinal, "[", "");
		messageFinal = data(messageFinal, "]", "");
		
		return messageFinal;
	}

	public static String data(String string, String searchPattern, String replacementPattern) {

		String search = Pattern.quote(new StringBuffer(searchPattern).toString());
		String replace = Matcher.quoteReplacement(new StringBuffer(replacementPattern).toString());
		Pattern pat = Pattern.compile(search, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
		Matcher mat = pat.matcher(string);
		string = mat.replaceAll(replace);

		return string;

	}

}
