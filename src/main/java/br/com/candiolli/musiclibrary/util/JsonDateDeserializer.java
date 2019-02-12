package br.com.candiolli.musiclibrary.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class JsonDateDeserializer extends JsonDeserializer<Date> {

	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static final Logger LOG = LoggerFactory.getLogger(JsonDateDeserializer.class);

	@Override
	public Date deserialize(JsonParser jsonParser, DeserializationContext context)
			throws IOException {
		String dateAsString = jsonParser.getText();
		try {
			return formatter.parse(dateAsString);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			return null;
		}
	}
}
