package pkg.login;

public class LoginServiceImpl implements LoginService {
	LoginDao dao = null;
	
	public LoginServiceImpl () {
		dao = new LoginDaoImpl();
	}
	
	@Override
	public String login(LoginVO vo) {
		return dao.login(vo);
	}

}
