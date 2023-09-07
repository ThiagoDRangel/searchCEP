package com.thiagoDRangel.searchCEP.services;

import com.thiagoDRangel.searchCEP.interfaces.IClient;
import com.thiagoDRangel.searchCEP.interfaces.IViaCep;
import com.thiagoDRangel.searchCEP.models.Endereco;
import com.thiagoDRangel.searchCEP.models.Cliente;
import com.thiagoDRangel.searchCEP.repository.AddressRepository;
import com.thiagoDRangel.searchCEP.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService implements IClient {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private IViaCep viaCep;

    @Override
    public Iterable<Cliente> getAll() {
        return clientRepository.findAll();
    }
    @Override
    public Cliente findById(Long id) {
        Optional<Cliente> client = clientRepository.findById(id);
        return client.get();
    }

    @Override
    public void create(Cliente client) {

        saveDataDB(client);
    }

    @Override
    public void update(Long id, Cliente client) {
        Optional<Cliente> clientDB = clientRepository.findById(id);

        if ( clientDB.isPresent()) {
            saveDataDB(client);
        }
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    private void saveDataDB(Cliente client) {
        String cep = client.getEndereco().getCep();
        Endereco address = addressRepository.findById(cep).orElseGet(() -> {
            Endereco newAddress = viaCep.searchCep(cep);
            addressRepository.save(newAddress);
            return newAddress;
        });
        client.setEndereco(address);
        clientRepository.save(client);
    }
}
