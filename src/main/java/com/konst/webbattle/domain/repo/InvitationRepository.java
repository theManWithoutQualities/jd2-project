
package com.konst.webbattle.domain.repo;

import com.konst.webbattle.domain.model.Invitation;
import com.konst.webbattle.domain.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface InvitationRepository extends CrudRepository<Invitation, Integer>{
    
    @Query("SELECT i FROM Invitation i WHERE i.target=:user")
    List<Invitation> findUserInvitations(@Param("user") User user);
    
}
