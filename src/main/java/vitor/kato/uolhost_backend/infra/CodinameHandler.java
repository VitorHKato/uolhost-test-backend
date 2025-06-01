package vitor.kato.uolhost_backend.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vitor.kato.uolhost_backend.model.GroupType;
import vitor.kato.uolhost_backend.service.CodinameService;

@Component
public class CodinameHandler {

    @Autowired
    private CodinameService service;

    public String findCodiname(GroupType groupType) {
        if(groupType == GroupType.AVENGERS) {
            String firstMatch = this.service.getAvengersCodinameList().stream().findFirst().orElseThrow();
            this.service.getAvengersCodinameList().remove(firstMatch);
            return firstMatch;
        }
        String firstMatch = this.service.getJusticeLeagueCodinameList().stream().findFirst().orElseThrow();
        this.service.getJusticeLeagueCodinameList().remove(firstMatch);
        return firstMatch;
    }
}
