package com.examplespringboot.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

// load đầu tiên khi chạy chương trình
@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "customersEntityManager",
        transactionManagerRef = "customersTransactionManager",
        basePackages = {Constants.PACKAGE_REPOSITORY}
)
// nguồn thuộc tính để tạo environment
@PropertySource("classpath:application.properties")
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.examplespringboot.demo.aspect")
public class AppConfig {

    // bean chứa các thuộc tính trong file applocation.properties
    @Autowired
    private Environment environment;

    // config dataSource = kết nối đến csdl
    @Bean("customersDataSource")
    public DataSource getDataSourceMysql() {
        DataSourceBuilder dataSource = DataSourceBuilder.create();
        dataSource.url(environment.getProperty("spring.datasource.url"));
        dataSource.username("root");
        dataSource.password(environment.getProperty("spring.datasource.password"));
        return dataSource.build();
    }

    @Bean(name = "customersEntityManager")
    public LocalContainerEntityManagerFactoryBean getCustomersEntityManager(
            EntityManagerFactoryBuilder builder, @Qualifier("customersDataSource") DataSource customersDataSource){
        // config bean entity của data base tương đương với bảng, config jpa
        LocalContainerEntityManagerFactoryBean result = builder
                .dataSource(customersDataSource)
                .packages(Constants.PACKAGE_ENTITIES)
                .persistenceUnit("customers")
                .properties(additionalJpaProperties())
                .build();
        return result;
    }

    Map<String,?> additionalJpaProperties(){
        Map<String,String> map = new HashMap<>();
        map.put("hibernate.hbm2ddl.auto", environment.getProperty("spring.jpa.hibernate.ddl-auto"));
        map.put("hibernate.show_sql", environment.getProperty("spring.jpa.show-sql"));
        return map;
    }

    @Bean(name = "customersTransactionManager")
    public JpaTransactionManager transactionManager(@Qualifier("customersEntityManager") EntityManagerFactory customersEntityManager){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(customersEntityManager);
        return transactionManager;
    }

}
