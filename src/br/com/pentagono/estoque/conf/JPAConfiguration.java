package br.com.pentagono.estoque.conf;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
public class JPAConfiguration {

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

		LocalContainerEntityManagerFactoryBean managerFactory = new LocalContainerEntityManagerFactoryBean();
		managerFactory.setDataSource(dataSource());
		managerFactory.setPackagesToScan(new String[] { "br.com.pentagono.estoque.models" });
		
		JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		
		managerFactory.setJpaVendorAdapter(adapter);
		managerFactory.setJpaProperties(propriedadesAdicionais());
		return managerFactory;
	}

	@Bean
	public Properties propriedadesAdicionais() {
		
		/* 
		 * hibernate.hbm2ddl.auto
		 * 
		 * validate: Valida o Schema mas n�o modifica nada
         * update: Cria/atualiza o banco de dados.
         * create: recria o schema, perdendo os dados.
         * create-drop: Dropa tudo quando a sess�o da factory for finalizada, normalmente quando a aplica��o � encerrada.		
         */
		
		Properties props = new Properties();
		props.setProperty("hibernate.hbm2ddl.auto", "update");
		props.setProperty("hibernate.show_sql", "true");
		return props;
	}

	@Bean
	public DataSource dataSource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/estoque");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres");		
		
		return dataSource;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}	
}
