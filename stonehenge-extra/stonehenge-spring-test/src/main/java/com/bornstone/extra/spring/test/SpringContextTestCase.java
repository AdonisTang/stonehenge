package com.bornstone.extra.spring.test;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * Spring的支持依赖注入的JUnit4 集成测试基类, 相比Spring原基类名字更短.
 * <p/>
 * 子类需要定义applicationContext文件的位置,如:
 *
 * @author calvin
 * @ContextConfiguration(locations = { "/applicationContext-test.xml" })
 */
@ActiveProfiles(Profiles.UNIT_TEST)
public abstract class SpringContextTestCase extends AbstractJUnit4SpringContextTests {
}
