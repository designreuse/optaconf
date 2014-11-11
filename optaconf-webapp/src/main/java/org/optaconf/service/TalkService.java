package org.optaconf.service;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.optaconf.domain.Schedule;
import org.optaconf.domain.Talk;

@Path("/{conferenceId}/talk")
public class TalkService {

    @Inject
    private Schedule schedule;

    @GET
    @Path("/")
    @Produces("application/json")
    public List<Talk> getTalkList(@PathParam("conferenceId") Long conferenceId) {
        return schedule.getTalkList();
    }

}
