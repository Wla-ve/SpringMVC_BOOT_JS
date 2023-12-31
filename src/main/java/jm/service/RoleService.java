package jm.service;

import jm.model.Role;

import java.util.List;

public interface RoleService {
    public void save(Role role);

    public Role findByName(String name);

    public List<Role> findAll();

    public void deleteById(Long id);

    public void update(Role role);
}
