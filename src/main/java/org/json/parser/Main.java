package org.json.parser;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String path = "src/main/resources/awsFile.json";
        boolean result = checkResourceField(path);

        System.out.println("result: " + result);
    }

    public static boolean checkResourceField(String path) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            JsonNode jsonNode = objectMapper.readTree(new File(path));
            JsonNode policyDocumentNode = jsonNode.path("PolicyDocument");
            JsonNode statementNode = policyDocumentNode.path("Statement");
            JsonNode resourceNode = statementNode.path(0).path("Resource");
            String value = resourceNode.asText();

            return !value.equals("*");
        } catch(IOException e) {
            e.printStackTrace();
            return true;
        }
    }


}
