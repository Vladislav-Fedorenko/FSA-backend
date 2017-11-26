package topLevelDomain.secondLevelDomain.homeneeds.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {
  @Bean
  @Qualifier("dataSource")
  @ConfigurationProperties(prefix = "spring.datasource")
  @FlywayDataSource
  public DataSource dataSource() {
    return DataSourceBuilder.create().build();
  }

/*  @Bean
  @Qualifier("jdbcTemplate")
  public JdbcTemplate jdbcTemplate(@Qualifier("dataSource") DataSource dataSource) {
    return new JdbcTemplate(dataSource);
  }*/

}
