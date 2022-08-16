package service.impl;

import DAO.IProvinceRepository;
import model.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import service.ICRUDService;
import service.IProvinceService;

import java.util.Optional;

public class ProvinceServiceImpl implements IProvinceService {
    @Autowired
    IProvinceRepository provinceRepository;

    @Override
    public Iterable<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public Optional<Province> findById(Long id) {
        return provinceRepository.findById(id);
    }

    @Override
    public void updateById(Province province) {
        provinceRepository.save(province);
    }

    @Override
    public void deleteById(Long id) {
provinceRepository.deleteById(id);
    }

    @Override
    public Province save(Province province) {
        return provinceRepository.save(province);
    }
    @Override
    public Iterable<Province> findProvinceOrderByGDPAsc(){
        return provinceRepository.findAllOrderByGDPAsc();
    }
}
