package com.learning.annotations.examples.jsonserializer;


import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.joining;

public class JsonSerializer {

    public String serialize(Object object) throws JsonSerializeException {

        try {
            Class<?> objectClass = requireNonNull(object).getClass();
            Map<String, String> jsonElements = new HashMap<>();

            for (Field field : objectClass.getDeclaredFields()) {
                /**
                 * For each field, we configure the field to suppress Java language access checking when accessing the
                 * field. This is a very important step since the fields we annotated are private. In the standard case,
                 * we would be unable to access these fields, and attempting to obtain the value of the private field would
                 * result in an IllegalAccessException being thrown.
                 */
                field.setAccessible(true);
                if (field.isAnnotationPresent(JsonField.class)) {
                    jsonElements.put(getSerializedKey(field), (String) field.get(object));
                }
            }
            System.out.println(toJsonString(jsonElements));
            return toJsonString(jsonElements);
        } catch (IllegalAccessException e) {
            throw new JsonSerializeException(e.getMessage());
        }
    }

    private String toJsonString(Map<String, String> jsonMap) {
        String elementsString = jsonMap.entrySet()
                .stream()
                .map(entry -> "\"" + entry.getKey() + "\":\"" + entry.getValue() + "\"")
                .collect(joining(","));
        return "{" + elementsString + "}";
    }

    private static String getSerializedKey(Field field) {
        String annotationValue = field.getAnnotation(JsonField.class).value();

        if (annotationValue.isEmpty()) {
            return field.getName();
        } else {
            return annotationValue;
        }
    }
}
