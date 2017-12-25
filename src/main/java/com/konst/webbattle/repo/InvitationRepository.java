
package com.konst.webbattle.repo;

import com.konst.webbattle.logic.Invitation;
import com.konst.webbattle.logic.User;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface InvitationRepository extends CrudRepository<Invitation, Integer>{
    
    @Query("SELECT i FROM Invitation i WHERE i.target=:user")
    List<Invitation> findUserInvitations(@Param("user") User user);
    
}
