package com.netcracker.dao;

import com.netcracker.models.User;

import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

public interface UserDao {
    public User createUser(User user);

    public User getUserById(BigInteger id);

    public User getUserByLogin(String login);

    public void updateUserPasswordById(BigInteger id, String newPassword);

    public Collection<User> getAllUsersByFamilyAccountId( BigInteger familyId);



    String CREATE_USER = "INSERT ALL  "  +
            "INTO OBJECTS (OBJECT_ID,PARENT_ID,OBJECT_TYPE_ID,NAME,DESCRIPTION) VALUES (objects_id_s.NEXTVAL,NULL,1,?,NULL) "
            +""+
            "SELECT * " +
            "FROM Dual";;

    String GET_USER_BY_USER_ID = "SELECT  ";


    String FIND_USER_BY_LOGIN = "SELECT  ";


    String UPDATE_PASSWORD = "UPDATE ATTRIBUTES " +
            "SET ATTRIBUTES.VALUE = ? " +
            "WHERE ATTRIBUTES.OBJECT_ID = ? AND " +
            "ATTRIBUTES.ATTR_ID = 4";


    String GET_ALL_USER_BY_FAMILY_ACC_ID = "";

    String GET_USER_BY_FAMILY_ACC_ID = "";


}
