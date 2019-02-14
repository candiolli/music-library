package br.com.candiolli.musiclibrary.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class JsonDateSerializer extends JsonSerializer<Date> {

	private SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");

	@Override
	public void serialize(Date date, JsonGenerator gen, SerializerProvider provider)
			throws IOException {

		String formattedDate = formatter.format(date);

		gen.writeString(formattedDate);
	}
}
