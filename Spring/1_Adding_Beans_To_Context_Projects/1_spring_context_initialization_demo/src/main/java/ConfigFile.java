import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
public class ConfigFile {

    @Bean("carlos")
    public Player player1(){
       return new Player("Roberto Carlos","Football");
    }

    @Bean("dhino")
    public Player player2(){
        return new Player("Ronaldhino","Football");
    }

    @Bean
    public String football(){
        return "Siuu";
    }

    @Bean
    public int ronaldo(){
        return 7;
    }
}
