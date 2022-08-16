package service.impl;

import DAO.ISmartphoneRepository;
import model.SmartPhone;
import org.springframework.beans.factory.annotation.Autowired;
import service.ICRUDService;

import java.util.Optional;

public class SmartPhoneServiceImpl implements ICRUDService<SmartPhone> {
    @Autowired
    private ISmartphoneRepository iSmartphoneRepository;

    @Override
    public Iterable<SmartPhone> findAll() {
        return iSmartphoneRepository.findAll();
    }

    @Override
    public Optional<SmartPhone> findById(Long id) {
        return iSmartphoneRepository.findById(id);
    }

    @Override
    public void updateById(SmartPhone smartPhone) {
        iSmartphoneRepository.save(smartPhone);
    }

    @Override
    public void deleteById(Long id) {
        iSmartphoneRepository.deleteById(id);
    }

    @Override
    public SmartPhone save(SmartPhone smartPhone) {
       return iSmartphoneRepository.save(smartPhone);
    }
}
