package com.csd.authenticator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
public class AuthenticateUserServiceTest {
	
	UserInfo userInfo, storedUserInfo, falseUserInfo, nullUserInfo, wrongPassUserInfo,usernameCaseUserInfo, passCaseUserInfo, usernameSpaceUserInfo, nulluser;
	UserDao userDao=mock(UserDao.class);
	AuthenticateUserService authUserService = new AuthenticateUserService(userDao);
	@Before
	public void setup(){		
		storedUserInfo = new UserInfo();
		storedUserInfo.setUserName("Admin");
		storedUserInfo.setPassword("1234abc");
		
		when(userDao.getUser_byName()).thenReturn((UserInfo) storedUserInfo);
	}
	
	@After
	public void cleanUp(){
		userInfo = null;
		storedUserInfo = null;
		userDao = null;
		authUserService = null;
	}
	
	//Test case 1 for if user exists
	@Test
	public void testAutheticateUser(){
		userInfo = new UserInfo();
		userInfo.setUserName("Admin");
		userInfo.setPassword("1234abc");
		
		boolean actualValue = authUserService.verifyUserInfo(userInfo);
		Mockito.verify(userDao).getUser_byName();
		
		assertTrue(actualValue);
	}
	//Case 2: Return false if user doesn't exist
	@Test
	public void testNotAuthenticateUser(){
		falseUserInfo = new UserInfo();
		falseUserInfo.setUserName("Adminstrator");
		falseUserInfo.setPassword("1234abc");
		
		boolean actualValue = authUserService.verifyUserInfo(falseUserInfo);
		Mockito.verify(userDao).getUser_byName();
		
		assertFalse(actualValue);
	}
	//Case 3: If user info is null, return null pointer exception
	@Test
	public void testNullAuthenticateUser(){
		nullUserInfo = null;
		
		boolean actualValue = authUserService.verifyUserInfo(nullUserInfo);
		
		assertFalse(actualValue);
	}
	//Case 4: User Name us correct but password is incorrect, return false
	@Test
	public void testAuthUserWrongPass(){
		wrongPassUserInfo = new UserInfo();
		wrongPassUserInfo.setUserName("Admin");
		wrongPassUserInfo.setPassword("1");
		
		boolean actualValue = authUserService.verifyUserInfo(wrongPassUserInfo);
		Mockito.verify(userDao).getUser_byName();
		
		assertFalse(actualValue);
	}
	//Case 5: Spaces in username string
	@Test
	public void testAuthUsernameSpace(){
		usernameSpaceUserInfo = new UserInfo();
		usernameSpaceUserInfo.setUserName("ADMIN  ");
		usernameSpaceUserInfo.setPassword("1234abc");
		
		boolean actualValue = authUserService.verifyUserInfo(usernameSpaceUserInfo);
		Mockito.verify(userDao).getUser_byName();
		
		assertTrue(actualValue);
	}
	//Case 6: Username is not case sensitive
	@Test
	public void testAuthUsernameCase(){
		usernameCaseUserInfo = new UserInfo();
		usernameCaseUserInfo.setUserName("ADMIN");
		usernameCaseUserInfo.setPassword("1234abc");
		
		boolean actualValue = authUserService.verifyUserInfo(usernameCaseUserInfo);
		Mockito.verify(userDao).getUser_byName();
		
		assertTrue(actualValue);
	}
	//Case 7: Password is case sensitive
	@Test
	public void testAuthPassCase(){
		passCaseUserInfo = new UserInfo();
		passCaseUserInfo.setUserName("Admin");
		passCaseUserInfo.setPassword("1234Abc");
		
		boolean actualValue = authUserService.verifyUserInfo(passCaseUserInfo);
		Mockito.verify(userDao).getUser_byName();
		
		assertFalse(actualValue);
	}
	@Test
	public void testAutheticateUserNull(){
		nulluser = new UserInfo();
		nulluser.setUserName("Admin");
		nulluser.setPassword("1234abc");
		
		when(userDao.getUser_byName()).thenReturn(null);
		boolean actualValue = authUserService.verifyUserInfo(nulluser);
		assertFalse(actualValue);
	}
}