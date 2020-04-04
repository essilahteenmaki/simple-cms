package lopputyo.sovellus.domain;

import javax.validation.constraints.Size;

public class SignUpForm {
	
	@Size(min=5, max=30, message="Anna 5-30 kirjainta")
	private String user;
	
	@Size(min=5, max=30, message="Anna 5-50 kirjainta")
	private String psw;
	
	@Size(min=5, max=30, message="Anna 5-50 kirjainta")
	private String pswCheck;
	
	private String role;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	public String getPswCheck() {
		return pswCheck;
	}
	public void setPswCheck(String pswCheck) {
		this.pswCheck = pswCheck;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	

}
