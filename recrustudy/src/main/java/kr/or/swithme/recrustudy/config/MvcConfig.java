package kr.or.swithme.recrustudy.config;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"kr.or.swithme.recrustudy.controller"})
public class MvcConfig implements WebMvcConfigurer {

	// default servlet 핸들러를 설정한다.
	// 원래 서블릿은 / (모든 요청)을 처리하는 default servlet을 제공한다. 스프링에서 설정한 path는 스프링이 처리하고, 스프링이 처리하지 못한 경로에 대한 처리는
	// 디폴트 서블릿에게 전달하여 처리하게 된다.
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	// Spring MVC에서 jsp view 가 위치하는 경로를 설정한다.
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/view/", ".jsp");
	}

        //    '/' 로 요청이 오면 '/main'으로 리다이렉트 하도록 합니다.
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/", "/main");
	}

        //  /resources 경로에 있는 자료들을 /resources/**로 접근하게 합니다.
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

		@Override
		public void configurePathMatch(PathMatchConfigurer configurer) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void addFormatters(FormatterRegistry registry) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void addInterceptors(InterceptorRegistry registry) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void addCorsMappings(CorsRegistry registry) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Validator getValidator() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public MessageCodesResolver getMessageCodesResolver() {
			// TODO Auto-generated method stub
			return null;
		}
}