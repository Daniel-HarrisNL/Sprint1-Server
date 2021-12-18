package com.example.member;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "members", path = "members")
public interface MemberRepository extends PagingAndSortingRepository<Member, Long> {

    //TODO: Check if the findById method below is redundant (built-in findById
    // possibly sufficient).
//  List<Member> findById(@Param("id") long id);
    List<Member> findByLastName(@Param("lastName") String lastName);
    List<Member> findByFirstName(@Param("firstname") String firstName);
    List<Member> findByAddress(@Param("address") String address);
    List<Member> findByEmail(@Param("email") String email);
    List<Member> findByPhone(@Param("phone") String phone);
    //TODO: Convert startDate to proper date type.
    List<Member> findByStartDate(@Param("startDate") String startDate);
    //TODO: Calculate date duration after startDate is converted to proper date type.
    List<Member> findByDuration(@Param("duration") String duration);
    List<Member> findByMembership(@Param("membership") String membership);
}

/*
  Sample JSON object for creating a new Member object in Postman

  {
      "firstName": "Daniel",
      "lastName": "Harris",
      "address": "Here",
      "email": "test@test",
      "phone": "911",
      "startDate": "Now",
      "duration": "Long",
      "membership": "Free"
  }
 */
