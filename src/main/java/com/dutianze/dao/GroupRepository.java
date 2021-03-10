package com.dutianze.dao;

import com.dutianze.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author dutianze
 */
public interface GroupRepository extends JpaRepository<Group, Long> {

    /**
     * findByName
     *
     * @param name name
     * @return Group
     */
    Group findByName(String name);

    /**
     * findAllByUserId
     *
     * @param id id
     * @return List<Group>
     */
    List<Group> findAllByUserId(String id);
}
