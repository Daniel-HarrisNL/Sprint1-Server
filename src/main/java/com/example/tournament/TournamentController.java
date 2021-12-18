package com.example.tournament;

import com.example.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TournamentController {

    @Autowired
    private TournamentRepository tournamentRepository;

    /**
     * Returns all Tournament objects from the table.
     *
     * @return      Query the table for all Tournament rows
     */
    @GetMapping("/tournaments")
    public Iterable<Tournament> getAllTournaments(){
        return tournamentRepository.findAll();
    }

    /**
     * Returns a Tournament object which has a matching id value.
     *
     * @param id    Value of type Long to query the table
     * @return      Query the table for the id
     */
    @GetMapping(path = "/tournaments/search", params = "id")
    public Optional<Tournament> getTournamentById(@RequestParam("id") Long id) {
        return tournamentRepository.findById(id);
    }

    /**
     * Returns a Tournament object which has a matching last name value.
     *
     * @param heading    Value of type String to query the table
     * @return           Query the table for the heading
     */
    @GetMapping(path = "/tournaments/search", params = "heading")
    public List<Tournament> getTournamentByHeading(@RequestParam("heading") String heading) {
        return tournamentRepository.findByHeading(heading);
    }

    /**
     * Returns a Tournament object which has a matching start date value.
     *
     * @param startDate    Value of type String to query the table
     * @return             Query the table for the start date
     */
    @GetMapping(path = "/tournaments/search", params = "startDate")
    public List<Tournament> getTournamentByStartDate(@RequestParam("startDate") String startDate) {
        return tournamentRepository.findByStartDate(startDate);
    }//TODO: Convert startDate to proper date type.

    /**
     * Returns a Tournament object which has a matching end date value.
     *
     * @param endDate    Value of type String to query the table
     * @return           Query the table for the address
     */
    @GetMapping(path = "/tournaments/search", params = "endDate")
    public List<Tournament> getTournamentByEndDate(@RequestParam("endDate") String endDate) {
        return tournamentRepository.findByEndDate(endDate);
    }//TODO: Convert endDate to proper date type.

    /**
     * Returns a Tournament object which has a matching location.
     *
     * @param location    Value of type String to query the table
     * @return            Query the table for the location
     */
    @GetMapping(path = "/tournaments/search", params = "location")
    public List<Tournament> getTournamentByLocation(@RequestParam("location") String location) {
        return tournamentRepository.findByLocation(location);
    }

    /**
     * Returns a Tournament object which has a matching fee.
     *
     * @param fee    Value of type String to query the table
     * @return       Query the table for the fee
     */
    @GetMapping(path = "/tournaments/search", params = "fee")
    public List<Tournament> getTournamentByFee(@RequestParam("fee") Double fee) {
        return tournamentRepository.findByFee(fee);
    }

    /**
     * Returns a Tournament object which has a matching prize value.
     *
     * @param prize    Value of type Double to query the table
     * @return         Query the table for the prize
     */
    @GetMapping(path = "/tournaments/search", params = "prize")
    public List<Tournament> getTournamentByPrize(@RequestParam("prize") Double prize) {
        return tournamentRepository.findByPrize(prize);
    }

    //TODO: Implement Get request to retrieve tournament standings for a specified tournament.

    /**
     * Returns a Tournament object which has a matching status.
     *
     * @param status    Value of type String to query the table
     * @return          Query the table for the status
     */
    @GetMapping(path = "/tournaments/search", params = "status")
    public List<Tournament> getTournamentByStatus(@RequestParam("status") String status) {
        return tournamentRepository.findByStatus(status);
    }

    /**
     * Inserts a Tournament object as a new row in the 'tournament' table
     * of the MySQL server defined in 'application.properties'.
     *
     * @param tournament    Tournament JSON object containing fields for all table columns
     * @return              Save the Tournament object into the table
     */
    @PostMapping("/tournaments/add")
    public Tournament createTournament(@RequestBody Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    /**
     * Updates a Tournament object with new data if it is found by its id.
     *
     * @param tournament Tournament JSON object containing the new fields for the old tournament
     * @param id     ID of the tournament to be updated
     * @return       Save the updated Tournament object into the table
     */
    @PutMapping(path = "/tournaments/update", params = "id")
    public Optional<Tournament> updateTournamentById(@RequestBody Tournament tournament, @RequestParam Long id) {
        return tournamentRepository.findById(id).map(storedTournament -> {
            storedTournament.setHeading(tournament.getHeading());
            storedTournament.setStartDate(tournament.getStartDate());
            storedTournament.setEndDate(tournament.getEndDate());
            storedTournament.setLocation(tournament.getLocation());
            storedTournament.setFee(tournament.getFee());
            storedTournament.setPrize(tournament.getPrize());
            storedTournament.setStandings(tournament.getStandings());
            storedTournament.setStatus(tournament.getStatus());
            return tournamentRepository.save(storedTournament);
        });
    }

    /**
     * Delete a tournament by its ID
     *
     * @param id The ID of the tournament to be deleted
     */
    @DeleteMapping(path = "/tournaments/delete", params = "id")
    public void deleteTournamentById(@RequestParam("id") long id) {
        tournamentRepository.deleteById(id);
    }
}
