package org.gestion.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories({"org.gestion.repository"})
@Import({DataSourceMySQLConfig.class})
public class JpaConfig {

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(emf);
		return txManager;
	}

	/**
	 * Cette configuration nécessite une source de données configurée. Elle s'utilise donc en association avec un autre
	 * fichier de configuration définissant un bean DataSource.
	 */
	@Bean
	public EntityManagerFactory entityManagerFactory(DataSource dataSource) {

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);
		// activer les logs SQL
		vendorAdapter.setShowSql(true);

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		// alternative au persistence.xml
		factory.setPackagesToScan("org.gestion.entite");
		factory.setDataSource(dataSource);

		Properties jpaProperties = new Properties();
		//jpaProperties.setProperty("javax.persistence.schema-generation.database.action", "drop-and-create");
		jpaProperties.setProperty("javax.persistence.schema-generation.database.action", "update");
		factory.setJpaProperties(jpaProperties);

		factory.afterPropertiesSet();
		return factory.getObject();
	}
}
