package jm.service;

import jm.dao.RoleRepository;
import jm.model.Role;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;

    public RoleServiceImpl(RoleRepository repository) {

        this.repository = repository;
    }

    @Override
    public void save(Role role) {
        repository.save(role);
    }

    @Override
    public Role findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<Role> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void update(Role role) {
        repository.save(role);
    }
}
