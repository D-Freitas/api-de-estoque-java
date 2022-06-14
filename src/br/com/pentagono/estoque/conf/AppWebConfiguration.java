package br.com.pentagono.estoque.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.pentagono.estoque.controllers.HomeController;
import br.com.pentagono.estoque.converters.StringToFornecedorConverter;
import br.com.pentagono.estoque.daos.ProdutoDAO;
import br.com.pentagono.estoque.utils.ArquivoUtils;

@EnableWebMvc
@ComponentScan(basePackageClasses = { HomeController.class, ProdutoDAO.class, StringToFornecedorConverter.class, ArquivoUtils.class })
public class AppWebConfiguration implements WebMvcConfigurer {

	@Autowired
	private StringToFornecedorConverter stringToFornecedorConverter;

	@Bean
	public InternalResourceViewResolver viewResolver() {

		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("/WEB-INF/views/");
		vr.setSuffix(".jsp");
		return vr;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("/WEB-INF/static/");
		registry.addResourceHandler("/media/**").addResourceLocations("file://" + ArquivoUtils.DIRETORIO_BASE);
	}

	@Bean
	public MessageSource messageSource() {

		ReloadableResourceBundleMessageSource bundle = new ReloadableResourceBundleMessageSource();
		bundle.setBasename("/WEB-INF/messages");
		bundle.setDefaultEncoding("UTF-8");
		bundle.setCacheSeconds(1);
		return bundle;
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(stringToFornecedorConverter);
	}

	@Bean
	public MultipartResolver multipartResolver() {
		return new StandardServletMultipartResolver();
	}

}