package com.Kostyl.financial.mapper;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.List;

public class ObjectMapper {

    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    public static <O,D> D map(O object, Class<D> destinationClass) {
        return mapper.map(object, destinationClass);
    }

    public static <O,D> List<D> mapList(List<O> objects, Class<D> destination) {

        List<D> destinationClass = new ArrayList<D>();

        for (O object : objects) {
            destinationClass.add(mapper.map(object,destination));
        }

        return destinationClass;
    }

}
