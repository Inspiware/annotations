package org.inspiware.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Api(status = Api.Status.EVOLVING)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
public @interface Api {

    /**
     * The current {@linkplain Status status} of the API.
     */
    Status status();

    /**
     * The version of the API when the current {@link #status} was last changed.
     *
     * <p>Default to an empty string</p>
     */
    String since() default "";


    enum Status {
        /**
         * Annotation for marking methods within public stable classes as internal developer API.
         * <p>
         */
        INTERNAL,

        /**
         * Annotation for marking classes and methods public, but with evolving features.
         * <p>
         * <p>Classes and methods with this annotation are stable
         * across m releases.
         */
        EVOLVING,

        /**
         * Annotation for marking classes public, stable interfaces.
         * <p>
         * <p>Classes with this annotation are stable across major and minor releases.
         */
        PUBLIC,

        /**
         * Support for the API is removed and the implementation will be removed in
         * the upcoming versions.
         */
        DEPRECATED;
    }
}
