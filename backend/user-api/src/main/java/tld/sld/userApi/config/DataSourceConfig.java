package tld.sld.userApi.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {
    @Bean
    @Qualifier("dataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    @FlywayDataSource
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }
}
