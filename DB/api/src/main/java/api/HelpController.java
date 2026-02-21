package api;

import com.logic.IntfHelpService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelpController {


    private final IntfHelpService intfHelpService;

    public HelpController(IntfHelpService intfHelpService) {
        this.intfHelpService = intfHelpService;
    }


    @GetMapping("/api/v1/help")
    public List<Integer> help() {
        System.out.println("HelpController: Received request for help endpoint");
        return intfHelpService.getHelpNumbers();
    }
}
