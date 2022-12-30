package jpb.photoproject.helper;

import converter.ObjectConverter;

import java.util.List;

public class ConverterHelper {

    public static <T> List<T> list(final List<?> source, final Class<T> targetClass) {
        return new ObjectConverter().list(source, targetClass);
    }

    public static <T> T converts(final Object source, final Class<T> targetClass) {
        return new ObjectConverter().convert(source, targetClass);
    }
}
