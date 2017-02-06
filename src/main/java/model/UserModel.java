package model;

public class UserModel {
	private String _fName;
	private String _lName;
	private String _email;
	private String _bDay;
	private String _address;
	private String _nationality;
	private String ID;
	
	public UserModel(String _fname, String _lname, String _email,
			String _bDay, String _address, String _nationality, String ID) {
		this._fName = _fname;
		this._lName = _lname;
		this._email = _email;
		this._bDay = _bDay;
		this._address = _address;
		this._nationality  = _nationality;
		this.ID = ID;
	}
	
	public String getfName() {
		return _fName;
	}
	public void setfName(String _fName) {
		this._fName = _fName;
	}
	public String getlName() {
		return _lName;
	}
	public void setlName(String _lName) {
		this._lName = _lName;
	}
	public String getEmail() {
		return _email;
	}
	public void setEmail(String _email) {
		this._email = _email;
	}
	public String getbDay() {
		return _bDay;
	}
	public void setbDay(String _bDay) {
		this._bDay = _bDay;
	}
	public String getAddress() {
		return _address;
	}
	public void setAddress(String _address) {
		this._address = _address;
	}
	public String getNationality() {
		return _nationality;
	}
	public void setNationality(String _nationality) {
		this._nationality = _nationality;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	
}
