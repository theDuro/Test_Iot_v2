package pl.edu.pwsztar.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.edu.pwsztar.domain.dto.CreateComandDto;
import pl.edu.pwsztar.service.serviceImpl.ComandService;

@Component
public class DataLoader implements CommandLineRunner {

    private final ComandService comandService;

    public DataLoader(ComandService comandService) {
        this.comandService = comandService;
    }


    @Override
    public void run(String... args) {

        CreateComandDto comand1 = new CreateComandDto(1.0F, 2.0F, 3.0F, 2L);
        CreateComandDto comand2 = new CreateComandDto(4.0F, 1.0F, 1.2F, 1L);
        CreateComandDto comand3 = new CreateComandDto(3.0F, 1.0F, 3.3F, 1L);
        comandService.addComand(comand1);
        comandService.addComand(comand2);
        comandService.addComand(comand3);
    }
}
