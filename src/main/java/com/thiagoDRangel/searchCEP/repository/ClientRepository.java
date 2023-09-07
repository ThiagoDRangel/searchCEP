package com.thiagoDRangel.searchCEP.repository;

import com.thiagoDRangel.searchCEP.models.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Cliente, Long> {

}
