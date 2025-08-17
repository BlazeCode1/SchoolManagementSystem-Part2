package org.example.schoolmanagementsystem.Repository;

import org.example.schoolmanagementsystem.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {

    Address findAddressById(Integer id);
}
