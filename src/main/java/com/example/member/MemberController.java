package com.example.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MemberController {
    //https://howtodoinjava.com/spring5/webmvc/controller-getmapping-postmapping/
    //https://www.javaguides.net/2018/09/spring-boot-2-hibernate-5-mysql-crud-rest-api-tutorial.html

    @Autowired
    private MemberRepository memberRepository;

    /**
     * Returns all Member objects from the table.
     *
     * @return      Query the table for all Member rows
     */
    @GetMapping("/members")
    public Iterable<Member> getAllMembers(){
        return memberRepository.findAll();
    }

    /**
     * Returns a Member object which has a matching id value.
     *
     * @param id    Value of type Long to query the table
     * @return      Query the table for the id
     */
    @GetMapping(path = "/members/search", params = "id")
    public Optional<Member> getMemberById(@RequestParam("id") Long id) {
        return memberRepository.findById(id);
    }

    /**
     * Returns a Member object which has a matching last name value.
     *
     * @param lastName    Value of type String to query the table
     * @return            Query the table for the name
     */
    @GetMapping(path = "/members/search", params = "lname")
    public List<Member> getMemberByLastName(@RequestParam("lname") String lastName) {
        return memberRepository.findByLastName(lastName);
    }

    /**
     * Returns a Member object which has a matching first name value.
     *
     * @param firstName    Value of type String to query the table
     * @return             Query the table for the name
     */
    @GetMapping(path = "/members/search", params = "fname")
    public List<Member> getMemberByFirstName(@RequestParam("fname") String firstName) {
        return memberRepository.findByFirstName(firstName);
    }

    /**
     * Returns a Member object which has a matching address value.
     *
     * @param address    Value of type String to query the table
     * @return           Query the table for the address
     */
    @GetMapping(path = "/members/search", params = "address")
    public List<Member> getMemberByAddress(@RequestParam("address") String address) {
        return memberRepository.findByAddress(address);
    }

    /**
     * Returns a Member object which has a matching email address value.
     *
     * @param email    Value of type String to query the table
     * @return         Query the table for the email address
     */
    @GetMapping(path = "/members/search", params = "email")
    public List<Member> getMemberByEmail(@RequestParam("email") String email) {
        return memberRepository.findByEmail(email);
    }

    /**
     * Returns a Member object which has a matching phone number.
     *
     * @param phone    Value of type String to query the table
     * @return         Query the table for the phone number
     */
    @GetMapping(path = "/members/search", params = "phone")
    public List<Member> getMemberByPhone(@RequestParam("phone") String phone) {
        return memberRepository.findByPhone(phone);
    }

    /**
     * Returns a Member object which has a matching start date value.
     *
     * @param startDate    Value of type String to query the table
     * @return             Query the table for the start date
     */
    @GetMapping(path = "/members/search", params = "start")
    public List<Member> getMemberByStartDate(@RequestParam("start") String startDate) {
        return memberRepository.findByStartDate(startDate);
    }//TODO: Convert startDate to proper date type.

    //TODO: Add getMemberByDuration method.

    /**
     * Returns a Member object which has a matching membership value.
     *
     * @param membership    Value of type String to query the table
     * @return              Query the table for the membership type
     */
    @GetMapping(path = "/members/search", params = "type")
    public List<Member> getMemberByMembership(@RequestParam("type") String membership) {
        return memberRepository.findByMembership(membership);
    }

    /**
     * Inserts a Member object as a new row in the 'member' table
     * of the MySQL server defined in 'application.properties'.
     *
     * @param member    Member JSON object containing fields for all table columns
     * @return          Save the Member object into the table
     */
    @PostMapping("/members/add")
    public Member createMember(@RequestBody Member member) {
        return memberRepository.save(member);
    }

    /**
     * Updates a Member object with new data if it is found by its id.
     *
     * @param member Member JSON object containing the new fields for the old member
     * @param id     ID of the member to be updated
     * @return       Save the updated Member object into the table
     */
    @PutMapping(path = "/members/update", params = "id")
    public Optional<Member> updateMemberById(@RequestBody Member member, @RequestParam("id") long id) {
        return memberRepository.findById(id).map(storedMember -> {
            storedMember.setFirstName(member.getFirstName());
            storedMember.setLastName(member.getLastName());
            storedMember.setAddress(member.getAddress());
            storedMember.setEmail(member.getEmail());
            storedMember.setPhone(member.getPhone());
            storedMember.setStartDate(member.getStartDate());
            storedMember.setDuration(member.getDuration());
            storedMember.setMembership(member.getMembership());
            return memberRepository.save(storedMember);
        });
    }

    /**
     * Delete a member by its ID
     *
     * @param id The ID of the member to be deleted
     */
    @DeleteMapping(path = "/members/delete", params = "id")
    public void deleteMemberById(@RequestParam("id") long id) {
        memberRepository.deleteById(id);
    }

    //TODO: Add @PostMapping route to register a member to a tournament by their id's.

    //TODO: Add @DeleteMapping route to un-register a member from a tournament by their id's.

    //TODO: Add @GetMapping route to view all tournaments that a member is registered, by their id.

    //TODO: Add @GetMapping route to view all members registered to a tournament, by it's id.
}
