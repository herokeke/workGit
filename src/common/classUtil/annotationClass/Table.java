package common.classUtil.annotationClass;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.persistence.UniqueConstraint;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)  // 运行时加载。可以将注解信息编译到class文件中，并可以通过反射获取信息。
@Documented
@Inherited // 只适用于继承关系，只能继承类上的注解。
public @interface Table {
	
	String name() default "";

	String catalog() default "";

	String schema() default "";

	UniqueConstraint[] uniqueConstraints() default { };
}
