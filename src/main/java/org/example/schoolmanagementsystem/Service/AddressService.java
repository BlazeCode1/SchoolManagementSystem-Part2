package org.example.schoolmanagementsystem.Service;

import lombok.RequiredArgsConstructor;
import org.example.schoolmanagementsystem.Api.ApiException;
import org.example.schoolmanagementsystem.DTO.AddressDTO;
import org.example.schoolmanagementsystem.Model.Address;
import org.example.schoolmanagementsystem.Model.Teacher;
import org.example.schoolmanagementsystem.Repository.AddressRepository;
import org.example.schoolmanagementsystem.Repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;
    public List<Address> getAddresses(){
        return addressRepository.findAll();
    }

    public void addAddress(AddressDTO addressDTO){
        Teacher teacher = teacherRepository.findTeacherById(addressDTO.getTeacher_id());
        if(teacher == null)
            throw new ApiException("Teacher Id Not found");
        Address address = new Address(null, addressDTO.getArea(), addressDTO.getStreet(), addressDTO.getBuildingNumber(),teacher );
        addressRepository.save(address);
    }

    public void updateAddress(AddressDTO addressDTO){
        Address oldAddress = addressRepository.findAddressById(addressDTO.getTeacher_id());
        if(oldAddress == null)
            throw new ApiException("Address Not Found");

        oldAddress.setArea(addressDTO.getArea());
        oldAddress.setStreet(addressDTO.getStreet());
        oldAddress.setBuildingNumber(addressDTO.getBuildingNumber());
        addressRepository.save(oldAddress);
    }

    public void deleteAddress(Integer id){
        Address address = addressRepository.findAddressById(id);
        if (address == null) {
            throw new ApiException("Address not found");
        }

        Teacher teacher = address.getTeacher();
        if (teacher != null) {
            teacher.setAddress(null);
            teacherRepository.save(teacher);
        }
        addressRepository.delete(address);
    }

}
