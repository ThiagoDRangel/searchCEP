package com.thiagoDRangel.searchCEP.repository;

import com.thiagoDRangel.searchCEP.models.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Endereco, String> {
}
