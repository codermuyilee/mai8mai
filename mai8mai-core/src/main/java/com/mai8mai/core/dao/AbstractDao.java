package com.mai8mai.core.dao;

import com.mai8mai.core.dao.model.BaseModel;
import com.mai8mai.core.dao.util.ValidatorHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

/**
 *
 * @param <T>
 */
public class AbstractDao<T extends BaseModel> {
	private static final Logger logger = LoggerFactory.getLogger(AbstractDao.class);
	private Class<T> entityClass;

	protected Class<T> getEntityClass() {
		return entityClass;
	}

	@PersistenceContext
	private EntityManager entityManager;
	private Validator validator;

	public AbstractDao(Class<T> entityClass) {
		this.entityClass = entityClass;
		validator = ValidatorHelper.getValidator();
	}

	protected T beforeOperation(T t) throws Exception {
		return t;
	}

	protected T afterCreateOperation(T t) throws Exception {
		logger.info("afterCreateOperation executed!");
		return t;
	}

	protected T afterEditOperation(T t) throws Exception {
		logger.info("afterEditOperation executed!");
		return t;
	}

	/**
	 * 创建一个实体
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void create(T entity) throws Exception {
		if (entity == null) {
			logger.debug("method create : NULL can not be created");
			return;
		}
		try {
			// 数据验证
			validate(entity);
			// 创建前预处理
			entityManager.persist(beforeOperation(entity));
			entityManager.flush();
			// 创建后业务处理
			afterCreateOperation(entity);
			logger.debug("method create : Persist {} success", entityClass);
		} catch (Exception e) {
			logger.error("method create : Persist {} failure. The exception is {}", entityClass, e);
			throw e;
		}
	}

	/**
	 * 根据ID修改一个实体
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void edit(T entity) throws Exception {
		if (entity == null) {
			logger.debug("method edit : Null can not be edited");
		}
		try {
			// 数据验证
			validate(entity);
			// 修改前预处理
			entityManager.merge(beforeOperation(entity));
			// 创建后业务处理
			afterEditOperation(entity);
			logger.debug("method edit : Merge {} success,ID:{}", entityClass, entity.getId());
		}  catch (Exception e) {
			logger.error("method edit : Merge {} failure,ID:{},The exception is {}", entityClass, entity.getId(), e);
			throw e;
		}
	}
	
	public void editWithoutMessage(T entity) throws Exception {
		if (entity == null) {
			logger.debug("method edit : Null can not be edited");
		}
		try {
			// 数据验证
			validate(entity);
			// 修改前预处理
			entityManager.merge(beforeOperation(entity));
			logger.debug("method edit : Merge {} success,ID:{}", entityClass, entity.getId());
		} catch (Exception e) {
			logger.error("method edit : Merge {} failure,ID:{},The exception is {}", entityClass, entity.getId(), e);
			throw e;
		}
	}
	
	/**
	 * 根据ID删除一个实体
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void remove(Long id) throws Exception {
		try {
			if (null == id)
				return;
			T targetEntity = entityManager.find(entityClass, id);
			if (null == targetEntity) {
				throw new Exception("The entity of id : " + id + " does not exist");
			} else {
				entityManager.remove(targetEntity);

				logger.debug("Remove {} success,ID:{}", entityClass, id);
			}
		} catch (Exception e) {
			logger.debug("Remove {} failure,ID:{},Exception{}", entityClass, id, e.getMessage());
			throw e;
		}
	}

	/**
	 * 根据ID查找一个实体
	 * 
	 * @param id
	 * @return
	 */
	public T find(Object id) {
		if (id == null) {
			logger.debug("method find : Can not find an object by NULL");
			return null;
		}
		T t = entityManager.find(entityClass, id);
		return t;
	}

	/**
	 *
	 * @param entity
	 * @throws Exception
	 */
	private void validate(T entity) throws Exception {
		// 数据验证后的错误信息集合
		Set<ConstraintViolation<T>> errors = validator.validate(entity);
		if (errors != null && !errors.isEmpty()) {
			StringBuffer errorMessage = new StringBuffer();
			for (ConstraintViolation<T> error : errors) {
				errorMessage.append(error.getMessage());
				errorMessage.append(";");
			}
			Exception ex = new Exception(errorMessage.toString());
			throw ex;
		}
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
