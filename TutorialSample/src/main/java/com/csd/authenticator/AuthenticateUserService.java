package com.csd.authenticator;

public class AuthenticateUserService {
	
	UserDao userDao;
	public AuthenticateUserService(UserDao userDao) {
		this.userDao = userDao;
	}

	public boolean verifyUserInfo(UserInfo userInfo){
		try{
			UserInfo user = userDao.getUser_byName();
			if(userInfo != null){
			String key = user.getUserName().toLowerCase()+user.getPassword();
			if(key.equals(userInfo.getUserName().toLowerCase().trim()+userInfo.getPassword())){
			return true;
				}
			}
		}catch(Exception e){
		return false;
		}
		return false;
	}
}
