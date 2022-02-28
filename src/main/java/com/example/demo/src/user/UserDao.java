package com.example.demo.src.user;


import com.example.demo.src.user.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<GetUserRes> getUsers(){
        String getUsersQuery = "select * from User";
        return this.jdbcTemplate.query(getUsersQuery,
                (rs,rowNum) -> new GetUserRes(
                        rs.getInt("userIdx"),
                        rs.getString("userName"),
                        rs.getString("nickname"),
                        rs.getString("password"),
                        rs.getString("phoneNum"),
                        rs.getString("userEmail"),
                        rs.getInt("status"))
                );
    }

    public List<GetUserRes> getUsersByEmail(String email){
        String getUsersByEmailQuery = "select * from User where userEmail =?";
        String getUsersByEmailParams = email;
        return this.jdbcTemplate.query(getUsersByEmailQuery,
                (rs, rowNum) -> new GetUserRes(
                        rs.getInt("userIdx"),
                        rs.getString("userName"),
                        rs.getString("nickname"),
                        rs.getString("password"),
                        rs.getString("phoneNum"),
                        rs.getString("userEmail"),
                        rs.getInt("status")),
                getUsersByEmailParams);
    }

    public GetUserRes getUser(int userIdx){
        String getUserQuery = "select * from User where userIdx = ?";
        int getUserParams = userIdx;
        return this.jdbcTemplate.queryForObject(getUserQuery,
                (rs, rowNum) -> new GetUserRes(
                        rs.getInt("userIdx"),
                        rs.getString("userName"),
                        rs.getString("nickname"),
                        rs.getString("password"),
                        rs.getString("phoneNum"),
                        rs.getString("userEmail"),
                        rs.getInt("status")),
                getUserParams);
    }


    public int createUser(PostUserReq postUserReq){
        String createUserQuery = "insert into User " +
                "(userName, nickname, password, phoneNum, userEmail,status) VALUES (?,?,?,?,?,?)";
        Object[] createUserParams = new Object[]{postUserReq.getUserName(), postUserReq.getNickname(),
                postUserReq.getPassword(), postUserReq.getPhoneNum(),postUserReq.getUserEmail(),postUserReq.getStatus()};
        this.jdbcTemplate.update(createUserQuery, createUserParams);

        String lastInserIdQuery = "select last_insert_id()";
        return this.jdbcTemplate.queryForObject(lastInserIdQuery,int.class);
    }

    public int checkEmail(String email){
        String checkEmailQuery = "select exists(select userEmail from User where userEmail = ?)";
        String checkEmailParams = email;
        return this.jdbcTemplate.queryForObject(checkEmailQuery,
                int.class,
                checkEmailParams);

    }

    public int modifyUserNickName(PatchUserReq patchUserReq){
        String modifyUserNickNameQuery = "update User set nickname = ? where userIdx = ? ";
        Object[] modifyUserNameParams = new Object[]{patchUserReq.getValue(), patchUserReq.getUserIdx()};

        return this.jdbcTemplate.update(modifyUserNickNameQuery,modifyUserNameParams);
    }
    public int modifyUserPassword(PatchUserPwdReq patchUserPwdReq){
        String modifyUserPwdQuery = "update User set password = ? where userIdx = ? ";
        Object[] modifyUserNameParams = new Object[]{patchUserPwdReq.getNewPwd(), patchUserPwdReq.getUserIdx()};

        return this.jdbcTemplate.update(modifyUserPwdQuery,modifyUserNameParams);
    }

    public int modifyUserPhoneNum(PatchUserReq patchUserReq){
        String modifyUserPhoneNumQuery = "update User set phoneNum = ? where userIdx = ? ";
        Object[] modifyUserNameParams = new Object[]{patchUserReq.getValue(), patchUserReq.getUserIdx()};

        return this.jdbcTemplate.update(modifyUserPhoneNumQuery,modifyUserNameParams);
    }
    public int modifyUserEmailPromotion(PatchUserReq patchUserReq){
        String modifyUserEmailPromotionQuery = "update User set emailPromotionAgree = ? where userIdx = ? ";
        Object[] modifyUserNameParams = new Object[]{patchUserReq.getValue(), patchUserReq.getUserIdx()};

        return this.jdbcTemplate.update(modifyUserEmailPromotionQuery,modifyUserNameParams);
    }
    public int modifyUserSnsPromotion(PatchUserReq patchUserReq){
        String modifyUserSnsPromotionQuery = "update User set snsPromotionAgree = ? where userIdx = ? ";
        Object[] modifyUserNameParams = new Object[]{patchUserReq.getValue(), patchUserReq.getUserIdx()};

        return this.jdbcTemplate.update(modifyUserSnsPromotionQuery,modifyUserNameParams);
    }
    public int getStatus(PostLoginReq postLoginReq){
        String getPwdQuery = "select status from User where userEmail = ?";
        String getPwdParams = postLoginReq.getEmail();

        return this.jdbcTemplate.queryForObject(getPwdQuery,
                int.class,
                getPwdParams);


    }
    public GetUserRes getPwd(PostLoginReq postLoginReq){
        String getPwdQuery = "select userIdx, userName, nickname, password, phoneNum, userEmail, status from User where userEmail = ?";
        String getPwdParams = postLoginReq.getEmail();

        return this.jdbcTemplate.queryForObject(getPwdQuery,
                (rs,rowNum)-> new GetUserRes(
                        rs.getInt("userIdx"),
                        rs.getString("userName"),
                        rs.getString("nickname"),
                        rs.getString("password"),
                        rs.getString("phoneNum"),
                        rs.getString("userEmail"),
                        rs.getInt("status")),
                getPwdParams
                );

    }
    public String getPwdbyUserIdx(int userIdx){
        String getPwdQuery = "select password from User where userIdx = "+ userIdx ;
        return (String) this.jdbcTemplate.queryForObject(getPwdQuery,String.class);
    }

    public int deleteUser(int userIdx){
        String modifyUserEmailPromotionQuery = "update User set status = 3 where userIdx = " + userIdx;
        return this.jdbcTemplate.update(modifyUserEmailPromotionQuery);
    }
}
