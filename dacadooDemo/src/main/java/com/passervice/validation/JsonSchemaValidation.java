package com.passervice.validation;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonSchemaValidation {

	public static void main(String[] arg) {

	}

	public static boolean validateJsonWithSchema(String josnString, String jsonSchema)
			throws JsonParseException, JsonMappingException, IOException {
		boolean valid = false;
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readValue(jsonSchema, JsonNode.class);
		return valid;
	}

}
