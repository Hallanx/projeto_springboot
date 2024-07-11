/**
 * 
 */
package Alan.vendas.onlineconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author alan.vaz
 *
 */
@Configuration
@EnableMongoRepositories(basePackages = "alan.vendas.online.repository")
public class MongoConfig {

}
