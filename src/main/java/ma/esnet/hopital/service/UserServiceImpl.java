package ma.esnet.hopital.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import ma.esnet.hopital.entities.Role;
import ma.esnet.hopital.entities.User;
import ma.esnet.hopital.repository.RoleRepository;
import ma.esnet.hopital.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private RoleRepository roleRepository;
    private UserRepository userRepository;

    @Override
    public User addNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {

        return roleRepository.save(role);
    }

    @Override
    public User findUserByUserName(String userName) {

        return userRepository.findByUsername(userName);
    }

    @Override
    public Role findRoleByName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {

        User user = findUserByUserName(userName);
        Role role = findRoleByName(roleName);
        if (user.getRoles() != null) {
            user.getRoles().add(role);
            role.getUsers().add(user);
        }
        //userRepository.save(user);

    }

    public User authenticate(String userName,String password) {
        User user=userRepository.findByUsername(userName);
        if (user==null) throw new RuntimeException("Bad credentials");
        if (user.getPassword().equals(password)){
            return  user;
        }
        throw new RuntimeException("Bad credentials");

    }
    }
