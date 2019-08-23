package com.fy.cms.Mapper;

import com.fy.cms.Entity.SysRole;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

/**
 * 〈〉
 *
 * @author fangyan
 * @create 2019/8/22
 * @since 1.0.0
 */
public class SysRoleMapperTest {
    private static SysRoleMapper mapper;

    @BeforeClass
    public static void setUpMybatisDatabase() {
        SqlSessionFactory builder = new SqlSessionFactoryBuilder().build(SysRoleMapperTest.class.getClassLoader().getResourceAsStream("mybatisTestConfiguration/SysRoleMapperTestConfiguration.xml"));
        //you can use builder.openSession(false) to not commit to database
        mapper = builder.getConfiguration().getMapper(SysRoleMapper.class, builder.openSession(true));
    }

    @Test
    public void testFindByAll() throws FileNotFoundException {
        mapper.findByAll(null).forEach(sysRole -> System.out.println(sysRole.toString()));
    }

    @Test
    public void testInsertSelective() throws FileNotFoundException {
        SysRole sysRole = new SysRole();
        sysRole.setId(new BigDecimal(1072806379238068229L));
        sysRole.setName("研发部");
        sysRole.setDescription("核心部门");
        Instant instant = Instant.now();
        sysRole.setCreateTime(Date.from(instant));
        int i = mapper.insertSelective(sysRole);
        if (i > 0) {
            System.out.println(i + "数据成功插入，部门名称：" + sysRole.getName());
        } else {
            System.out.println("插入失败");
        }
    }
}
