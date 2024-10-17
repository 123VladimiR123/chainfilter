package com.example.testchain.chain;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class GodValidator {
    private boolean isBuilt = false;
    private final HashMap<Type, List<ElementaryValidator<?>>> valMap = new HashMap<>();
    public final void subscribe(ElementaryValidator<?> validator) {
        if (isBuilt) throw new IllegalArgumentException("validator is done");
        Type type = ((ParameterizedType) validator.getClass().getGenericSuperclass()).getActualTypeArguments()[0];

        if (valMap.containsKey(type)) {
            valMap.get(type).add(validator);
        } else {
            List<ElementaryValidator<?>> list = new ArrayList<>();
            list.add(validator);
            valMap.put(type, list);
        }
    }

    public final void validate(Object element) {
        valMap
            .get(element.getClass())
            .stream()
            .forEach(e -> validateElement(e, element));
    }

    private final <T> void validateElement(ElementaryValidator<T> validator, Object element) {
        validator.returnNullOrThrowException((T) element);
    }

    public GodValidator immutable() {
        isBuilt = true;
        return this;
    }
}
