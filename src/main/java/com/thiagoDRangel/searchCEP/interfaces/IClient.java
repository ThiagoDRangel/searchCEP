package com.thiagoDRangel.searchCEP.interfaces;

import com.thiagoDRangel.searchCEP.models.Cliente;

public interface IClient {
    Iterable<Cliente> getAll();

    Cliente findById(Long id);
    void create(Cliente client);

    void update(Long id, Cliente client);

    void delete(Long id);
}
