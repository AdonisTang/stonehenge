//package com.bornstone.extra.spring.test.testutils;
//
//import com.bornstone.stonehenge.entity.BaseEntity;
//import org.apache.log4j.Logger;
//
///**
// * BaseManagerTest.java
// *
// * @author King<br/>
// *         email:my249645546@163.com
// * @Description ManagerTest 抽象类
// * @Date 2012-12-17下午4:55:08
// * @since 1.0.0
// */
//public abstract class AbstractBaseManagerTest<PK extends Number, T extends BaseEntity<PK>> extends DBUnitTestUtils<T> {
//    private static final Logger logger = Logger.getLogger(AbstractBaseManagerTest.class);
//
////	/**
////	 *
////	 * @Description:获取Manager
////	 * @since 1.0.0
////	 * @Date:2012-12-17 下午5:04:09
////	 * @return
////	 * AbstractBaseManager<PK,T>
////	 */
////	public abstract AbstractManager<PK, T> getManager();
////
////	/**
////	 *
////	 * @Description:获得添加结果
////	 * @since 1.0.0
////	 * @Date:2012-12-17 下午5:18:24
////	 * @param instance
////	 * @return
////	 * int
////	 */
////	protected int getAddResult(T instance) {
////		int result = 0;
////		try {
////			result = getManager().add(instance);
////		} catch (ManagerException e) {
////			logger.error(e.getMessage(), e);
////		}
////		return result;
////	}
////
////	/**
////	 *
////	 * @Description:获得修改结果
////	 * @since 1.0.0
////	 * @Date:2012-12-17 下午5:18:37
////	 * @param instance
////	 * @return
////	 * int
////	 */
////	protected int getModifyResult(T instance) {
////		int result = 0;
////		try {
////			result = getManager().modify(instance);
////		} catch (ManagerException e) {
////			logger.error(e.getMessage(), e);
////		}
////		return result;
////	}
//}
