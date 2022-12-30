package jpb.photoproject.helper;

import jakarta.persistence.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.ManyToAny;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class HibernateHelper {

    public static void initializeAll(final Collection<?> entities) {
        for (final Object entity : entities) HibernateHelper.initializeAll(entity);
    }

    public static void initializeAll(Object entity) {
        if (null == entity) return;
        Hibernate.initialize(entity);
        entity = Hibernate.unproxy(entity);
        final Class<?> entityClass = entity.getClass();
        if (HibernateHelper.isCollection(entityClass)) {
            HibernateHelper.initializeAll((Collection<?>) entity);
            return;
        }
        if (HibernateHelper.isEntity(entityClass) || HibernateHelper.isLazy(entityClass)) {
            for (final Field field : entityClass.getDeclaredFields()) {
                field.setAccessible(true);
                try {
                    HibernateHelper.initializeAll(field.get(entity));
                } catch (Exception e) {
                    //
                }
            }
        }
    }

    public static void clearAllLazy(final Collection<?> entities) {
        for (final Object entity : entities) HibernateHelper.clearAllLazy(entity);
    }

    public static void clearAllLazy(Object entity) {
        if (null == entity) return;
        final Class<?> entityClass = entity.getClass();
        if (HibernateHelper.isEntity(entityClass)) {
            for (final Field field : entityClass.getDeclaredFields()) {
                field.setAccessible(true);
                if (!HibernateHelper.isLazy(field)) continue;
                final Class<?> fieldType = field.getType();
                try {
                    if (HibernateHelper.isList(fieldType)) field.set(entity, new ArrayList<>());
                    else field.set(entity, null);
                } catch (Exception e) {
                    //
                }
            }
        }
    }

    private static boolean isEntity(final Class<?> entityClass) {
        return entityClass.isAnnotationPresent(Entity.class);
    }

    private static boolean isLazy(final Class<?> entityClass) {
        final ManyToAny manyToAny = entityClass.getAnnotation(ManyToAny.class);
        if (null != manyToAny && FetchType.LAZY.equals(manyToAny.fetch())) return true;

        final ManyToMany manyToMany = entityClass.getAnnotation(ManyToMany.class);
        if (null != manyToMany && FetchType.LAZY.equals(manyToMany.fetch())) return true;

        final ManyToOne manyToOne = entityClass.getAnnotation(ManyToOne.class);
        if (null != manyToOne && FetchType.LAZY.equals(manyToOne.fetch())) return true;

        final OneToOne oneToOne = entityClass.getAnnotation(OneToOne.class);
        if (null != oneToOne && FetchType.LAZY.equals(oneToOne.fetch())) return true;

        final OneToMany oneToMany = entityClass.getAnnotation(OneToMany.class);
        return null != oneToMany && FetchType.LAZY.equals(oneToMany.fetch());
    }

    private static boolean isLazy(final Field field) {
        final ManyToAny manyToAny = field.getAnnotation(ManyToAny.class);
        if (null != manyToAny && FetchType.LAZY.equals(manyToAny.fetch())) return true;

        final ManyToMany manyToMany = field.getAnnotation(ManyToMany.class);
        if (null != manyToMany && FetchType.LAZY.equals(manyToMany.fetch())) return true;

        final ManyToOne manyToOne = field.getAnnotation(ManyToOne.class);
        if (null != manyToOne && FetchType.LAZY.equals(manyToOne.fetch())) return true;

        final OneToOne oneToOne = field.getAnnotation(OneToOne.class);
        if (null != oneToOne && FetchType.LAZY.equals(oneToOne.fetch())) return true;

        final OneToMany oneToMany = field.getAnnotation(OneToMany.class);
        return null != oneToMany && FetchType.LAZY.equals(oneToMany.fetch());
    }

    private static boolean isCollection(final Class<?> entityClass) {
        return Collection.class.isAssignableFrom(entityClass);
    }

    private static boolean isList(final Class<?> entityClass) {
        return List.class.isAssignableFrom(entityClass);
    }
}
