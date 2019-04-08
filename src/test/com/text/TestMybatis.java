package com.text;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * @Author:linchengxin
 * @Date:2019/4/8 7:18
 */
public class TestMybatis {
        public void generator() throws Exception {

            List<String> warnings = new ArrayList<String>();
            boolean overwrite = true;
            //指定 逆向工程配置文件
            File configFile = new File("E:\\project\\IDEA\\Postgraduates\\src\\main\\resources\\generatorConfig.xml");
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(configFile);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
                    callback, warnings);
            myBatisGenerator.generate(null);

        }

        public static void main(String[] args) throws Exception {
            try {
                TestMybatis generatorSqlmap = new TestMybatis();
                generatorSqlmap.generator();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
}
