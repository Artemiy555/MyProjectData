package web.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;
import javax.servlet.Servlet;

@Configuration
@ConditionalOnClass({Servlet.class})
public class VelocityConfig {



}
