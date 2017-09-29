package common.classUtil.annotationClass.Dao;

public interface IDao<T> {
	
	public abstract void save(final T entity);
	
	public abstract void find(final T entity);
}
