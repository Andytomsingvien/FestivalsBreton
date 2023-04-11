package fr.simplon.festivalsbreton.festivalsbreton;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.simplon.festivalsbreton.festivalsbreton.dao.impl.FestivalRepository;
import fr.simplon.festivalsbreton.festivalsbreton.entity.Festival;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class DataLoader implements ApplicationRunner {

        private final FestivalRepository mFestivalRepository;
 @Autowired
 public DataLoader(FestivalRepository pFestivalRepository)
        {
            this.mFestivalRepository = pFestivalRepository;
        }
        @Override
        public void run(ApplicationArguments args) throws Exception
        {
            if (mFestivalRepository.count() == 0)
            {
                ClassPathResource resource = new ClassPathResource("static/festivals.json");
                ObjectMapper objectMapper = new ObjectMapper();
                List<Festival> festivals = objectMapper.readValue(
                        resource.getInputStream(), new TypeReference<List<Festival>>(){});
                mFestivalRepository.saveAll(festivals);
            }
        }

    }
