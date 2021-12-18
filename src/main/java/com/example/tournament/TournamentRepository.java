package com.example.tournament;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "tournaments", path = "tournaments")
public interface TournamentRepository extends PagingAndSortingRepository<Tournament, Long> {

    List<Tournament> findByHeading(@Param("heading") String heading);
    //TODO: Convert startDate to proper date type.
    List<Tournament> findByStartDate(@Param("startDate") String startDate);
    //TODO: Convert endDate to proper date type.
    List<Tournament> findByEndDate(@Param("endDate") String endDate);
    List<Tournament> findByLocation(@Param("location") String location);
    List<Tournament> findByFee(@Param("fee") Double fee);
    List<Tournament> findByPrize(@Param("prize") Double prize);
    List<Tournament> findByStandings(@Param("standings") String standings);
    List<Tournament> findByStatus(@Param("status") String status);
}

/*
  Sample JSON object for creating a new Tournamnet object in Postman

  {
      "heading": "Tourney #1",
      "startDate": "Today",
      "endDate": "Tomorrow",
      "location": "Everywhere",
      "fee": 12.50,
      "prize": 100.00,
      "status": "Open"
  }
 */
